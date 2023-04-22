package edu.neu.booking.ticketbooking.controller;

import edu.neu.booking.ticketbooking.entity.vo.Flights;
import edu.neu.booking.ticketbooking.entity.vo.SearchVo;
import edu.neu.booking.ticketbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<List<Flights>> showFlights(@RequestBody SearchVo searchVo){
        return new ResponseEntity<>(flightService.getAllFlight(searchVo), HttpStatus.OK);
    }
}
