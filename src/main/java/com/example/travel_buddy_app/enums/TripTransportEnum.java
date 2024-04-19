package com.example.travel_buddy_app.enums;

import lombok.Getter;

@Getter
public enum TripTransportEnum {
    CAR("Car"),
    MOTORCYCLE("Motorcycle"),
    BICYCLE("Bicycle"),
    WALKING("Walking"),
    TREKKING("Trekking"),
    BUS("Bus"),
    AIRPLANE("Airplane"),
    TRAIN("Train"),
    SHIP("Ship");

    private final String type;

    TripTransportEnum(String type) {
        this.type = type;
    }

}
