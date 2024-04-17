package com.example.travel_buddy_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HostDto {
    private Long id;
    private String country;
    private String city;
    private Date availableStartDate;
    private Date availableEndDate;
    private String houseType;
    private Long user_id;

    @Override
    public String toString() {
        return "HostDto{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", availableStartDate=" + availableStartDate +
                ", availableEndDate=" + availableEndDate +
                ", houseType='" + houseType + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
