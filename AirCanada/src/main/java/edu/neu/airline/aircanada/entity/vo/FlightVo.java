package edu.neu.airline.aircanada.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightVo {

    private String flight_number;

    private String departure;

    private String destination;

    private Date departure_time;

    private String duration;

    private int price;

    private String proxy_flight_number;



}
