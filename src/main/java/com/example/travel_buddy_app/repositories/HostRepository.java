package com.example.travel_buddy_app.repositories;

import com.example.travel_buddy_app.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HostRepository extends JpaRepository<Host,Long> {
    @Query(name = "findHostByID", value = "select t from Host t where t.id=?1")
    public Optional<Host> findHostEntityByID(int id);
}