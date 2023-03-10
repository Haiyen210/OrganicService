package com.project.organic.controller;

import com.project.organic.model.Banner;
import com.project.organic.respository.BannerRespository;
import com.project.organic.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BannerController {
    @Autowired
    BannerRespository bannerRespository;
    private final BannerService bannerService;


    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banners")
    public ResponseEntity<List<Banner>> getAllBanners() {
        List<Banner> banners = bannerService.findAllBanners();
        return new ResponseEntity<>(banners, HttpStatus.OK);

    }
    @GetMapping("/banners/{id}")
    public ResponseEntity<Banner> getBannerById(@PathVariable("id") int id) {
        Banner banner = bannerService.findBannerByID(id);
        return new ResponseEntity<>(banner, HttpStatus.OK);
    }
    @PostMapping("/banners")
    public ResponseEntity<Banner> createBanner(@RequestBody Banner banner) {
        Banner newBanner = bannerService.addBanner(banner);
        return new ResponseEntity<>(newBanner, HttpStatus.CREATED);
    }
    @PutMapping("/banners/update")
    public ResponseEntity<Banner> updateBanner(@RequestBody Banner banner) {
        Banner updateBanner = bannerService.updateBanner(banner);
        return new ResponseEntity<>(updateBanner, HttpStatus.OK);
    }
    @DeleteMapping("/banners/{id}")
    public ResponseEntity<?> deleteBanner(@PathVariable("id") int id) {
        if (bannerService.findBannerByID(id)!=null){
            bannerService.deleteBanner(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
