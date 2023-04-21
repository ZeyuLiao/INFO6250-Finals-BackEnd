package edu.neu.airline.aircanada.repository;

import edu.neu.airline.aircanada.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,String> {

}
