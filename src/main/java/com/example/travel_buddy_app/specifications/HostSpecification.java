package com.example.travel_buddy_app.specifications;

import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Host;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class HostSpecification {
    public HostSpecification() {
    }

    // specs for filtering
    public static Specification<Host> inHostCountry(List<String> countries) {
        return (root, query, builder) -> root.get("country").in(countries);
    }
    public static Specification<Host> inHostCity(List<String> cities) {
        return (root, query, builder) -> root.get("city").in(cities);
    }
}
