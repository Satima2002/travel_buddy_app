package com.example.travel_buddy_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Array;

@Data
@AllArgsConstructor
public class CountryDto {
    private String ISOCode;
    private String name;
}