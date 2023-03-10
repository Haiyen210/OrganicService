package com.project.organic.service;

import com.project.organic.model.Category;
import com.project.organic.respository.CategoryRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    private final CategoryRespository  categoryRespository;

    @Autowired
    public CategoryService(CategoryRespository categoryRespository) {
        this.categoryRespository = categoryRespository;
    }
    public List<Category> findAllCategorys() {
        return categoryRespository.findAll();
    }
    public Category updateCategory(Category category) {
        return categoryRespository.save(category);
    }
    public void deleteCategory(int id){
    	categoryRespository.deleteById(id);
    }
    public Category addCategory(Category category) {
        return categoryRespository.save(category);
    }
    public Category findCategoryByID(int id){
        return categoryRespository.findById(id);
    }

}
