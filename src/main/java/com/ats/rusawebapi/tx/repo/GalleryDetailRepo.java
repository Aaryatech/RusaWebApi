package com.ats.rusawebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.tx.model.GalleryDetail;

public interface GalleryDetailRepo extends  JpaRepository<GalleryDetail, Integer> {

	List<GalleryDetail> findByGalleryDetailIdAndDelStatus(int galleryHeadId, int i);



}
