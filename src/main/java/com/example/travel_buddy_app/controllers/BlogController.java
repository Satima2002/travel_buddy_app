package com.example.travel_buddy_app.controllers;

import com.example.travel_buddy_app.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping(path = "{id}")
    public void deleteBlogById(@PathVariable("id") Long id) {
        blogService.deleteBlogById(id);
    }

}
