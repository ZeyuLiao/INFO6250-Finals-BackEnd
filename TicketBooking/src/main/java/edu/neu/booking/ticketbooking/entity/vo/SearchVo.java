package edu.neu.booking.ticketbooking.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchVo {
    private String departure;
    private String destination;
    private LocalDate departure_time;
}
