package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.dto.TripDto;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.mappers.TripMapper;
import com.example.travel_buddy_app.repositories.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

import static com.example.travel_buddy_app.specifications.TripSpecifications.*;

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

    public void deleteTripById(Long id) {
        boolean exists = tripRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("The trip with " + id + " does not exist");
        }
        tripRepo.deleteById(id);
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
    //public void updateDescrption(Long id, String newDesc) {
       /// Trip trip = tripRepo.findById(id)
            //    .orElseThrow(() -> new EntityNotFoundException("Blog with id " + id + " not found"));
       // trip.setDescription(newDesc);
       // tripRepo.save(trip);
   // }
    public Trip updateTrip(Long id, Trip trip) {
        Optional<Trip> existingTripOptional = tripRepo.findById(id);
        if (existingTripOptional.isPresent()) {
            Trip existingTrip = existingTripOptional.get();
            existingTrip.setDescription(trip.getDescription());
            existingTrip.setBudget(trip.getBudget());
            existingTrip.setDestinationCity(trip.getDestinationCity());
            existingTrip.setDestinationCountry(trip.getDestinationCountry());
            existingTrip.setEndDate(trip.getEndDate());
            existingTrip.setStartDate(trip.getStartDate());
            existingTrip.setTypeName(trip.getTypeName());
            return tripRepo.save(existingTrip);
        } else {
            return null;
        }
    }

    public List<TripDto> findAll(List<String>countries, List<String> cities, List<String> transports, List<String> types) {
        Specification<Trip> filters = Specification.where(CollectionUtils.isEmpty(countries) ? null : inTripCountry(countries))
                .and(CollectionUtils.isEmpty(cities) ? null : inTripCity(cities))
                .and(CollectionUtils.isEmpty(transports) ? null : inTripTransport(transports))
                .and(CollectionUtils.isEmpty(types) ? null : inTripType(types));

        // query execution and retrieving the list of entities on specified filters from the repository
        return tripRepo.findAll(filters)
                .stream()
                .map(tripMapper::toDto)
                .toList();

    }
}