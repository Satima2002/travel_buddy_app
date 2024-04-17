package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.mappers.TripMapper;
import com.example.travel_buddy_app.repositories.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepo;
    private final TripMapper tripMapper;

    @Autowired
    public TripService(TripRepository tripRepo, TripMapper tripMapper) {
        this.tripRepo = tripRepo;
        this.tripMapper = tripMapper;
    }

    public Trip findTrip(Long id){
        return tripRepo.findTripEntityByID(id).orElseThrow(EntityNotFoundException::new);
    }

    public Trip saveTrip(Trip trip){
        return tripRepo.save(trip);
    }

    public List<Trip> findAllTrips(){
        return tripRepo.findAll();
    }

    public void addNewTrip(Trip trip) {
        Optional<Trip> newTripOptional = tripRepo.findTripEntityByID(trip.getId());
        if (newTripOptional.isPresent()) {
            throw new IllegalStateException("This trip id " + trip.getId() + " exists");
        }
        tripRepo.save(trip);
    }
    public List<Trip> searchTrips(String searchText) {
        return tripRepo.findTripsBySearchText(searchText);
    }
}