package edu.neu.airline.aircanada.repository;


import edu.neu.airline.aircanada.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PassengerRepository extends JpaRepository<Passenger,String> {
}
