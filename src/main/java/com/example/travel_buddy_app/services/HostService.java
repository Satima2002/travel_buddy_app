package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.entities.Host;
import com.example.travel_buddy_app.repositories.HostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {
    @Autowired
    private HostRepository hostRepo;

    public Host findHost(int id){
        return hostRepo.findHostEntityByID(id).orElseThrow(EntityNotFoundException::new);

    }

    public Host saveHost(Host host){
        return hostRepo.save(host);
    }

    public List<Host> findAllHosts(){
        return hostRepo.findAll();
    }

    public Host saveHostPost(Host host){
        return hostRepo.save(host);

    }

}