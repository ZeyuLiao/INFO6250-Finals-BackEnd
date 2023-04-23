package edu.neu.booking.ticketbooking.controller;

import edu.neu.booking.ticketbooking.entity.Order;
import edu.neu.booking.ticketbooking.entity.User;
import edu.neu.booking.ticketbooking.entity.vo.BookingRequestVo;
import edu.neu.booking.ticketbooking.entity.vo.Flights;
import edu.neu.booking.ticketbooking.entity.vo.LoginUser;
import edu.neu.booking.ticketbooking.entity.vo.SearchVo;
import edu.neu.booking.ticketbooking.service.FlightService;
import edu.neu.booking.ticketbooking.service.OrderService;
import edu.neu.booking.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping()
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/flights")
    public ResponseEntity<List<Flights>> showFlights(@RequestBody SearchVo searchVo){
        return new ResponseEntity<>(flightService.getAllFlight(searchVo), HttpStatus.OK);
    }

    @PostMapping ("/tickets")
    public ResponseEntity<?> buyTickets(@RequestBody BookingRequestVo bookingRequestVo){

        String ticket_number = flightService.buyTicket(bookingRequestVo.getFlight_number(),bookingRequestVo.getUsername());
        if(ticket_number.equals("Booking Failed")) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        LoginUser loginUser =  userService.getUserById(bookingRequestVo.getUsername());
        Order order = new Order(UUID.randomUUID().toString().replace("-", "").substring(0, 16),
            ticket_number,bookingRequestVo.getFlight_number(),
                bookingRequestVo.getDeparture(),bookingRequestVo.getDestination(),
                bookingRequestVo.getDeparture_time(),bookingRequestVo.getDuration(),bookingRequestVo.getPrice(),
                bookingRequestVo.getProxy_flight_number(),loginUser.getUsername(),loginUser.getName()
        );
        orderService.addOrder(order);
        return new ResponseEntity<>(ticket_number,HttpStatus.OK);
    }
}
