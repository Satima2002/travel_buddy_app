package com.example.travel_buddy_app.enums;

import lombok.Getter;

@Getter
public enum UserGenderEnum {
    FEMALE("Female"),
    MALE("Male");

    private final String gender;

    UserGenderEnum(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

}
