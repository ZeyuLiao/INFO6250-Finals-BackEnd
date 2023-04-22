package edu.neu.airline.aircanada.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchVo {
    private String departure;
    private String destination;
    private LocalDate departure_time;
}
