package com.example.travel_buddy_app.repositories;
import com.example.travel_buddy_app.entities.Host;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface HostRepository extends JpaRepository<Host,Long>, JpaSpecificationExecutor<Host> {
    @Query(name = "findHostByID", value = "select t from Host t where t.id=?1")
    public Optional<Host> findHostEntityByID(Long id);

    // for filtering
    @NonNull
    Page<Host> findAll(@NonNull Specification<Host> spec, @NonNull Pageable pageable);

    @Query("SELECT a FROM Host a WHERE " +
            "LOWER(a.country) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.city) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.houseType) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Host> findHostsBySearchText(@Param("searchText") String searchText);


}