package com.project.organic.service;

import com.project.organic.model.Banner;
import com.project.organic.respository.BannerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BannerService {
    private final BannerRespository  bannerRespository;

    @Autowired
    public BannerService(BannerRespository bannerRespository) {
        this.bannerRespository = bannerRespository;
    }
    public List<Banner> findAllBanners() {
        return bannerRespository.findAll();
    }
    public Banner updateBanner(Banner banner) {
        return bannerRespository.save(banner);
    }
    public void deleteBanner(int id){
        bannerRespository.deleteById(id);
    }
    public Banner addBanner(Banner banner) {
        return bannerRespository.save(banner);
    }
    public Banner findBannerByID(int id){
        return bannerRespository.findById(id);
    }

}
