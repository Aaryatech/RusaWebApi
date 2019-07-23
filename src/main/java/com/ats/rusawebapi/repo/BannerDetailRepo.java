package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.BannerDetail;

public interface BannerDetailRepo extends JpaRepository<BannerDetail, Integer>{

	List<BannerDetail> findByCateIdAndDelStatus(int id, int i);

}
