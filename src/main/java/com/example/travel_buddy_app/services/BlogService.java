package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.repositories.BlogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(long id) {
        return blogRepository.getBlogEntityById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void addNewBlog(Blog blog) {
        Optional<Blog> newBlogOptional = blogRepository.getBlogEntityById(blog.getId());
        if (newBlogOptional.isPresent()) {
            throw new IllegalStateException("This blog id " + blog.getId() + " exists");
        }
        blogRepository.save(blog);
    }

    public void deleteBlogById(Long id) {
        boolean exists = blogRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("A blog with " + id + " does not exist");
        }
        blogRepository.deleteById(id);
    }

}
