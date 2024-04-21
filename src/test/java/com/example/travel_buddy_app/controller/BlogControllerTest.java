package com.example.travel_buddy_app.controller;

import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.services.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogControllerTest {
    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private BlogService blogService;


    @Test
    public void testFindAllBlogs() throws Exception {

        // When & Then
        mockMvc.perform(get("/blogs"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetBlogByIdSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/blogs/8"))
                .andExpect(status().isOk());
    }



    @Test
    public void testAddNewBlogSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/blogs/add-blog")
                        .contentType("application/json")
                        .content("{\"userId\": 2, \"title\": \"City break in paris\", \"country\": \"France\", \"city\": \"Paris\", \"seasonVisited\": \"spring\", \"description\": \"Exploring the famous temples of Hyderabad\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Blog added successfully."));
    }



    @Test
    public void testAddNewBlogFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/blogs/add-blog")
                        .contentType("application/json")
                        .content("{\"userId\": 2, \"title\": \"\", \"country\": \"\", \"seasonVisited\": \"spring\", \"description\": \"Exploring the famous temples of Hyderabad\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Title, country, city and season are required fields."));

    }

    @Test
    public void testDeleteBlogByIdSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/blogs/14"))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateBlogSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/blogs/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"test title\", \"country\": \"test France\", \"city\": \"test paris\", \"seasonVisited\": \"test winter\", \"description\": \"welcome to test case\", \"userId\": 22}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    public void testUpdateBlogFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/blogs/1000")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"test title\", \"country\": \"test France\", \"city\": \"test paris\", \"seasonVisited\": \"test winter\", \"description\": \"welcome to test case\", \"userId\": 22}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }



    @Test
    public void testBlogsFindAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/blogs/filter")
                        .param("seasonVisited", "winter")
                        .param("countries", "France")
                        .param("cities", "Paris"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchBlogsFailure() throws Exception {

        // When & Then
        mockMvc.perform(get("/blogs/search-blog").param("searchText", "Ohm Beem Bush"))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testSearchBlogsSuccess() throws Exception {

        // When & Then
        mockMvc.perform(get("/blogs/search-blog").param("searchText", "test test test test test test for search"))
                .andExpect(status().isOk());

    }


}
