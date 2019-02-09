package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.model.GallaryDetail;

public interface GallaryDetailRepository extends JpaRepository<GallaryDetail, Integer>{

	List<GallaryDetail> findByGalleryCatIdAndIsActiveAndDelStatusAndTypeVideoImage(int catId, int i, int j, String moduleId);

	List<GallaryDetail> findByIsActiveAndDelStatusAndTypeVideoImage(int i, int j, String moduleId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_gallery_details SET del_status=0 WHERE gallery_details_id=:galleryDetailsId ",nativeQuery=true)
	int deleteGalleryDetail(@Param("galleryDetailsId") int galleryDetailsId);

	List<GallaryDetail> findByIsActiveAndDelStatusAndPageId(int i, int j, int pageId);

}
