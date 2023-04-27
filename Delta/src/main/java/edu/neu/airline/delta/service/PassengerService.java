package edu.neu.airline.delta.service;


import edu.neu.airline.delta.entity.Passenger;
import edu.neu.airline.delta.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;


    public List<Passenger> findPassengersByFlight(String flight_number){


        return passengerRepository.findPassengerByFlight_number(flight_number);
    }

}
