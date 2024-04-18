package com.example.travel_buddy_app.mappers;
import com.example.travel_buddy_app.dto.TripDto;
import com.example.travel_buddy_app.entities.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TripMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "destinationCountry", source = "destinationCountry")
    @Mapping(target = "destinationCity", source = "destinationCity")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "budget", source = "budget")
    @Mapping(target = "typeName", source = "typeName")
    @Mapping(target = "transportName", source = "transportName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "user_id", source = "user_id")

    TripDto toDto(Trip trip);
}
