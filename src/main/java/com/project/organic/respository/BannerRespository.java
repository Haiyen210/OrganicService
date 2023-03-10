package com.project.organic.respository;

import com.project.organic.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRespository extends JpaRepository<Banner, Integer> {
    Banner findById(int id);
}
