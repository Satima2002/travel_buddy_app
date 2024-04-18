package com.example.travel_buddy_app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.util.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name="trip")
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    @NotBlank(message = "Destination country cannot be blank")
    private String destinationCountry;
    @NotBlank(message = "Destination city cannot be blank")
    private String destinationCity;

    @JsonFormat (pattern = "dd-MM-yyyy")
    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date must be in the past or present")
    private Date startDate;

    @JsonFormat (pattern = "dd-MM-yyyy")
    @NotNull(message = "End date cannot be null")
    @FutureOrPresent(message = "End date must be in the future or present")
    private Date endDate;

    private BigInteger budget;
    @NotBlank(message = "Name cannot be blank")
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