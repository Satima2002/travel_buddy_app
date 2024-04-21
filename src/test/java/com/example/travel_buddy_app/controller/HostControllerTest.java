package com.example.travel_buddy_app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAllHosts() throws Exception {

        // When & Then
        mockMvc.perform(get("/hosts"))
                .andExpect(status().isOk());

    }

    @Test
    public void testAddNewHost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hosts/add-host")
                        .contentType("application/json")
                        .content("{\"user_id\": 2, \"city\": \"Hyderabad\", \"country\": \"India\", \"availableStartDate\": \"30-04-2023\", \"availableEndDate\": \"09-05-2023\", \"houseType\": \"Apartment\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateHostSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/hosts/1")
                        .contentType("application/json")
                        .content("{\"user_id\": 2, \"cteststts\": \"Hyderabad\", \"country\": \"India\", \"availableStartDate\": \"30-04-2023\", \"availableEndDate\": \"09-05-2023\", \"houseType\": \"Apartment\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());

    }

    @Test
    public void testUpdateHostFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/hosts/10000")
                        .contentType("application/json")
                        .content("{\"user_id\": 2, \"cteststts\": \"Hyderabad\", \"country\": \"India\", \"availableStartDate\": \"30-04-2023\", \"availableEndDate\": \"09-05-2023\", \"houseType\": \"Apartment\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }
    @Test
    public void testGetHostByIdSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hosts/7"))
                .andExpect(status().isOk());
    }


    @Test
    public void testDeleteHostByIdSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/hosts/5"))
                .andExpect(status().isOk());
    }





    @Test
    public void testHostsFindAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hosts/filter")
                        .param("countries", "France")
                        .param("cities", "Paris"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchHostFailure() throws Exception {

        // When & Then
        mockMvc.perform(get("/hosts/search-host").param("searchText", "Ohm Beem Bush"))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testSearchHostSuccess() throws Exception {

        // When & Then
        mockMvc.perform(get("/hosts/search-host").param("searchText", "test test test test test test for search"))
                .andExpect(status().isOk());

    }







}
