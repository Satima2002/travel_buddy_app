package com.example.travel_buddy_app.controller;


import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testRegisterUser() throws Exception {
        mockMvc.perform(post("/api/auth/signup")
                        .contentType("application/json")
                        .content("{\"userName\": \"test378951\", \"firstName\": \"Test\", \"lastName\": \"User\", \"dob\": \"2000-01-01\", \"email\": \"test2266786@11aexample.com\", \"gender\": \"female\", \"password\": \"Password@1\", \"confirmPassword\": \"Password@1\", \"profilePhoto\": \"\", \"description\": \"\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        mockMvc.perform(post("/api/auth/signin")
                        .contentType("application/json")
                        .content("{\"usernameOrEmail\": \"test2\", \"password\": \"Password@1\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAuthenticateUserWithInvalidUsername() throws Exception {
        mockMvc.perform(post("/api/auth/signin")
                        .contentType("application/json")
                        .content("{\"usernameOrEmail\": \"invalid_username\", \"password\": \"Password@1\"}"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAuthenticateUserWithInvalidPassword() throws Exception {
        mockMvc.perform(post("/api/auth/signin")
                        .contentType("application/json")
                        .content("{\"usernameOrEmail\": \"test21\", \"password\": \"invalid_password\"}"))
                .andExpect(status().isUnauthorized());
    }


}