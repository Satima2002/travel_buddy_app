package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.dto.CountryDto;
import com.example.travel_buddy_app.entities.Host;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "countries")
public class CountryController {

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries(){
        final List<CountryDto> countries = new ArrayList<>();

        for (final String isoCountry : Locale.getISOCountries()) {
            final Locale locale = new Locale("", isoCountry);
            countries.add((new CountryDto(locale.getCountry(), locale.getDisplayCountry())));
        }

        return ResponseEntity.ok(countries);
    }
}