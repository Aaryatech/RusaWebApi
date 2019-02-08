package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.model.GallaryCategory; 

public interface GallaryCategoryRepository extends JpaRepository<GallaryCategory, Integer>{

	List<GallaryCategory> findByDelStatus(int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE m_gallery_cat SET del_status=0 WHERE gallery_cat_id=:galleryCatId ",nativeQuery=true)
	int deleteGalleryCategory(@Param("galleryCatId") int galleryCatId);

	GallaryCategory findByGalleryCatId(int galleryCatId);

}
