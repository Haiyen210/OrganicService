package com.project.organic.respository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.organic.model.Blog;

public interface BlogRespository extends JpaRepository<Blog, Integer> {
	Blog findById(int id);
}
