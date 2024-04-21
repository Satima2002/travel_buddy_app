package com.example.travel_buddy_app.service;


import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.repositories.BlogRepository;
import com.example.travel_buddy_app.repositories.TripRepository;
import com.example.travel_buddy_app.services.BlogService;
import com.example.travel_buddy_app.services.TripService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogRepository blogRepo;

    @Test
    public void testFindAllBlogs(){
        assertEquals(blogRepo.findAll().size(),blogService.findAllBlogs().size());

    }
    @Test
    public void testGetBlogById() {

        blogService.getBlogById(10L);
        assertTrue(blogRepo.existsById(10L));

    }

    @Test
    public void testGetBlogByIdNotFound() {

        assertThrows(EntityNotFoundException.class, () -> {
            blogService.getBlogById(100000L);
        });

    }



    @Test
    public void testValidatePostBlogWithIdExists() {
        Blog blog = new Blog();

        blog.setId(1L);
        blog.setTitle("Test Title");
        blog.setCountry("Test Country");
        blog.setCity("Test City");
        blog.setSeasonVisited("Test Season");

        assertThrows(IllegalStateException.class, () -> blogService.validatePostBlog(blog));

    }

    @Test
    public void testValidatePostBlogWithNullOrEmptyValues()
    {

        Blog blog = new Blog();

        blog.setId(30L);
        blog.setTitle("");
        blog.setCountry("Test Country");
        blog.setCity("");
        blog.setSeasonVisited("Test Season");

        assertThrows(IllegalArgumentException.class, () -> blogService.validatePostBlog(blog));

    }

    @Test
    public void testDeleteBlogById() {
        blogService.deleteBlogById(15L);
        assertFalse(blogRepo.existsById(15L));
    }

    @Test
    public void testDeleteBlogByIdNotFound(){
        assertThrows(IllegalStateException.class, () -> {
            blogService.deleteBlogById(1000L);
        });

    }

    @Test
    public void testFindAll(){
        List<BlogDto> foundBlogs = blogService.findAll(String.valueOf(Collections.singletonList("hehhehhe")),
                Collections.singletonList("test"), Collections.singletonList("test"));
        assertEquals(0, foundBlogs.size());

    }

    @Test
    public void testSearchBlogs() {

        assertEquals(blogRepo.findBlogsBySearchText("test test test test test test for search").size(),
                blogService.searchBlog("test test test test test test for search").size());
    }

    @Test
    public void testUpdateBlog() {
        Blog blog = new Blog();
        blog.setId(1L);
        blog.setDescription("updated description");
        blog.setTitle("hello welcome to my blog");
        blog.setCountry("India");
        blog.setSeasonVisited("summer");
        blog.setUserID(22L);

        Blog updatedBlog =blogService.updateBlog(1L,blog);

        assertEquals(blog.getId(),updatedBlog.getId());
        assertEquals(blog.getDescription(),updatedBlog.getDescription());
        assertEquals(blog.getCountry(),updatedBlog.getCountry());
        assertEquals(blog.getCity(),updatedBlog.getCity());
        assertEquals(blog.getSeasonVisited(),updatedBlog.getSeasonVisited());
        assertEquals(blog.getTitle(),updatedBlog.getTitle());

    }

    @Test
    public void testUpdateBlogNotFound() {
        Blog blog = new Blog();
        blog.setId(1000L);
        blog.setDescription("updated description");
        blog.setTitle("hello welcome to my blog");
        blog.setCountry("India");
        blog.setSeasonVisited("summer");
        blog.setUserID(22L);

        Blog updatedBlog =blogService.updateBlog(1000L,blog);

        assertEquals(null, updatedBlog);

    }











}
