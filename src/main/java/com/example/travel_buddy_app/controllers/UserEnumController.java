package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.enums.UserGenderEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/enum")
public class UserEnumController {

    @GetMapping("/gender")
    public ResponseEntity<List<String>> getGender() {
        List<String> genders = Arrays.stream(UserGenderEnum.values()).map(UserGenderEnum::getGender).collect(Collectors.toList());
    return ResponseEntity.ok(genders);
    }
}
