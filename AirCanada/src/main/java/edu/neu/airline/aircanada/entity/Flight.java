package edu.neu.airline.aircanada.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

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
    private String duration;

    @Column(name = "price")
    private int price;

    @Column(name = "proxy_flight_number")
    private String proxy_flight_number;



}
