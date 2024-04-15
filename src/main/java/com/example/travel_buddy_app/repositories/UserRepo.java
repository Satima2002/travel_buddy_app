package com.example.travel_buddy_app.repositories;



import com.example.travel_buddy_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String userName, String email);
    Optional<User> findByUserName(String userName);
    //    Boolean existsByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);



}