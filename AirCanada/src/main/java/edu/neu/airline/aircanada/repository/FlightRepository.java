package edu.neu.airline.aircanada.repository;

import edu.neu.airline.aircanada.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,String> {
    List<Flight> searchFlights(String departure, String destination, LocalDateTime start, LocalDateTime end);
}
