package com.example.travel_buddy_app.entities;

//import com.example.travel_buddy_app.enums.Season;
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
    @Column(name = "title")
    private String title;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
//    @Enumerated(EnumType.STRING)
    @Column(name = "season_visited")
    private String seasonVisited;
    @Column(name = "description")
    private String description;
    @Column(name = "user_id")
    private Long userID;

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
