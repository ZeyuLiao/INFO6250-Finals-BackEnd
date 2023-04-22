package edu.neu.booking.ticketbooking.service;

import edu.neu.booking.ticketbooking.constant.Constants;
import edu.neu.booking.ticketbooking.entity.vo.Flights;
import edu.neu.booking.ticketbooking.entity.vo.SearchVo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;



@Service
public class FlightService {
    public List<Flights> getAllFlight(SearchVo searchVo){
        RestTemplate restTemplate = new RestTemplate();
        List<Flights> flights = new ArrayList<>();
        restTemplate.postForObject(Constants.AC,searchVo, List.class).forEach(item -> flights.add((Flights) item));
        return flights;
    }
}
