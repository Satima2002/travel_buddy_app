package com.example.travel_buddy_app.controllers;


import com.example.travel_buddy_app.dto.LoginDto;
import com.example.travel_buddy_app.dto.SignUpDto;
import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.repositories.UserRepo;
import com.example.travel_buddy_app.services.UserService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;

//import com.springboot.blog.entity.Role;
//import com.springboot.blog.entity.User;
//import com.springboot.blog.payload.LoginDto;
//import com.springboot.blog.payload.SignUpDto;
//import com.springboot.blog.repository.RoleRepository;
//import com.springboot.blog.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("customAuthenticationManager")
    private AuthenticationManager authenticationManager;



    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check for username exists in a DB
        if(userRepo.existsByUserName(signUpDto.getUserName())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepo.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        // Check if username starts with an underscore or an alphabetic character
        if (!signUpDto.getUserName().matches("^[a-zA-Z_].*")) {
            return new ResponseEntity<>("Username should start with an underscore or an alphabetic character!", HttpStatus.BAD_REQUEST);

        }
        // Check if firstName and lastName contain only alphabetic characters
        if (!signUpDto.getFirstName().matches("[a-zA-Z]+") || !signUpDto.getLastName().matches("[a-zA-Z]+")) {
            return new ResponseEntity<>("First name and last name should only contain alphabetic characters!", HttpStatus.BAD_REQUEST);
        }


        // Check if dob is in the future
        if (signUpDto.getDob().after(new Date())) {
            return new ResponseEntity<>("Date of birth cannot be in the future!", HttpStatus.BAD_REQUEST);
        }
        // Check if user is at least 18 years old
        Calendar dob = Calendar.getInstance();
        dob.setTime(signUpDto.getDob());
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (age < 18) {
            return new ResponseEntity<>("We're sorry, but you must be at least 18 years old to register. Please return on your 18th birthday.", HttpStatus.BAD_REQUEST);
        }
//
//        // Check password requirements
//        if (signUpDto.getPassword().length() < 8 || !signUpDto.getPassword().matches(".*[0-9].*") || !signUpDto.getPassword().matches(".*[a-z].*") || !signUpDto.getPassword().matches(".*[A-Z].*")) {
//            return new ResponseEntity<>("Password should contain at least 8 characters, at least one number, one lowercase letter, and one uppercase letter!", HttpStatus.BAD_REQUEST);
//        }








        // create user object
        User user = new User();
        user.setUserName(signUpDto.getUserName());
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setDob(signUpDto.getDob());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setDescription(signUpDto.getDescription());
        user.setProfilePhoto(signUpDto.getProfilePhoto());



        userRepo.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }




}