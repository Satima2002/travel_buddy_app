package com.example.travel_buddy_app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int ID;
    private int user_id;
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


    public Trip(int ID, int userid, String destinationCountry, String destinationCity, Date startDate, Date endDate, BigInteger budget, String typeName, String transportName, String description) {
        this.ID = ID;
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