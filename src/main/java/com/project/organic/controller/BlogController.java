package com.project.organic.controller;

import com.project.organic.model.Blog;
import com.project.organic.respository.BannerRespository;
import com.project.organic.service.BannerService;
import com.project.organic.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    BannerRespository blogRespository;
    private final BlogService blogService;


    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.findAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);

    }
    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id) {
    	Blog blog = blogService.findBlogByID(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @PostMapping("/blogs")
    public ResponseEntity<Blog> createBanner(@RequestBody Blog blog) {
    	Blog newBlog =blogService.addBlog(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
    }
    @PutMapping("/blogs/update")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
    	Blog updateBlog = blogService.updateBlog(blog);
        return new ResponseEntity<>(updateBlog, HttpStatus.OK);
    }
    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable("id") int id) {
        if (blogService.findBlogByID(id)!=null){
        	blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
