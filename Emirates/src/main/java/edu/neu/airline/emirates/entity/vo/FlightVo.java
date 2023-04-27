package edu.neu.airline.emirates.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightVo {

    private String flight_number;

    private String departure;

    private String destination;

    private Date departure_time;

    private BigDecimal duration;

    private BigDecimal  price;

    private String proxy_flight_number;

}
