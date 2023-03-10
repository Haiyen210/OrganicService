package com.project.organic.respository;

import com.project.organic.model.Category;
import com.project.organic.model.Product;
import com.project.organic.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRespository extends JpaRepository<Rating, Integer> {
	Rating findById(int id);
	@Query("SELECT AVG(f.star) from Rating f where f.productId.id = ?1")
	float productStar(int productId);
}
