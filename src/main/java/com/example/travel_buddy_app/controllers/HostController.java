package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.dto.HostDto;
import com.example.travel_buddy_app.entities.Host;
import com.example.travel_buddy_app.services.HostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "hosts")
public class HostController {

    @Autowired
    private HostService hostService;

    @GetMapping
    public List<Host> findAllHosts(){
        return hostService.findAllHosts();
    }

//    public Host addHost(@RequestBody String host, @RequestParam(name="user-id") String user_id) throws JsonProcessingException{
//        ObjectMapper mapper = new ObjectMapper();
//        Host t = mapper.readValue(host, Host.class);
//        return hostService.saveHost(t);
//    }
    @PostMapping("/add-host")
    public Host addHost(@RequestBody Host host) {
        return hostService.saveHost(host);
    }

    @GetMapping("{id}")
    public Host getHostById(@PathVariable Long id) {
        return hostService.findHost(id);
    }

//    /filter?countries=USA&cities=New+York
//    /filter?seasonVisited=summer&countries=France
    @GetMapping("/filter")
    public List<HostDto> findAll(@RequestParam(required = false) List<String> countries,
                                     @RequestParam(required = false) List<String> cities) {
        return hostService.findAll(countries, cities);
    }

}