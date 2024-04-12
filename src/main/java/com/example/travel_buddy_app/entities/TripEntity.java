package com.example.travel_buddy_app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
//@Table
@Getter
@Setter
public class TripEntity {

    @Id
    private int ID;
    private int userID;
    @JsonFormat (pattern = "dd-mm-yyyy")
    private String destCountry;
    private String destCity;
    private Date startDate;
    private Date endDate;
    private long budget;
    private String type;
    private String preferredTransport;
    private String description;


    public TripEntity() {

    }

    public TripEntity(int ID, int userID, String destCountry, String destCity, Date startDate, Date endDate, long budget, String type, String preferredTransport, String description) {
        this.ID = ID;
        this.userID = userID;
        this.destCountry = destCountry;
        this.destCity = destCity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.type = type;
        this.preferredTransport = preferredTransport;
        this.description = description;
    }
}
