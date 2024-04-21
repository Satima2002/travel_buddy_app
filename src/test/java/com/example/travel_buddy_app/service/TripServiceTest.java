package com.example.travel_buddy_app.service;


import com.example.travel_buddy_app.dto.TripDto;
import com.example.travel_buddy_app.entities.Host;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.mappers.TripMapper;
import com.example.travel_buddy_app.repositories.HostRepository;
import com.example.travel_buddy_app.repositories.TripRepository;
import com.example.travel_buddy_app.services.HostService;
import com.example.travel_buddy_app.services.TripService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class TripServiceTest {

    @Autowired
    private TripService tripService;

    @Autowired
    private TripRepository tripRepo;




    @Test
    public void testUpdateTrip() {

        Trip trip = new Trip();
        trip.setId(12L);
        trip.setDestinationCountry("TestCountry");
        trip.setDestinationCity("TestCity");
        String startDateString = "2000-10-23";
        String endDateString = "2000-10-23";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = formatter.parse(startDateString);
            trip.setStartDate(startDate);
            Date endDate = formatter.parse(endDateString);
            trip.setEndDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        trip.setBudget(BigInteger.valueOf(1000));
        trip.setTypeName("TestType");
        trip.setTransportName("Flignnht");
        trip.setDescription("TestDescription");
        trip.setUser_id(9L);


        Trip updatedTrip = tripService.updateTrip(12L, trip);
        System.out.println("from test"+trip);
        System.out.println("from service"+updatedTrip);
        assertEquals(trip.getId(), updatedTrip.getId());
        assertEquals(trip.getDestinationCountry(), updatedTrip.getDestinationCountry());
        assertEquals(trip.getDestinationCity(), updatedTrip.getDestinationCity());
        assertEquals(trip.getStartDate(), updatedTrip.getStartDate());
        assertEquals(trip.getEndDate(), updatedTrip.getEndDate());
        assertEquals(trip.getBudget(), updatedTrip.getBudget());
        assertEquals(trip.getTypeName(), updatedTrip.getTypeName());
        assertEquals(trip.getTransportName(), updatedTrip.getTransportName());
        assertEquals(trip.getDescription(), updatedTrip.getDescription());
        assertEquals(trip.getUser_id(), updatedTrip.getUser_id());

    }

    @Test
    public void testUpdateTripNotFound() {
        Trip trip = new Trip();
        trip.setDestinationCountry("TestCountry");
        trip.setDestinationCity("TestCity");
        String startDateString = "2000-10-23";
        String endDateString = "2000-10-23";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = formatter.parse(startDateString);
            trip.setStartDate(startDate);
            Date endDate = formatter.parse(endDateString);
            trip.setEndDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        trip.setBudget(BigInteger.valueOf(1000));
        trip.setTypeName("TestType");
        trip.setTransportName("TestTransport");
        trip.setDescription("TestDescription");
        trip.setUser_id(1L);


        Trip updatedTrip = tripService.updateTrip(100000L, trip);
        assertEquals(null, updatedTrip);
    }


    @Test
    public void testFindTrip() {

        tripService.findTrip(15L);
        assertTrue(tripRepo.existsById(15L));

    }

    @Test
    public void testFindTripNotFound() {

        assertThrows(EntityNotFoundException.class, () -> {
            tripService.findTrip(100000L);
        });

    }

    @Test
    public void testDeleteTripById() {
        tripService.deleteTripById(37L);
        assertFalse(tripRepo.existsById(37L));
    }

    @Test
    public void testDeleteTripByIdNotFound(){
        assertThrows(IllegalStateException.class, () -> {
            tripService.deleteTripById(100000L);
        });

    }

    @Test
    public void testSearchTrips() {

        assertEquals(tripRepo.findTripsBySearchText("Trip to Paris for sightseeing").size(),
                tripService.searchTrips("Trip to Paris for sightseeing").size());
    }

    @Test
    public void testFindAllTrips(){
        assertEquals(tripRepo.findAll().size(),tripService.findAllTrips().size());
    }

    @Test
    public void testFindAll(){
        List<TripDto> foundTrips = tripService.findAll(Collections.singletonList("ohm beem bush"), Collections.singletonList("test"),
                Collections.singletonList("ohm beem bush"), Collections.singletonList("ohm beem bush"));
        assertEquals(0, foundTrips.size());

    }
}





