package com.example.travel_buddy_app.controllers;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
   // public void addNewTrip(@RequestBody Trip trip) {
       // tripService.addNewTrip(trip);
   // }
    public ResponseEntity<String> addNewTrip(@Validated @RequestBody Trip trip) {
        // Save the trip to the database or perform other actions
        tripService.addNewTrip(trip);
        return ResponseEntity.ok("Trip created successfully");
    }

    @GetMapping("/search-trip")
    public ResponseEntity<List<Trip>> searchTrips(@RequestParam String searchText) {
        List<Trip> foundTrips = tripService.searchTrips(searchText);
        if (!foundTrips.isEmpty()) {
            return ResponseEntity.ok(foundTrips);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogById(@PathVariable("id") Long id) {
        tripService.deleteTripById(id);
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.findTrip(id);
    }

}