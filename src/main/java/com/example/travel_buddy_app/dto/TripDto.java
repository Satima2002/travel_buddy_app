package com.example.travel_buddy_app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripDto {
    private Long id;
    private Long user_id;
    private String destinationCountry;
    private String destinationCity;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @JsonFormat (pattern = "dd-MM-yyyy")
    private Date endDate;
    private BigInteger budget;
    private String typeName;
    private String transportName;
    private String description;


    public Long getId() {
        return id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public BigInteger getBudget() {
        return budget;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTransportName() {
        return transportName;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setBudget(BigInteger budget) {
        this.budget = budget;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
