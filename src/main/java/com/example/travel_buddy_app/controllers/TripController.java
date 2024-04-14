package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.services.TripService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/trips-dashboard")
    public List<Trip> findAllTrips(){
        return tripService.findAllTrips();
    }

    @PostMapping("/add-trip")
    public Trip addTrip(@RequestBody String trip, @RequestParam(name="user_id") String user_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Trip t = mapper.readValue(trip, Trip.class);
        return tripService.saveTrip(t);

    }

    @GetMapping("/trip/{id}")
    public Trip getTripById(@PathVariable int id) {
        return tripService.findTrip(id);
    }


}
