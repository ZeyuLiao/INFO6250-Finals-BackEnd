package edu.neu.airline.aircanada.repository;


import edu.neu.airline.aircanada.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,String> {
    @Query("SELECT f FROM Flight f WHERE f.departure = ?1 AND f.destination = ?2 AND FUNCTION('date', f.departure_time) = ?3")
    List<Flight> searchFlights(String departure, String destination, Date date);

    @Query("SELECT f FROM Flight f WHERE f.available_seats > f.passengers AND f.proxy_flight_number IS NULL AND f.flight_number NOT IN (SELECT p.flight_number FROM Proxy p WHERE p.proxy_company = ?1)")
    List<Flight> findFlightsByProxyCompany(String proxy_company);

    @Query("SELECT f FROM Flight f WHERE f.proxy_flight_number IS NULL")
    List<Flight> findOwnedFlights();

    @Query("SELECT f FROM Flight f WHERE f.proxy_flight_number IS NOT NULL")
    List<Flight> findProxyFlights();

    @Modifying
    @Query("DELETE FROM Flight f WHERE f.proxy_flight_number = :proxy_flight_number")
    int  deleteByProxyFlightNumber(@Param("proxy_flight_number") String proxy_flight_number);

}
