package com.ats.rusawebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.tx.model.Galleryheader;


public interface GalleryHeaderRepo extends  JpaRepository<Galleryheader, Integer>  {
	
	List<Galleryheader> findByDelStatus(int i);



	Galleryheader findByGalleryHeaderIdAndDelStatus(int galleryHeadId, int i);
	

}
