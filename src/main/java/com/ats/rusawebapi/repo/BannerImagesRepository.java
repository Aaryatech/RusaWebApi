package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.BannerImages;

public interface BannerImagesRepository extends JpaRepository<BannerImages, Integer>{

	BannerImages findByIdAndDelStatus(int id, int i);

}
