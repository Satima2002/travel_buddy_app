package com.example.travel_buddy_app.specifications;

import com.example.travel_buddy_app.entities.Blog;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static javax.management.Query.in;

public class BlogSpecification {

    public BlogSpecification() {
    }

    public static Specification<Blog> seasonVisited(String seasonVisited) {
        return (root, query, builder) -> builder.like(root.get("season"), "%" + seasonVisited + "%");
    }
    public static Specification<Blog> inCountry(List<String> countries) {
        return (root, query, builder) -> root.get("country").in(countries);
    }
    public static Specification<Blog> inCity(List<String> cities) {
        return (root, query, builder) -> root.get("city").in(cities);
    }

}