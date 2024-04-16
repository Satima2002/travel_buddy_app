package com.example.travel_buddy_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private Long id;
    private Long userID;
    private String title;
    private String country;
    private String city;
    private String seasonVisited;
    private String description;

    @Override
    public String toString() {
        return "BlogDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", seasonVisited='" + seasonVisited + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}