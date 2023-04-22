package edu.neu.airline.aircanada.service;

import edu.neu.airline.aircanada.entity.Flight;
import edu.neu.airline.aircanada.entity.vo.SearchVo;
import edu.neu.airline.aircanada.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getFlightList(SearchVo searchVo){

        List<Flight> flights = new ArrayList<>();
        LocalDateTime start = LocalDateTime.of(searchVo.getDeparture_time(), LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(searchVo.getDeparture_time(), LocalTime.MAX);
        flightRepository.searchFlights(searchVo.getDeparture(), searchVo.getDestination(), start,end).forEach(flights::add);
        return flights;
    };
}
