package edu.neu.booking.ticketbooking.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestVo {
    private String username;
    private String flight_number;

    private String departure;

    private String destination;

    private LocalDateTime departure_time;

    private BigDecimal duration;

    private BigDecimal  price;

    private String proxy_flight_number;
}
