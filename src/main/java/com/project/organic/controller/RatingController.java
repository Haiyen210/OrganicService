package com.project.organic.controller;

import com.project.organic.model.Rating;
import com.project.organic.respository.RatingRespository;
import com.project.organic.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
public class RatingController {
    @Autowired
    RatingRespository ratingRespository;
    private final RatingService ratingService;


    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.findAllRatings();
        return new ResponseEntity<>(ratings, HttpStatus.OK);

    }
    @GetMapping("/ratings/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("id") int id) {
    	Rating rating = ratingService.findRatingByID(id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }
    @GetMapping("/ratings/star/{id}")
    public ResponseEntity<Float> getStar(@PathVariable("id") int id) {
        float rating = ratingService.getStarRating(id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
    	Rating star = ratingService.addRating(rating);
        return new ResponseEntity<>(star, HttpStatus.CREATED);
    }
    @PutMapping("/ratings/update")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
    	Rating updateStar = ratingService.updateRating(rating);
        return new ResponseEntity<>(updateStar, HttpStatus.OK);
    }
    @DeleteMapping("/ratings/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable("id") int id) {
        if (ratingService.findRatingByID(id)!=null){
        	ratingService.deleteRating(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
