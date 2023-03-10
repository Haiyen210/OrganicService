package com.project.organic.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.organic.model.Category;
import com.project.organic.model.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> {
	Product findById(int id);
	List<Product> findByCategoryID(Category catID);
	@Query("Select p from Product p where p.salePrice > 0")
	List<Product> getBySalePrice();
}
