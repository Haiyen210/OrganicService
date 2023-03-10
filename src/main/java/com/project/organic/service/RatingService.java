package com.project.organic.service;

import com.project.organic.model.Rating;
import com.project.organic.respository.RatingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RatingService {
    private final RatingRespository  ratingRespository;

    @Autowired
    public RatingService(RatingRespository ratingRespository) {
        this.ratingRespository = ratingRespository;
    }
    public List<Rating> findAllRatings() {
        return ratingRespository.findAll();
    }
    public Rating updateRating(Rating rating) {
        return ratingRespository.save(rating);
    }
    public void deleteRating(int id){
    	ratingRespository.deleteById(id);
    }
    public Rating addRating(Rating rating) {
        return ratingRespository.save(rating);
    }
    public Rating findRatingByID(int id){
        return ratingRespository.findById(id);
    }
    public float getStarRating(int id){ return  ratingRespository.productStar(id);}
}
