package com.example.travel_buddy_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogDto {
    private Long id;
    private Long userID;
    private String title;
    private String country;
    private String city;
    private String seasonVisited;
    private String description;

}