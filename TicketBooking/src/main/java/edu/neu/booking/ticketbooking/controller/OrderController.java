package edu.neu.booking.ticketbooking.controller;

import edu.neu.booking.ticketbooking.entity.Order;
import edu.neu.booking.ticketbooking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<?> getOrderByUsername(@RequestParam("username") String username) {

        return new ResponseEntity<>(orderService.getOrderByUsername(username), HttpStatus.OK);
    }
}