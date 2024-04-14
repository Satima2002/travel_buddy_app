package com.example.travel_buddy_app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="host")
@Getter
@Setter
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private String city;
    private String country;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date availableStartDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date availableEndDate;
    private String houseType;


    public Host(int id, long user_id, String city, String country, Date availableStartDate, Date availableEndDate, String houseType) {
        this.id = id;
        this.user_id = user_id;
        this.city = city;
        this.country = country;
        this.availableStartDate = availableStartDate;
        this.availableEndDate = availableEndDate;
        this.houseType = houseType;
    }

    public Host() {

    }
}