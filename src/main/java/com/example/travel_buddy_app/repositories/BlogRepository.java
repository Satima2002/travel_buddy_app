package com.example.travel_buddy_app.repositories;

import com.example.travel_buddy_app.entities.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
    @Query(name = "getBlogById", value = "SELECT b FROM Blog b WHERE b.id = ?1")
    Optional<Blog> getBlogEntityById(Long id);

    Page<Blog> findAll(Specification<Blog> spec, Pageable pageable);
}
