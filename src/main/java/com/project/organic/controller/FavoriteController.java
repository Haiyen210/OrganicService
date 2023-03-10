package com.project.organic.controller;

import com.project.organic.model.Category;
import com.project.organic.model.Favorite;
import com.project.organic.respository.FavoriteRespository;
import com.project.organic.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FavoriteController {
    @Autowired
    FavoriteRespository favoriteRespository;
    private final FavoriteService favoriteService;


    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> favorites = favoriteService.findAllFavorites();
        return new ResponseEntity<>(favorites, HttpStatus.OK);

    }


    @GetMapping("/favorites/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable("id") int id) {
    	Favorite favorite = favoriteService.findFavoriteByID(id);
        return new ResponseEntity<>(favorite, HttpStatus.OK);
    }
    @PostMapping("/favorites")
    public ResponseEntity<Favorite> createFavorite(@RequestBody Favorite favorite) {
    	Favorite newFavorite = favoriteService.addFavorite(favorite);
        return new ResponseEntity<>(newFavorite, HttpStatus.CREATED);
    }
    @PutMapping("/favorites/update")
    public ResponseEntity<Favorite> updateFavorite(@RequestBody Favorite favorite) {
    	Favorite updateFavorite = favoriteService.updateFavorite(favorite);
        return new ResponseEntity<>(updateFavorite, HttpStatus.OK);
    }
    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable("id") int id) {
        if (favoriteService.findFavoriteByID(id)!=null){
        	favoriteService.deleteFavorite(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
