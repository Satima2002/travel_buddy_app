package com.example.travel_buddy_app.controllers;


import com.example.travel_buddy_app.dto.LoginDto;
import com.example.travel_buddy_app.dto.SignUpDto;
import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.repositories.UserRepo;
import com.example.travel_buddy_app.services.UserService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;

//import com.springboot.blog.entity.Role;
//import com.springboot.blog.entity.User;
//import com.springboot.blog.payload.LoginDto;
//import com.springboot.blog.payload.SignUpDto;
//import com.springboot.blog.repository.RoleRepository;
//import com.springboot.blog.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto){
        try {
            // Check if the user exists
            User user = userRepo.findByUserNameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with this username or email: " + loginDto.getUsernameOrEmail()));

            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsernameOrEmail(), loginDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Incorrect password.", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){



            if (signUpDto.getUserName() == null || signUpDto.getUserName().trim().isEmpty()) {
                throw new IllegalArgumentException("Username is mandatory");
            }
            if (signUpDto.getFirstName() == null || signUpDto.getFirstName().trim().isEmpty()) {
                throw new IllegalArgumentException("First name is mandatory");
            }
            if (signUpDto.getLastName() == null || signUpDto.getLastName().trim().isEmpty()) {
                throw new IllegalArgumentException("Last name is mandatory");
            }
            if (signUpDto.getDob() == null) {
                throw new IllegalArgumentException("Date of birth is mandatory");
            }
            if (signUpDto.getEmail() == null || signUpDto.getEmail().trim().isEmpty()) {
                throw new IllegalArgumentException("Email is mandatory");
            }
            if (signUpDto.getGender() == null || signUpDto.getGender().trim().isEmpty()) {
                throw new IllegalArgumentException("Gender is mandatory");
            }
            if (signUpDto.getPassword() == null || signUpDto.getPassword().trim().isEmpty()) {
                throw new IllegalArgumentException("Password is mandatory");
            }
            if (signUpDto.getConfirmPassword() == null || signUpDto.getConfirmPassword().trim().isEmpty()) {
                throw new IllegalArgumentException("Confirm password is mandatory");
            }


            if (!"female".equalsIgnoreCase(signUpDto.getGender())) {
                throw new IllegalArgumentException("Sorry, this is only for female travellers.");
            }
            // add check for username exists in a DB
            if(userRepo.existsByUserName(signUpDto.getUserName())){
                throw new DataIntegrityViolationException("Username is already taken!");
            }

            // add check for email exists in DB
            if(userRepo.existsByEmail(signUpDto.getEmail())){
                throw new DataIntegrityViolationException("Email is already taken!");
            }

            // Check if username starts with an underscore or an alphabetic character
            if (!signUpDto.getUserName().matches("^[a-zA-Z_].*")) {
                throw new IllegalArgumentException("Username should start with an underscore or an alphabetic character!");
            }
            // Check if firstName and lastName contain only alphabetic characters
        if (!signUpDto.getFirstName().matches("^[A-Za-z ]+$") || !signUpDto.getLastName().matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("First name and last name should only contain alphabetic characters and spaces!");
        }

//            if (!"female".equalsIgnoreCase(signUpDto.getGender())) {
//                throw new IllegalArgumentException("Sorry, this is only for female travellers.");
//            }

            // Check if dob is in the future
            if (signUpDto.getDob().after(new Date())) {
                throw new IllegalArgumentException("Date of birth cannot be in the future!");
            }
            // Check if user is at least 18 years old
            Calendar dob = Calendar.getInstance();
            dob.setTime(signUpDto.getDob());
            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            if (age < 18) {
                throw new IllegalArgumentException("We're sorry, but you must be at least 18 years old to register. Please return on your 18th birthday.");
            }

            if (signUpDto.getPassword().length() < 8 || !signUpDto.getPassword().matches(".*[A-Z].*") || !signUpDto.getPassword().matches(".*\\W.*")) {
                throw new IllegalArgumentException("Password should contain at least 8 characters, at least one uppercase letter, and at least one special character!");
            }

            // Check if password and confirmPassword match
            if (!signUpDto.getPassword().equals(signUpDto.getConfirmPassword())) {
                throw new IllegalArgumentException("Password and confirm password do not match!");
            }

            // create user object
            User user = new User();
            user.setUserName(signUpDto.getUserName());
            user.setFirstName(signUpDto.getFirstName());
            user.setLastName(signUpDto.getLastName());
            user.setDob(signUpDto.getDob());
            user.setEmail(signUpDto.getEmail());
            user.setGender(signUpDto.getGender());
            user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
            user.setDescription(signUpDto.getDescription());
            user.setProfilePhoto(signUpDto.getProfilePhoto());

            userRepo.save(user);

            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}




