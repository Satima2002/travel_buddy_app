package com.example.travel_buddy_app.repositories;

import com.example.travel_buddy_app.entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long>, JpaSpecificationExecutor<Trip> {
    @Query(name = "findTripByID", value = "select t from Trip t where t.id=?1")
    public Optional<Trip> findTripEntityByID(Long ID);
    @Query("SELECT a FROM Trip a WHERE " +
            "LOWER(a.destinationCountry) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.destinationCity) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.typeName) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.transportName) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.description) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Trip> findTripsBySearchText(@Param("searchText") String searchText);

    // for filtering
    @NonNull
    Page<Trip> findAll(@NonNull Specification<Trip> spec, @NonNull Pageable pageable);


}