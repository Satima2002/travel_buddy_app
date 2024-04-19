package com.example.travel_buddy_app.enums;

import lombok.Getter;

@Getter
public enum HostHouseTypeEnum {
    APARTMENT("Apartment"),
    DETACHED_HOUSE("Detached house"),
    TOWNHOUSE("Townhouse"),
    BUNGALOW("Bungalow"),
    SEMI_DETACHED_HOUSE("Semi-detached house");

    private final String type;

    HostHouseTypeEnum(String type) {
        this.type = type;
    }

}
