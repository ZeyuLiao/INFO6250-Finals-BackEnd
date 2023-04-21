package edu.neu.airline.aircanada.service;

import edu.neu.airline.aircanada.entity.Flight;
import edu.neu.airline.aircanada.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getFlightList(){
        List<Flight> flights = new ArrayList<>();
        flightRepository.findAll().forEach(flights::add);
        return flightRepository.findAll();
    };
}
