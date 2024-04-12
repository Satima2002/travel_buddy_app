package com.example.travel_buddy_app.repositories;

import com.example.travel_buddy_app.entities.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepo extends JpaRepository<TripEntity,Integer> {
    @Query(name = "findTripByID", value = "select t from TripEntity t where t.ID=?1")
    public Optional<TripEntity> findTripEntityByID(int ID);

}
