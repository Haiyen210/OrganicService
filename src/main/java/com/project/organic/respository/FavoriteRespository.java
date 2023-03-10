package com.project.organic.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.organic.model.Category;
import com.project.organic.model.Favorite;
import com.project.organic.model.Product;

public interface FavoriteRespository extends JpaRepository<Favorite, Integer> {
	  Favorite findById(int id);
}
