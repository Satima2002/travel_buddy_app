package com.example.travel_buddy_app.enums;

import lombok.Getter;

@Getter
public enum BlogSeasonEnum {
    SPRING("Spring"),
    WINTER("Winter"),
    AUTUMN("Autumn"),
    SUMMER ("Summer");

    private final String season;

    BlogSeasonEnum(String displaySeason) {
        this.season = displaySeason;
    }

    public String getSeason() {
        return season;
    }
}
