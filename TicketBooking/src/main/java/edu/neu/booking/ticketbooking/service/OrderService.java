package edu.neu.booking.ticketbooking.service;

import edu.neu.booking.ticketbooking.entity.Order;
import edu.neu.booking.ticketbooking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrderByUsername(String username) {

        return orderRepository.findByUsername(username);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }
}
