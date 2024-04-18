//package com.example.travel_buddy_app.converters;
//
//import com.example.travel_buddy_app.enums.Season;
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//
//@Converter(autoApply = true)
//public class SeasonConverter implements AttributeConverter<Season, String> {
//
//    @Override
//    public String convertToDatabaseColumn(Season season) {
//        return season != null ? season.getSeason() : null;
//    }
//
//    @Override
//    public Season convertToEntityAttribute(String dbData) {
//        return Season.fromString(dbData);
//    }
//}