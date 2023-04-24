package edu.neu.airline.aircanada.service;



import edu.neu.airline.aircanada.entity.Flight;
import edu.neu.airline.aircanada.entity.Passenger;
import edu.neu.airline.aircanada.entity.vo.SearchVo;
import edu.neu.airline.aircanada.repository.FlightRepository;
import edu.neu.airline.aircanada.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ProxyService proxyService;

    public List<Flight> getFlightList() {
        return flightRepository.findAll();
    }

    public List<Flight> getAvailableToProxy(String proxy_company){
        return flightRepository.findFlightsByProxyCompany(proxy_company);
    }

    public List<Flight> getOwnedFlights(){
        return flightRepository.findOwnedFlights();
    }

    public List<Flight> getProxyFlights(){
        return flightRepository.findProxyFlights();
    }

    public void delete(String flight_num){
        flightRepository.deleteById(flight_num);
    }

    public void add(Flight flight){
        flightRepository.save(flight);
        if(flight.getProxy_flight_number()!=null){
            String operatedAirline = flight.getProxy_flight_number().substring(0,3);

            Map<String, String> airlineUrlMap = new HashMap<>();
            airlineUrlMap.put("AC", "http://localhost:8091/addProxy?flight_number={flight_number}&company_name={company_name}");
            airlineUrlMap.put("CA", "http://localhost:8092/addProxy?flight_number={flight_number}&company_name={company_name}");
            airlineUrlMap.put("EK", "http://localhost:8093/addProxy?flight_number={flight_number}&company_name={company_name}");
            airlineUrlMap.put("LF", "http://localhost:8094/addProxy?flight_number={flight_number}&company_name={company_name}");
            airlineUrlMap.put("DL", "http://localhost:8095/addProxy?flight_number={flight_number}&company_name={company_name}");

            String URL = airlineUrlMap.get(operatedAirline);

            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> params = new HashMap<>();
            params.put("flight_number", flight.getProxy_flight_number());
            params.put("company_name", "AC");

            String response = restTemplate.getForObject(URL, String.class, params);
        }
    }

    public List<Flight> getFlightList(SearchVo searchVo){
        List<Flight> flights = new ArrayList<>();
        flightRepository.searchFlights(searchVo.getDeparture(), searchVo.getDestination(), searchVo.getDeparture_time()).forEach(flights::add);
        return flights;
    }

    public String addPassenger(String flightNumber, String username) throws Exception {
        Optional<Flight> optionalFlight = flightRepository.findById(flightNumber);

        Flight flight = optionalFlight.get();
        if (flight.getAvailable_seats() == 0) {
            throw new RuntimeException("No available seats on this flight.");
        }
        flight.setAvailable_seats(flight.getAvailable_seats() - 1);
        flight.setPassengers(flight.getPassengers() + 1);

        // while someone book a flight and then the passengers more than available seats send requests
        if(flight.getAvailable_seats()< flight.getPassengers()){
            proxyService.requestRemoveProxy(flight.getFlight_number());
        }

        flightRepository.save(flight);
        String ticket_number = generateTicketNumber();
        Passenger passenger = new Passenger();
        passenger.setTicket_number(ticket_number);
        passenger.setUsername(username);
        passenger.setTicket_number(flightNumber);
        passengerRepository.save(passenger);

        return ticket_number;
    }

    public void deleteProxyFlight(String proxy_flight_number){
        flightRepository.deleteByProxyFlightNumber(proxy_flight_number);
    }



    public String generateTicketNumber() {
        Random random = new Random();

        long timestamp = System.currentTimeMillis();
        String timestampString = Long.toString(timestamp);
        int randomStringLength = 12 - timestampString.length();
        StringBuilder sb = new StringBuilder(timestampString);
        for (int i = 0; i < randomStringLength; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return "AC"+ sb;
    }

}
