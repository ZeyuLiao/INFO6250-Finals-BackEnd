package edu.neu.airline.delta.controller;


import edu.neu.airline.delta.entity.Flight;
import edu.neu.airline.delta.entity.vo.SearchVo;
import edu.neu.airline.delta.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outsideApi")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/allflights")
    public  ResponseEntity<?> getAllFlights(){
        return new ResponseEntity<>(flightService.getFlightList(),HttpStatus.OK);
    }

    @GetMapping("/availableToProxy")
    public ResponseEntity<?> getAvailableToProxy(@RequestParam String proxy_company){
        return new ResponseEntity<>(flightService.getAvailableToProxy(proxy_company),HttpStatus.OK);
    }

    @GetMapping("/ourFlights")
    public ResponseEntity<?> getOwnedFlights(){
        return new ResponseEntity<>(flightService.getOwnedFlights(),HttpStatus.OK);
    }

    @GetMapping("/theirFlights")
    public ResponseEntity<?> getProxyFlights(){
        return new ResponseEntity<>(flightService.getProxyFlights(),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String flight_number){

        flightService.delete(flight_number);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addFlight")
    public ResponseEntity<?> addFlight(@RequestBody Flight flight){

        return new ResponseEntity<>(flightService.add(flight));
    }

    // delete flight by proxy flight number
    @DeleteMapping("/deleteProxy")
    public ResponseEntity<?> deleteProxyFlight(@RequestParam String proxy_flight_number){

        flightService.deleteProxyFlight(proxy_flight_number);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights(@RequestBody SearchVo searchVo){
        return new ResponseEntity<>(flightService.getFlightList(searchVo), HttpStatus.OK);
    }

    @GetMapping("/addPassenger")
    public ResponseEntity<String> addPassenger(@RequestParam String flight_number,@RequestParam String username) throws Exception {

        return new ResponseEntity<>(flightService.addPassenger(flight_number,username), HttpStatus.OK);
    }
}
