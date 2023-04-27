package edu.neu.airline.airchina.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchVo {
    private String departure;
    private String destination;
    private Date departure_time;
}
