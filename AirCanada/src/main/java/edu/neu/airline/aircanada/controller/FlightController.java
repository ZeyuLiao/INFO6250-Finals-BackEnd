package edu.neu.airline.aircanada.controller;


import edu.neu.airline.aircanada.entity.Flight;
import edu.neu.airline.aircanada.entity.vo.SearchVo;
import edu.neu.airline.aircanada.repository.FlightRepository;
import edu.neu.airline.aircanada.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/outsideApi")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

    @PostMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights(@RequestBody SearchVo searchVo){
        return new ResponseEntity<>(flightService.getFlightList(searchVo), HttpStatus.OK);
    }
}
