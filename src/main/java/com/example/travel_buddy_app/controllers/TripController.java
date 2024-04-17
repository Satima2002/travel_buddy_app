package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.services.TripService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> findAllTrips(){
        return tripService.findAllTrips();
    }

    @PostMapping("/add-trip")
    public void addNewTrip(@RequestBody Trip trip) {
        tripService.addNewTrip(trip);
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.findTrip(id);
    }


}