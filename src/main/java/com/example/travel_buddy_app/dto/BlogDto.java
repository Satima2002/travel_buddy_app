package com.example.travel_buddy_app.dto;

//import com.example.travel_buddy_app.enums.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class BlogDto {
    private Long id;
    private String title;
    private String country;
    private String city;
    private String seasonVisited;
//    private Season seasonVisited;
    private String description;
    private Long userID;

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

    public BlogDto(Long id, String title, String country, String city, String seasonVisited, String description, Long userID) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.city = city;
        this.seasonVisited = seasonVisited;
        this.description = description;
        this.userID = userID;
    }

    public BlogDto() {
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

    public String getSeasonVisited() {
        return seasonVisited;
    }

//    public Season getSeasonVisited() {
//        return seasonVisited;
//    }

    public void setSeasonVisited(String seasonVisited) {
        this.seasonVisited = seasonVisited;
    }
//    public void setSeasonVisited(Season seasonVisited) {
//        this.seasonVisited = seasonVisited;
//    }

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