package com.example.travel_buddy_app.mappers;

import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.entities.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BlogMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userID", source = "userID")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "securityLevelRating", source = "securityLevelRating")
    @Mapping(target = "seasonVisited", source = "seasonVisited")
    @Mapping(target = "description", source = "description")
    BlogDto toDto(Blog blog);
}
