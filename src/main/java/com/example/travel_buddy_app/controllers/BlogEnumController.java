//package com.example.travel_buddy_app.controllers;
//
//import com.example.travel_buddy_app.enums.BlogCountryEnum;
//import com.example.travel_buddy_app.enums.BlogSeasonEnum;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/blogs/enum")
//public class BlogEnumController {
//
//    @GetMapping("/seasons")
//    public ResponseEntity<List<String>> getSeasons() {
//        List<String> seasons = Arrays.stream(BlogSeasonEnum.values()).map(BlogSeasonEnum::getSeason).collect(Collectors.toList());
//
//        return ResponseEntity.ok(seasons);
//    }
//        @GetMapping("/countries")
//    public ResponseEntity<List<String>> getCountries() {
//        List<String> countries = Arrays.stream(BlogCountryEnum.values()).map(BlogCountryEnum::getCountry).collect(Collectors.toList());
//
//        return ResponseEntity.ok(countries);
//    }
//        @GetMapping("/cities")
//    public ResponseEntity<List<String>> getCities() {
//        List<String> cities = Arrays.stream(BlogCityEnum.values()).map(BlogCityEnum::getCity).collect(Collectors.toList());
//
//        return ResponseEntity.ok(cities);
//    }
//
//}
