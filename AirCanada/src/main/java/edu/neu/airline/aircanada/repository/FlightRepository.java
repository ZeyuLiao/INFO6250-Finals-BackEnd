package edu.neu.airline.aircanada.repository;

import edu.neu.airline.aircanada.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,String> {
    @Query("SELECT f FROM Flight f WHERE f.departure = ?1 AND f.destination = ?2 AND FUNCTION('date', f.departure_time) = ?3")
    List<Flight> searchFlights(String departure, String destination, Date date);

}
