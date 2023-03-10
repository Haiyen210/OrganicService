package com.project.organic.service;

import com.project.organic.model.Banner;
import com.project.organic.model.Blog;
import com.project.organic.respository.BannerRespository;
import com.project.organic.respository.BlogRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogService {
    private final BlogRespository  blogRespository;

    @Autowired
    public BlogService(BlogRespository blogRespository) {
        this.blogRespository = blogRespository;
    }
    public List<Blog> findAllBlogs() {
        return blogRespository.findAll();
    }
    public Blog updateBlog(Blog blog) {
        return blogRespository.save(blog);
    }
    public void deleteBlog(int id){
    	blogRespository.deleteById(id);
    }
    public Blog addBlog(Blog blog) {
        return blogRespository.save(blog);
    }
    public Blog findBlogByID(int id){
        return blogRespository.findById(id);
    }

}
