package edu.neu.airline.emirates.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="flights")
public class Flight {
    @Id
    @Column(name="flight_number")
    private String flight_number;

    @Column(name="departure")
    private String departure;

    @Column(name="destination")
    private String destination;

    @Column(name="departure_time")
    private LocalDateTime departure_time;

    @Column(name="duration")
    private BigDecimal  duration;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "proxy_flight_number")
    private String proxy_flight_number;

    @Column(name = "available_seats")
    private int available_seats;

    @Column(name = "passengers")
    private int passengers;


}
