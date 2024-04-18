package com.example.travel_buddy_app.specifications;

import com.example.travel_buddy_app.entities.Trip;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class TripSpecifications {
    public TripSpecifications() {
    }

    public static Specification<Trip> inTripCountry(List<String> countries) {
        return (root, query, builder) -> root.get("destinationCountry").in(countries);
    }
    public static Specification<Trip> inTripCity(List<String> cities) {
        return (root, query, builder) -> root.get("destinationCity").in(cities);
    }
    public static Specification<Trip> inTripTransport(List<String> transports) {
        return (root, query, builder) -> root.get("transportName").in(transports);
    }
    public static Specification<Trip> inTripType(List<String> types) {
        return (root, query, builder) -> root.get("typeName").in(types);
    }

}
