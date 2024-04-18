package com.example.travel_buddy_app.specifications;

import com.example.travel_buddy_app.entities.Trip;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class TripSpecifications {
    public TripSpecifications() {
    }

    public static Specification<Trip> inTripCountry(List<String> countries) {
        return (root, query, builder) -> root.get("country").in(countries);
    }
    public static Specification<Trip> inTripCity(List<String> cities) {
        return (root, query, builder) -> root.get("city").in(cities);
    }
    public static Specification<Trip> inTripTransport(List<String> transports) {
        return (root, query, builder) -> root.get("transport").in(transports);
    }
    public static Specification<Trip> inTripType(List<String> types) {
        return (root, query, builder) -> root.get("type").in(types);
    }

}
