package edu.neu.airline.airchina.repository;

import edu.neu.airline.airchina.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PassengerRepository extends JpaRepository<Passenger,String> {

    @Query("SELECT f FROM Passenger f WHERE f.flight_number = :flight_number")
    List<Passenger> findPassengerByFlight_number(@Param("flight_number") String flight_number);
}