//    @PostMapping("/signin")
//    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//    }

//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginDto.getUsernameOrEmail(),
//                            loginDto.getPassword()
//                    )
//            );
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return new ResponseEntity<>("User signed-in successfully!", HttpStatus.OK);
//        } catch (Exception e) {
//            // You can log the exception details here if needed
//            return new ResponseEntity<>("Login failed: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }





//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
//
//        // add check for username exists in a DB
//        if(userRepo.existsByUserName(signUpDto.getUserName())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }
//
//        // add check for email exists in DB
//        if(userRepo.existsByEmail(signUpDto.getEmail())){
//            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
//        }
//        // Check if username starts with an underscore or an alphabetic character
//        if (!signUpDto.getUserName().matches("^[a-zA-Z_].*")) {
//            return new ResponseEntity<>("Username should start with an underscore or an alphabetic character!", HttpStatus.BAD_REQUEST);
//
//        }
//        // Check if firstName and lastName contain only alphabetic characters
//        if (!signUpDto.getFirstName().matches("[a-zA-Z]+") || !signUpDto.getLastName().matches("[a-zA-Z]+")) {
//            return new ResponseEntity<>("First name and last name should only contain alphabetic characters!", HttpStatus.BAD_REQUEST);
//        }
//
//        if (!"female".equalsIgnoreCase(signUpDto.getGender())) {
//            return new ResponseEntity<>("Sorry, this is only for female travellers.", HttpStatus.BAD_REQUEST);
//        }
//
//
//        // Check if dob is in the future
//        if (signUpDto.getDob().after(new Date())) {
//            return new ResponseEntity<>("Date of birth cannot be in the future!", HttpStatus.BAD_REQUEST);
//        }
//        // Check if user is at least 18 years old
//        Calendar dob = Calendar.getInstance();
//        dob.setTime(signUpDto.getDob());
//        Calendar today = Calendar.getInstance();
//        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
//        if (age < 18) {
//            return new ResponseEntity<>("We're sorry, but you must be at least 18 years old to register. Please return on your 18th birthday.", HttpStatus.BAD_REQUEST);
//        }
////
////        // Check password requirements
////        if (signUpDto.getPassword().length() < 8 || !signUpDto.getPassword().matches(".*[0-9].*") || !signUpDto.getPassword().matches(".*[a-z].*") || !signUpDto.getPassword().matches(".*[A-Z].*")) {
////            return new ResponseEntity<>("Password should contain at least 8 characters, at least one number, one lowercase letter, and one uppercase letter!", HttpStatus.BAD_REQUEST);
////        }
//
//        if (signUpDto.getPassword().length() < 8 || !signUpDto.getPassword().matches(".*[A-Z].*") || !signUpDto.getPassword().matches(".*\\W.*")) {
//            return new ResponseEntity<>("Password should contain at least 8 characters, at least one uppercase letter, and at least one special character!", HttpStatus.BAD_REQUEST);
//        }
//
//        // Check if password and confirmPassword match
//        if (!signUpDto.getPassword().equals(signUpDto.getConfirmPassword())) {
//            return new ResponseEntity<>("Password and confirm password do not match!", HttpStatus.BAD_REQUEST);
//        }
//
//
//
//
//        // create user object
//        User user = new User();
//        user.setUserName(signUpDto.getUserName());
//        user.setFirstName(signUpDto.getFirstName());
//        user.setLastName(signUpDto.getLastName());
//        user.setDob(signUpDto.getDob());
//        user.setEmail(signUpDto.getEmail());
//        user.setGender(signUpDto.getGender());
//        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//        user.setDescription(signUpDto.getDescription());
//        user.setProfilePhoto(signUpDto.getProfilePhoto());
//
//
//
//        userRepo.save(user);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//
//    }
//
//
//
//
//}