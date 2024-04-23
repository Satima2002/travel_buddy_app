package com.example.travel_buddy_app.entities;

//import com.example.travel_buddy_app.enums.Season;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "blog")
@Getter
@Setter
@NoArgsConstructor
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
    @Column(name="security_level_rating")
    private String securityLevelRating;
    //    @Enumerated(EnumType.STRING)
    @Column(name = "season_visited")
    private String seasonVisited;
    @Column(name = "description")
    private String description;

    public Blog( String title, String country, String city,
                String securityLevelRating, String seasonVisited,
                String description) {
        super();
        this.title = title;
        this.country = country;
        this.city = city;
        this.securityLevelRating = securityLevelRating;
        this.seasonVisited = seasonVisited;
        this.description = description;

    }
}