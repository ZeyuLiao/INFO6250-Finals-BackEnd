package edu.neu.booking.ticketbooking.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flights {
    private String flight_number;

    private String departure;

    private String destination;

    private LocalDateTime departure_time;

    private String duration;

    private int price;

    private String proxy_flight_number;
}
