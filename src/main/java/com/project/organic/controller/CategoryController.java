package com.project.organic.controller;

import com.project.organic.model.Category;
import com.project.organic.respository.CategoryRespository;
import com.project.organic.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryRespository categoryRespository;
    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> getAllCategorys() {
        List<Category> categorys = categoryService.findAllCategorys();
        return new ResponseEntity<>(categorys, HttpStatus.OK);

    }
    @GetMapping("/categorys/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
    	Category category = categoryService.findCategoryByID(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PostMapping("/categorys")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    	Category newCateogry = categoryService.addCategory(category);
        return new ResponseEntity<>(newCateogry, HttpStatus.CREATED);
    }
    @PutMapping("/categorys/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
    	Category updateCateogry = categoryService.updateCategory(category);
        return new ResponseEntity<>(updateCateogry, HttpStatus.OK);
    }
    @DeleteMapping("/categorys/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") int id) {
        if (categoryService.findCategoryByID(id)!=null){
        	categoryService.deleteCategory(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
