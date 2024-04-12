package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.entities.TripEntity;
import com.example.travel_buddy_app.repositories.TripRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepo tripRepo;

    public TripEntity findTrip(int id){
        TripEntity t = tripRepo.findTripEntityByID(id).orElseThrow(EntityNotFoundException::new);
        return t;
    }

    public List<TripEntity> findAllTrips(){
        return tripRepo.findAll();
    }



}
