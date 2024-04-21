package com.example.travel_buddy_app.controllers;
import com.example.travel_buddy_app.dto.TripDto;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.services.TripService;
import com.example.travel_buddy_app.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/trips")
    public String getTrips(Model model) {
        // Fetch list of items from backend
        List<Trip> allTrips = tripService.findAllTrips();
        // Add items to model attribute
        model.addAttribute("trips", allTrips);

        return "trips"; // Return Thymeleaf template name
    }

  //  @GetMapping
   // public List<Trip> findAllTrips(){
    //    return tripService.findAllTrips();
  //  }

    @PostMapping("/add-trip")
    public ResponseEntity<String> addNewTrip(@Validated @RequestBody Trip trip) {
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
    @PutMapping("/trip/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    @DeleteMapping("/trip/{id}")
    public void deleteTripById(@PathVariable("id") Long id) {
        tripService.deleteTripById(id);
    }

    @GetMapping("/trip/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.findTrip(id);
    }

    @GetMapping("/filter-trip")
    public List<TripDto> findAll(@RequestParam(required = false) List<String> countries,
                                 @RequestParam(required = false) List<String> cities,
                                 @RequestParam(required = false) List<String> transports,
                                 @RequestParam(required = false) List<String> types) {
        return tripService.findAll(countries, cities, transports, types);
    }

}