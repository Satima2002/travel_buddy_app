package com.example.travel_buddy_app.repo;



import com.example.travel_buddy_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    Optional<User> findByUserEmail(String userEmail);
    Optional<User> findByUserNameOrUserEmail(String userName, String userEmail);
    Optional<User> findByUserName(String userName);
    //    Boolean existsByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByUserEmail(String userEmail);



}