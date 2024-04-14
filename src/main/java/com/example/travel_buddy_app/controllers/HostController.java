package com.example.travel_buddy_app.controllers;

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

    @GetMapping("/hosts-dashboard")
    public List<Host> findAllHosts(){
        return hostService.findAllHosts();
    }

    @PostMapping("/add-host")
    public Host addHost(@RequestBody String host, @RequestParam(name="user-id") String user_id) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Host t = mapper.readValue(host, Host.class);
        return hostService.saveHost(t);
    }

    @GetMapping("{id}")
    public Host getHostById(@PathVariable int id) {
        return hostService.findHost(id);
    }

}
