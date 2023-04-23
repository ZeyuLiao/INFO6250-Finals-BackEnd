package edu.neu.booking.ticketbooking.repository;
import edu.neu.booking.ticketbooking.entity.Order;
import edu.neu.booking.ticketbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUsername(String username);
}
