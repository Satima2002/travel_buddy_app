package com.example.travel_buddy_app.service;

import com.example.travel_buddy_app.dto.SignUpDto;
import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.repositories.UserRepo;
import com.example.travel_buddy_app.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void testRegisterUser() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUserName("tilluukanna");
        signUpDto.setFirstName("Test");
        signUpDto.setLastName("User");
        //signUpDto.setDob("2000-10-23");

        // Parse the date string into a Date object
        String dobString = "2000-10-23";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("Tilluukanna@example.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password@1");
        signUpDto.setConfirmPassword("Password@1");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");

        when(userRepo.existsByUserName(signUpDto.getUserName())).thenReturn(false);
        when(userRepo.existsByEmail(signUpDto.getEmail())).thenReturn(false);

        ResponseEntity<?> response = userService.registerUser(signUpDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



    @Test
    public void testRegisterUserWithExistingUsername() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUserName("test");
        signUpDto.setFirstName("Test");
        signUpDto.setLastName("User");

        // Parse the date string into a Date object
        String dobString = "2000-10-23";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setDob(new Date());
        signUpDto.setEmail("test@gmail.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password1");
        signUpDto.setConfirmPassword("Password1");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");

        when(userRepo.existsByUserName(signUpDto.getUserName())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }

    @Test
    public void testRegisterUserWithExistingEmail() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUserName("picu");
        signUpDto.setFirstName("Test");
        signUpDto.setLastName("User");
        // Parse the date string into a Date object
        String dobString = "2000-10-23";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("test@example.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password1");
        signUpDto.setConfirmPassword("Password1");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");

        when(userRepo.existsByUserName(signUpDto.getUserName())).thenReturn(false);
        when(userRepo.existsByEmail(signUpDto.getEmail())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }

    @Test
    public void testRegisterUserWithInvalidUsername() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUserName("1_invalid_username"); // Starts with a number, not an underscore or alphabetic character
        signUpDto.setFirstName("Navya");
        signUpDto.setLastName("Tanguturi");

        // Parse the date string into a Date object
        String dobString = "2000-08-15";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("tanguturinavya@gmail.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password@6");
        signUpDto.setConfirmPassword("Password@6");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }

    @Test
    public void testRegisterUserWithInvalidFirstName() {
        SignUpDto signUpDto = new SignUpDto();

        signUpDto.setUserName("Satyavathi@6");
        signUpDto.setFirstName("Satyavathi6"); // should contain only alphabetic characters and spaces
        signUpDto.setLastName("Tanguturi");

        // Parse the date string into a Date object
        String dobString = "1978-12-16";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        signUpDto.setEmail("satyavathikundenapally@gmail.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password@6");
        signUpDto.setConfirmPassword("Password@6");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }

    @Test
    public void testRegisterUserWithFutureDob() {
        SignUpDto signUpDto = new SignUpDto();

        signUpDto.setUserName("veeraiah@6");
        signUpDto.setFirstName("Veeraiah");
        signUpDto.setLastName("Tanguturi");

        // Parse the date string into a Date object
        String dobString = "2028-12-16";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("satyavathikundenapally@gmail.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password@6");
        signUpDto.setConfirmPassword("Password@6");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");


        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }


    @Test
    public void testRegisterUserUnder18() {
        SignUpDto signUpDto = new SignUpDto();

        signUpDto.setUserName("veeraiah@6");
        signUpDto.setFirstName("Veeraiah");
        signUpDto.setLastName("Tanguturi");

        // Parse the date string into a Date object
        String dobString = "2020-12-16";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("satyavathikundenapally@gmail.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password@6");
        signUpDto.setConfirmPassword("Password@6");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }

    @Test
    public void testRegisterUserWithInvalidPassword() {
        SignUpDto signUpDto = new SignUpDto();


        signUpDto.setUserName("veeraiah@6");
        signUpDto.setFirstName("Veeraiah");
        signUpDto.setLastName("Tanguturi");

        // Parse the date string into a Date object
        String dobString = "2000-12-16";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("satyavathikundenapally@gmail.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("password"); // Does not meet complexity requirements
        signUpDto.setConfirmPassword("password");
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");


        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }

    @Test
    public void testRegisterUserWithMismatchedPasswords() {
        SignUpDto signUpDto = new SignUpDto();


        signUpDto.setUserName("veeraiah@6");
        signUpDto.setFirstName("Veeraiah");
        signUpDto.setLastName("Tanguturi");

        // Parse the date string into a Date object
        String dobString = "2000-12-16";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("satyavathikundenapally@gmail.com");
        signUpDto.setGender("female");
        signUpDto.setPassword("Password@1");
        signUpDto.setConfirmPassword("Password@2"); // Does not match password
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");


        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }

    @Test
    public void testRegisterUserWithGenderAsMale() {
        SignUpDto signUpDto = new SignUpDto();


        signUpDto.setUserName("veeraiah@6");
        signUpDto.setFirstName("Veeraiah");
        signUpDto.setLastName("Tanguturi");

        // Parse the date string into a Date object
        String dobString = "2000-12-16";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = formatter.parse(dobString);
            signUpDto.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        signUpDto.setEmail("satyavathikundenapally@gmail.com");
        signUpDto.setGender("male");
        signUpDto.setPassword("Password@2");
        signUpDto.setConfirmPassword("Password@2"); // Does not match password
        signUpDto.setProfilePhoto("");
        signUpDto.setDescription("");


        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(signUpDto));
    }




}



