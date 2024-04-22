package com.example.travel_buddy_app.services;


import com.example.travel_buddy_app.dto.UserDto;
import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    public User save(UserDto userDto){
        User user = new User(userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),userDto.getGender(),passwordEncoder.encode(userDto.getPassword()),userDto.getDescription());
        return userRepo.save(user);
    }

    public User findByUsername(String email) {

        return userRepo.findByEmail(email);
    }

}