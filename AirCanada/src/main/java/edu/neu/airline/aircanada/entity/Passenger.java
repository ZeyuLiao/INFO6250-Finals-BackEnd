package edu.neu.airline.aircanada.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @Column(name = "ticket_number")
    private String ticket_number;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "flight_number")
    private String flight_number;
}
