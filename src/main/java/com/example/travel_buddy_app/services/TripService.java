package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.repositories.TripRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepo tripRepo;

    public Trip findTrip(int id){
        return tripRepo.findTripEntityByID(id).orElseThrow(EntityNotFoundException::new);
    }

    public Trip saveTrip(Trip trip){
        return tripRepo.save(trip);
    }

    public List<Trip> findAllTrips(){
        return tripRepo.findAll();
    }

    public Trip saveTripPost(Trip trip){
        return tripRepo.save(trip);

    }
}
