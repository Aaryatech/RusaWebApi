package com.ats.rusawebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.tx.model.GalleryDetail;

public interface GalleryDetailRepo extends  JpaRepository<GalleryDetail, Integer> {

	List<GalleryDetail> findByGalleryHeadIdAndDelStatus(int galleryHeadId, int i);

	//int deleteGalleryDetail(int galleryDetailId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE GalleryDetail SET delStatus=0  WHERE gallery_detail_id=:galleryDetailId")
	int deleteGalleryDetail(@Param("galleryDetailId") int galleryDetailId);

	



}
