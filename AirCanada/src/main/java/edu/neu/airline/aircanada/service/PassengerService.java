package edu.neu.airline.aircanada.service;

import edu.neu.airline.aircanada.entity.Passenger;
import edu.neu.airline.aircanada.repository.PassengerRepository;
import edu.neu.airline.aircanada.repository.ProxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;


    public List<Passenger> findPassengersByFlight( String flight_number){


        return passengerRepository.findPassengerByFlight_number(flight_number);
    }

}
