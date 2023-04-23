package edu.neu.booking.ticketbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "ticket_number", nullable = false)
    private String ticketNumber;

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;

    @Column(name = "departure", nullable = false)
    private String departure;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "duration", nullable = false)
    private BigDecimal  duration;

    @Column(name = "price", nullable = false)
    private BigDecimal  price;

    @Column(name = "proxy_flight_number")
    private String proxyFlightNumber;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;


}
