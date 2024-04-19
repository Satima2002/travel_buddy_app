package com.example.travel_buddy_app.enums;

import lombok.Getter;

@Getter
public enum TripTypeEnum {
    ADVENTURE("Adventure"),
    LEISURE("Leisure"),
    FAMILY("Family"),
    CULTURAL("Cultural"),
    EDUCATIONAL("Educational"),
    VOLUNTEER("Volunteer"),
    MEDICAL("Medical"),
    CRUISE("Cruise"),
    ROAD_TRIP("Road trip"),
    HISTORICAL("Historical"),
    BEACH_VACATION("Beach Vacation"),
    LUXURY_TRAVEL("Luxury Travel");

    private final String type;

    TripTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
