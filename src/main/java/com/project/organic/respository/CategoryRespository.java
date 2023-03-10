package com.project.organic.respository;

import com.project.organic.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Integer> {
	Category findById(int id);
}
