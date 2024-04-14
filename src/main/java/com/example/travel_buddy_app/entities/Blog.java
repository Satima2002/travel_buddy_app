package com.example.travel_buddy_app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "blog")
@Getter
@Setter
public class Blog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userID;
    private String title;
    private String country;
    private String city;
    private String seasonVisited;
    private String description;

    public Blog() {
    }

    public Blog(Long id,Long userID, String title, String country, String city, String seasonVisited, String description) {
        this.id = id;
        this.userID=userID;
        this.title = title;
        this.country = country;
        this.city = city;
        this.seasonVisited = seasonVisited;
        this.description = description;
    }
}
