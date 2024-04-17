package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.dto.HostDto;
import com.example.travel_buddy_app.entities.Host;
import com.example.travel_buddy_app.mappers.HostMapper;
import com.example.travel_buddy_app.repositories.HostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.example.travel_buddy_app.specifications.HostSpecification.inHostCity;
import static com.example.travel_buddy_app.specifications.HostSpecification.inHostCountry;

@Service
public class HostService {
    @Autowired
    private HostRepository hostRepo;
    private final HostMapper hostMapper;

    @Autowired
    public HostService(HostRepository hostRepo, HostMapper hostMapper) {
        this.hostRepo = hostRepo;
        this.hostMapper = hostMapper;
    }

    public Host findHost(Long id){
        return hostRepo.findHostEntityByID(id).orElseThrow(EntityNotFoundException::new);

    }

    public Host saveHost(Host host){
        return hostRepo.save(host);
    }

    public List<Host> findAllHosts(){
        return hostRepo.findAll();
    }


    // for filtering
    public List<HostDto> findAll(List<String>countries, List<String> cities) {
        Specification<Host> filters = Specification.where(CollectionUtils.isEmpty(countries) ? null : inHostCountry(countries))
                .and(CollectionUtils.isEmpty(cities) ? null : inHostCity(cities));


        // query execution and retrieving the list of entities on specified filters from the repository
        return hostRepo.findAll(filters)
                .stream()
                .map(hostMapper::toDto)
                .toList();

    }

}