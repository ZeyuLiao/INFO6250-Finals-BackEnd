package edu.neu.airline.aircanada.service;

import edu.neu.airline.aircanada.entity.Flight;
import edu.neu.airline.aircanada.entity.Passenger;
import edu.neu.airline.aircanada.entity.vo.SearchVo;
import edu.neu.airline.aircanada.repository.FlightRepository;
import edu.neu.airline.aircanada.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getFlightList() {
        return flightRepository.findAll();
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
        flightRepository.save(flight);
        String ticket_number = generateTicketNumber();
        Passenger passenger = new Passenger();
        passenger.setTicketNumber(ticket_number);
        passenger.setUsername(username);
        passenger.setFlightNumber(flightNumber);
        passengerRepository.save(passenger);

        return ticket_number;
    }

    public static String generateTicketNumber() {
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
