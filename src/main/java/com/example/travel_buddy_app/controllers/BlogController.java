package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.travel_buddy_app.services.BlogService;
import java.util.List;

@RestController
@RequestMapping(path = "blogs")
public class BlogController {

    @Autowired
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> findAllBlogs() {
        return blogService.findAllBlogs();
    }
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable("id") long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping("/add-blog")
    public void addNewBlog(@RequestBody Blog blog) {
        blogService.addNewBlog(blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogById(@PathVariable("id") Long id) {
        blogService.deleteBlogById(id);
    }

    @GetMapping("/search-blog")
    public ResponseEntity<List<Blog>> searchBlogs(@RequestParam String searchText) {
        List<Blog> foundTrips = blogService.searchBlog(searchText);
        if (!foundTrips.isEmpty()) {
            return ResponseEntity.ok(foundTrips);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }

//    /filter?seasonVisited=winter: Retrieves blogs visited in the winter season.
//    /filter?countries=USA&cities=New+York: Retrieves blogs from the USA, specifically from New York City.
//    /filter?seasonVisited=summer&countries=France: Retrieves blogs visited in the summer season and located in France.
    @GetMapping("/filter")
    public List<BlogDto> findAll(@RequestParam(required = false) String seasonVisited,
                                 @RequestParam(required = false) List<String> countries,
                                 @RequestParam(required = false) List<String> cities) {
        return blogService.findAll(seasonVisited, countries, cities);
    }

}
