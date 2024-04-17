package com.example.travel_buddy_app.repositories;

import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    @Query(name = "findTripByID", value = "select t from Trip t where t.id=?1")
    public Optional<Trip> findTripEntityByID(Long ID);

    @NonNull
    Page<Trip> findAll(@NonNull Specification<Trip> spec, @NonNull Pageable pageable);
}