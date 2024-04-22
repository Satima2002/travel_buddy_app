package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Host;
import com.example.travel_buddy_app.entities.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.travel_buddy_app.services.BlogService;
import java.util.List;
import java.util.List;

@Controller
@RequestMapping
public class BlogController {

    @Autowired
    private final BlogService blogService;


    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public String findAllBlogs(Model model) {
        List<Blog> allBlogs = blogService.findAllBlogs();
        // Add items to model attribute
        model.addAttribute("blogs", allBlogs);

        return "blogs"; // Return Thymeleaf template name
    }
    @GetMapping("/blog/{id}")
    public Blog getBlogById(@PathVariable("id") long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping("/blog/add-blog")
    public ResponseEntity<?> addNewBlog(@RequestBody Blog blog) {
        try {
            blogService.validatePostBlog(blog);
            blogService.addNewBlog(blog);
            return new ResponseEntity<>("Blog added successfully.", HttpStatus.CREATED);
        }  catch (IllegalArgumentException ex) {
            return new ResponseEntity<>("Title, country, city and season are required fields.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/blog/{id}")
    public void deleteBlogById(@PathVariable("id") Long id) {
        blogService.deleteBlogById(id);
    }


    @PutMapping("/blog/{id}/title")
    public ResponseEntity<Blog> updateTitle(@PathVariable Long id, @RequestBody Blog newTitle) {
        try {
            blogService.updateTitle(id, newTitle);
            return ResponseEntity.ok(newTitle);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/blog/{id}/description")
    public ResponseEntity<Blog> updateDescription(@PathVariable Long id, @RequestBody Blog newDescription) {
        try {
            blogService.updateTitle(id, newDescription);
            return ResponseEntity.ok(newDescription);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
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
    @PutMapping("/blog/{id}")
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
