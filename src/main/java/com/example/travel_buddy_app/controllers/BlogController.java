package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.enums.Season;
import com.example.travel_buddy_app.errors.CustomErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

//    @PostMapping("/add-blog")
//    public void addNewBlog(@RequestBody Blog blog) {
//        blogService.addNewBlog(blog);
//    }

    @PostMapping("/add-blog")
    public ResponseEntity<?> addNewBlog(@RequestBody Blog blog) {
        try {
            if (blog.getTitle() == null || blog.getTitle().isEmpty() ||
                    blog.getCountry() == null || blog.getCountry().isEmpty() ||
                    blog.getCity() == null || blog.getCity().isEmpty()) {
                return new ResponseEntity<>("Title, country, city and season are required fields.", HttpStatus.BAD_REQUEST);
            }

            Season seasonVisited = blog.getSeasonVisited();
            if (seasonVisited != null && !isValidSeason(seasonVisited)) {
                return new ResponseEntity<>("Invalid season value. Valid options are: winter, summer, spring, autumn.", HttpStatus.BAD_REQUEST);
            }

            blogService.addNewBlog(blog);
            return new ResponseEntity<>("Blog added successfully.", HttpStatus.CREATED);
//            return ResponseEntity.badRequest().body("Title, country, city, and seasonVisited are required fields.");
        }  catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(new CustomErrorResponse("Invalid seasonVisited value. Allowed values: winter, summer, spring, autumn."));
//            return ResponseEntity.badRequest().body("Invalid season value. Allowed values: winter, summer, spring, autumn.");
        }
    }

    private boolean isValidSeason(Season season) {
        return season == Season.WINTER || season == Season.SUMMER ||
                season == Season.SPRING || season == Season.AUTUMN;
    }


    @DeleteMapping("/{id}")
    public void deleteBlogById(@PathVariable("id") Long id) {
        blogService.deleteBlogById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTitle(@PathVariable Long id, @RequestBody String newTitle) {
        blogService.updateTitle(id, newTitle);
        return ResponseEntity.ok().build();
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
