package com.example.travel_buddy_app.service;


import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.dto.HostDto;
import com.example.travel_buddy_app.dto.TripDto;
import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Host;
import com.example.travel_buddy_app.repositories.HostRepository;
import com.example.travel_buddy_app.repositories.TripRepository;
import com.example.travel_buddy_app.services.HostService;
import com.example.travel_buddy_app.services.TripService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HostServiceTest {




    @Autowired
    private HostService hostService;

    @Autowired
    private HostRepository hostRepo;




    @Test
    public void testUpdateHost() {
        Host host = new Host();
        host.setId(21L);
        host.setCountry("India");
        host.setCity("Hyderabad");

        String availableStartDateString = "30-06-2024";
        String availableEndDateString = "31-07-2024";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date availableStartDate = formatter.parse(availableStartDateString);
            host.setAvailableStartDate(availableStartDate);

            Date availableEndDate = formatter.parse(availableEndDateString);
            host.setAvailableEndDate(availableEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        host.setHouseType("Apartment");
        host.setUser_id(2L);

        Host updatedHost =hostService.updateHost(21L,host);
        assertEquals(host.getId(),updatedHost.getId());
        assertEquals(host.getCountry(),updatedHost.getCountry());
        assertEquals(host.getCity(),updatedHost.getCity());
        assertEquals(host.getAvailableStartDate(),updatedHost.getAvailableStartDate());
        assertEquals(host.getAvailableEndDate(),updatedHost.getAvailableEndDate());
        assertEquals(host.getHouseType(),updatedHost.getHouseType());
        assertEquals(host.getUser_id(),updatedHost.getUser_id());

    }

    @Test
    public void testUpdateTripNotFound() {
        Host host = new Host();
        host.setId(50000L);
        host.setCountry("India");
        host.setCity("Hyderabad");

        String availableStartDateString = "30-06-2024";
        String availableEndDateString = "31-07-2024";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date availableStartDate = formatter.parse(availableStartDateString);
            host.setAvailableStartDate(availableStartDate);

            Date availableEndDate = formatter.parse(availableEndDateString);
            host.setAvailableEndDate(availableEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        host.setHouseType("Apartment");
        host.setUser_id(2L);


        Host updatedHost = hostService.updateHost(50000L, host);
        assertEquals(null, updatedHost);
    }

    @Test
    public void testFindHost() {

        hostService.findHost(21L);
        assertTrue(hostRepo.existsById(21L));

    }


    @Test
    public void testFindHostNotFound() {

        assertThrows(EntityNotFoundException.class, () -> {
            hostService.findHost(100000L);
        });

    }

    @Test
    public void testFindAllHosts(){
        assertEquals(hostRepo.findAll().size(),hostService.findAllHosts().size());

    }

    @Test
    public void testDeleteHostById() {
        hostService.deleteHostById(16L);
        assertFalse(hostRepo.existsById(16L));
    }

    @Test
    public void testDeleteHostByIdNotFound(){
        assertThrows(IllegalStateException.class, () -> {
            hostService.deleteHostById(1000L);
        });

    }

    @Test
    public void testSearchHosts() {

        assertEquals(hostRepo.findHostsBySearchText("test test test test test test for search").size(),
                hostService.searchHosts("test test test test test test for search").size());
    }
    @Test
    public void testFindAll() {

        List<HostDto> foundHosts = hostService.findAll(Collections.singletonList("hehhehhe"), Collections.singletonList("hehheheh"));
        assertEquals(0, foundHosts.size());
    }




}
