package com.example.travel_buddy_app.repositories;

import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
    @Query(name = "getBlogById", value = "SELECT b FROM Blog b WHERE b.id = ?1")
    Optional<Blog> getBlogEntityById(Long id);

    // for filtering
    @NonNull
    Page<Blog> findAll(@NonNull Specification<Blog> spec, @NonNull Pageable pageable);
    @Query("SELECT a FROM Blog a WHERE " +
            "LOWER(a.city) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.country) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.description) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.seasonVisited) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.title) LIKE LOWER(CONCAT('%', :searchText, '%'))")

    List<Blog> findBlogsBySearchText(@Param("searchText") String searchText);

}
