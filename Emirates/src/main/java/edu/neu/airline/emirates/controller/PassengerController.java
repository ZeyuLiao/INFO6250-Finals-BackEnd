package edu.neu.airline.emirates.controller;


import edu.neu.airline.emirates.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping("/passengers")
    public ResponseEntity<?> getPassengers(@RequestParam("flight_number") String flight_number) {
        return new ResponseEntity<>(passengerService.findPassengersByFlight(flight_number), HttpStatus.OK);

    }


}
