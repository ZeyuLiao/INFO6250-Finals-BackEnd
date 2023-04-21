package edu.neu.airline.aircanada.controller;


import edu.neu.airline.aircanada.entity.Flight;
import edu.neu.airline.aircanada.repository.FlightRepository;
import edu.neu.airline.aircanada.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/outsideApi")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights(){
        return new ResponseEntity<>(flightService.getFlightList(), HttpStatus.OK);
    }
}
