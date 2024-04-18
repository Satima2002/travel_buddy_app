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
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "destination_country")
    private String destinationCountry;
    @Column(name = "destination_city")
    private String destinationCity;

    @JsonFormat (pattern = "dd-MM-yyyy")
    @Column(name = "start_date")
    private Date startDate;

    @JsonFormat (pattern = "dd-MM-yyyy")
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "budget")
    private BigInteger budget;
    @Column(name = "type_name")
    private String typeName;
    @Column(name = "transport_name")
    private String transportName;
    @Column(name = "description")
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