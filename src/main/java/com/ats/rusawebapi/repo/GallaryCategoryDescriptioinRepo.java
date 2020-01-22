package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.GallaryCategoryDescriptioin;

public interface GallaryCategoryDescriptioinRepo extends JpaRepository<GallaryCategoryDescriptioin, Integer>{

	List<GallaryCategoryDescriptioin> findAllByGalleryCatId(int galleryCatId);
	@Query(value="SELECT `cat_name` FROM `m_gallery_cat_description` WHERE `gallery_cat_id`=:galleryCatId and `language_id`=:langId",nativeQuery=true)
	String getCatName(int galleryCatId, int langId);

}
