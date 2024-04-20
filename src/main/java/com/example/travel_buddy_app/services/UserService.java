package com.example.travel_buddy_app.services;


import com.example.travel_buddy_app.dto.LoginDto;
import com.example.travel_buddy_app.dto.SignUpDto;
import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.enums.UserGenderEnum;
import com.example.travel_buddy_app.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepo.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));

        // Since there are no roles, we'll create an empty collection for the authorities
        Set<GrantedAuthority> authorities = Collections.emptySet();

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                authorities);
    }

    public ResponseEntity<?> registerUser(SignUpDto signUpDto) {
        validateSignUpDto(signUpDto);
        User user = createUserFromSignUpDto(signUpDto);
        userRepo.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    private void validateSignUpDto(SignUpDto signUpDto) {

        checkUsername(signUpDto.getUserName());
        checkEmail(signUpDto.getEmail());
        checkGender(signUpDto.getGender());
        checkName(signUpDto.getFirstName(), "First name");
        checkName(signUpDto.getLastName(), "Last name");
        checkDob(signUpDto.getDob());
        checkPassword(signUpDto.getPassword(), signUpDto.getConfirmPassword());
        checkGender(signUpDto.getGender());
    }
    private void checkUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is mandatory");
        }
        if (userRepo.existsByUserName(username)) {
            throw new IllegalArgumentException("Username is already taken");
        }
        if (!username.matches("^[a-zA-Z_][a-zA-Z0-9_]*$")) {
            throw new IllegalArgumentException("Username should start with an underscore or any alphabetic character");
        }
    }

    private void checkEmail(String email) {
        if (userRepo.existsByEmail(email)) {
            throw new IllegalArgumentException("Email is already taken");
        }
    }

    private void checkName(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is mandatory");
        }
        if (!name.matches("^[a-zA-Z ]*$")) {
            throw new IllegalArgumentException(fieldName + " must only contain alphabetic characters, spaces");
        }
    }

    private void checkDob(Date dob) {
        if (dob == null) {
            throw new IllegalArgumentException("Date of birth is mandatory");
        }
        if (dob.after(new Date())) {
            throw new IllegalArgumentException("Date of birth cannot be in future");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        if (dob.after(calendar.getTime())) {
            throw new IllegalArgumentException("The user must be at least 18 years old to register");
        }
    }

    private void checkPassword(String password, String confirmPassword) {
        if (password == null || !password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W]).{8,}$")) {
            throw new IllegalArgumentException("Password must contain at least 8 letters, one capital letter, any special character");
        }
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Password and confirm password must match");
        }
    }
    private void checkGender(String gender) {
        if ("male".equalsIgnoreCase(gender)) {
            throw new IllegalArgumentException("Sorry, this is only for female travellers");
        }
    }


    private User createUserFromSignUpDto(SignUpDto signUpDto) {
        User user = new User();
        user.setUserName(signUpDto.getUserName());
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setDob(signUpDto.getDob());
        user.setEmail(signUpDto.getEmail());
        user.setGender(UserGenderEnum.valueOf(signUpDto.getGender().toUpperCase()));
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setDescription(signUpDto.getDescription());
        user.setProfilePhoto(signUpDto.getProfilePhoto());
        return user;
    }



}