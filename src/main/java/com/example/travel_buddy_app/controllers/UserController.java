package com.example.travel_buddy_app.controllers;


import com.example.travel_buddy_app.dto.LoginDto;
import com.example.travel_buddy_app.dto.SignUpDto;
import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.repositories.UserRepo;
import com.example.travel_buddy_app.services.UserService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if(userRepo.existsByUserEmail(signUpDto.getUserEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setUserName(signUpDto.getUserName());
        user.setUserSurname(signUpDto.getUserSurname());
        user.setUserEmail(signUpDto.getUserEmail());
        user.setDob(signUpDto.getDob());
        user.setUserDescription(signUpDto.getUserDescription());
        user.setUserPassword(passwordEncoder.encode(signUpDto.getUserPassword()));



        userRepo.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }




}