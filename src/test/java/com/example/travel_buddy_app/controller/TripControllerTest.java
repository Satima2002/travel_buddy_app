package com.example.travel_buddy_app.controller;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.mappers.TripMapper;
import com.example.travel_buddy_app.repositories.TripRepository;
import com.example.travel_buddy_app.services.TripService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TripControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Autowired
    private TripRepository tripRepo;

    @Test
    public void testFindAllTrips() throws Exception {

        // When & Then
        mockMvc.perform(get("/trips"))
                .andExpect(status().isOk());
    }
    @Test
    public void testAddNewTrip() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/trips/add-trip")
                        .contentType("application/json")
                        .content("{\"destination_country\": \"India\", \"destination_city\": \"Hyderabad\", \"start_date\": \"2000-01-01\", \"end_date\": \"2000-01-02\", \"budget\": 1000, \"type_name\": \"Temples\", \"transport_name\": \"Flight\", \"description\": \"Exploring the famous temples of Hyderabad\", \"user_id\": 1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateTripSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/trips/11")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"destination_country\": \"India\", \"destination_city\": \"Bangalore\", \"start_date\": \"2000-01-01\", \"end_date\": \"2000-01-02\", \"budget\": 1000, \"type_name\": \"Temples\", \"transport_name\": \"Flight\", \"description\": \"Exploring the It hub of Bangalore\", \"user_id\": 1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    public void testUpdateTripFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/trips/10000")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"destination_country\": \"India\", \"destination_city\": \"Bangalore\", \"start_date\": \"2000-01-01\", \"end_date\": \"2000-01-02\", \"budget\": 1000, \"type_name\": \"Temples\", \"transport_name\": \"Flight\", \"description\": \"Exploring the It hub of Bangalore\", \"user_id\": 1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void testDeleteTripByIdSucess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/trips/21"))
                .andExpect(status().isOk());
    }




    @Test
    public void testGetTripById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/trips/17"))
                .andExpect(status().isOk());
    }





    @Test
    public void testSearchTrips() throws Exception {

        // When & Then
        mockMvc.perform(get("/trips/search-trip").param("searchText", "Ohm Beem Bush"))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testFindAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/trips/filter")
                        .param("countries", "France")
                        .param("cities", "Paris")
                        .param("transports", "Train")
                        .param("types", "Sightseeing"))
                .andExpect(status().isOk());
    }
}



