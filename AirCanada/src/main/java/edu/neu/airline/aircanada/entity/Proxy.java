package edu.neu.airline.aircanada.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="proxy")
@NoArgsConstructor
@AllArgsConstructor
public class Proxy {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="flight_number")
    private String flight_number;

    @Column(name="proxy_company")
    private String proxy_company;

}

