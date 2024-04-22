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
    private String title;
    private String country;
    private String city;
    private String  securityLevelRating;
    private String seasonVisited;
    private String description;
    private Long userID;

    @Override
    public String toString() {
        return "BlogDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", securityLevelRating='" + securityLevelRating + '\'' +
                ", seasonVisited='" + seasonVisited + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSecurityLevelRating() {
        return securityLevelRating;
    }

    public void setSecurityLevelRating(String securityLevelRating) {
        this.securityLevelRating = securityLevelRating;
    }

    public String getSeasonVisited() {
        return seasonVisited;
    }

    public void setSeasonVisited(String seasonVisited) {
        this.seasonVisited = seasonVisited;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}