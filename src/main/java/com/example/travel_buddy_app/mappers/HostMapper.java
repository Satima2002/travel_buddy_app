package com.example.travel_buddy_app.mappers;

import com.example.travel_buddy_app.dto.HostDto;
import com.example.travel_buddy_app.entities.Host;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface HostMapper {
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "country", source = "country")
//    @Mapping(target = "city", source = "city")
//    @Mapping(target = "availableStartDate", source = "availableStartDate")
//    @Mapping(target = "availableEndDate", source = "availableEndDate")
//    @Mapping(target = "houseType", source = "houseType")
//    @Mapping(target = "user_id", source = "user_id")
    HostDto toDto(Host host);
}
