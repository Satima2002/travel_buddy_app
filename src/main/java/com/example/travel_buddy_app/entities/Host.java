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
    @Column(name = "id")
    private Long id;

//    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private String country;
//    private HostCountryEnum country;

//    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private String city;
//    private HostCityEnum city;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "available_start_date")
    private Date availableStartDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "available_end_date")
    private Date availableEndDate;

//    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    private String houseType;
//    private HostHouseTypeEnum houseType;
    @Column(name = "user_id")
    private Long user_id;


    public Host(Long id, String country, String city, Date availableStartDate, Date availableEndDate, String houseType, Long user_id) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.availableStartDate = availableStartDate;
        this.availableEndDate = availableEndDate;
        this.houseType = houseType;
        this.user_id = user_id;
    }

    public Host() {

    }
}