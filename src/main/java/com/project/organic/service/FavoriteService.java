package com.project.organic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.organic.model.Category;
import com.project.organic.model.Favorite;
import com.project.organic.model.Product;
import com.project.organic.respository.FavoriteRespository;

@Service
@Transactional
public class FavoriteService {
    private final FavoriteRespository  favoriteRespository;

    @Autowired
    public FavoriteService(FavoriteRespository favoriteRespository) {
        this.favoriteRespository = favoriteRespository;
    }
    public List<Favorite> findAllFavorites() {
        return favoriteRespository.findAll();
    }

    public Favorite updateFavorite(Favorite favorite) {
        return favoriteRespository.save(favorite);
    }
    public Favorite findFavoriteByID(int id) {
        return favoriteRespository.findById(id);
    }
    public void deleteFavorite(int id){
    	favoriteRespository.deleteById(id);
    }
    public Favorite addFavorite(Favorite favorite) {
        return favoriteRespository.save(favorite);
    }
   

}
