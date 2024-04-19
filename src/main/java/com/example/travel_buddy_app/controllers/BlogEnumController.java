package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.enums.BlogSeasonEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/blog-season")
public class BlogEnumController {

    @GetMapping
    public ResponseEntity<List<String>> getSeasons() {
        List<String> seasons = Arrays.stream(BlogSeasonEnum.values()).map(BlogSeasonEnum::getSeason).collect(Collectors.toList());

        return ResponseEntity.ok(seasons);
    }

}
