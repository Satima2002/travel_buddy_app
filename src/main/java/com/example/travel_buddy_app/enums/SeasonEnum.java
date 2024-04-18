package com.example.travel_buddy_app.enums;

public enum SeasonEnum {
    SPRING("Spring"),
    WINTER("Winter"),
    AUTUMN("Autumn"),
    SUMMER ("Summer");

    private final String season;

    SeasonEnum(String displaySeason) {
        this.season = displaySeason;
    }

    public String getSeason() {
        return season;
    }
}
