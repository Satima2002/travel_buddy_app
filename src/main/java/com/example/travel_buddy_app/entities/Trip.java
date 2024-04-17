package com.example.travel_buddy_app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="trip")
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private String destinationCountry;
    private String destinationCity;
    @JsonFormat (pattern = "dd-MM-yyyy")
    private Date startDate;
    @JsonFormat (pattern = "dd-MM-yyyy")
    private Date endDate;

    private BigInteger budget;
    private String typeName;
    private String transportName;
    private String description;

    public Trip() {

    }


    public Trip(Long ID, Long userid, String destinationCountry, String destinationCity, Date startDate, Date endDate, BigInteger budget, String typeName, String transportName, String description) {
        this.id = ID;
        this.user_id = userid;
        this.destinationCountry = destinationCountry;
        this.destinationCity = destinationCity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.typeName = typeName;
        this.transportName = transportName;
        this.description = description;
    }
}