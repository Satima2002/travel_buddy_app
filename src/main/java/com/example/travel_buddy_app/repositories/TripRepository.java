package com.example.travel_buddy_app.repositories;

import com.example.travel_buddy_app.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    @Query(name = "findTripByID", value = "select t from Trip t where t.id=?1")
    public Optional<Trip> findTripEntityByID(int ID);

}