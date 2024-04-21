package com.example.travel_buddy_app.repositories;



import com.example.travel_buddy_app.entities.User;

import com.example.travel_buddy_app.services.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u from User u where u.email=?1")
    User findByEmail(String email);



}