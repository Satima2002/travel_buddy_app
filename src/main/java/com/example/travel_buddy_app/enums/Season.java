package com.example.travel_buddy_app.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public enum Season {
    WINTER("winter"),
    SUMMER("summer"),
    SPRING("spring"),
    AUTUMN("autumn");

    private final String season;

    Season(String season) {
        this.season = season;
    }

    @JsonValue
    public String getSeason() {
        return season;
    }

    @JsonCreator
    public static Season fromString(String value) {
        for (Season season : Season.values()) {
            if (season.season.equalsIgnoreCase(value)) {
                return season;
            }
        }
        throw new IllegalArgumentException("Invalid Season: " + value);

    }
}
