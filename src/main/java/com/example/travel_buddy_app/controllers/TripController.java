package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.entities.TripEntity;
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
    public List<TripEntity> findAllTrips(){
        return tripService.findAllTrips();
    }

    @PostMapping("/add-trip")
    public TripEntity addTrip(@RequestBody String trip, @RequestParam(name="user_id") String user_id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TripEntity t = mapper.readValue(trip, TripEntity.class);
        return tripService.saveTrip(t);

    }

    @GetMapping ("/find-trip")
    public TripEntity findTrip(@RequestParam(name = "trip_id") int id){
        return tripService.findTrip(id);
    }


}
