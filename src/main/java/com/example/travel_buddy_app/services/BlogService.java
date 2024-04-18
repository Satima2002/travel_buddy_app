package com.example.travel_buddy_app.services;

import com.example.travel_buddy_app.dto.BlogDto;
import com.example.travel_buddy_app.entities.Blog;
import com.example.travel_buddy_app.entities.Trip;
import com.example.travel_buddy_app.mappers.BlogMapper;
import com.example.travel_buddy_app.repositories.BlogRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

import static com.example.travel_buddy_app.specifications.BlogSpecification.*;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Autowired
    public BlogService(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
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

    // for filtering
    public List<BlogDto> findAll(String seasonVisited,  List<String>countries, List<String> cities) {
        Specification<Blog> filters = Specification.where(StringUtils.isBlank(seasonVisited) ? null : seasonVisited(seasonVisited))
                .and(CollectionUtils.isEmpty(countries) ? null : inCountry(countries))
                .and(CollectionUtils.isEmpty(cities) ? null : inCity(cities));

        // query execution and retrieving the list of entities on specified filters from the repository
        return blogRepository.findAll(filters)
                .stream()
                .map(blogMapper::toDto)
                .toList();

    }

    public List<Blog> searchBlog(String searchText) {
        return blogRepository.findBlogsBySearchText(searchText);
    }
    public Blog updateBlog(Long id, Blog blog) {
        Optional<Blog> existingBlogOptional = blogRepository.findById(id);
        if (existingBlogOptional.isPresent()) {
            Blog existingBlog = existingBlogOptional.get();
            existingBlog.setTitle(blog.getTitle());
            existingBlog.setDescription(blog.getDescription());
            existingBlog.setCity(blog.getCity());
            existingBlog.setCountry(blog.getCountry());
            existingBlog.setSeasonVisited(blog.getSeasonVisited());
            return blogRepository.save(existingBlog);
        } else {
            return null;
        }
    }

}
