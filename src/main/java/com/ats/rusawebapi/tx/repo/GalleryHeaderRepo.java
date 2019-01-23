package com.ats.rusawebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.tx.model.Galleryheader;

public interface GalleryHeaderRepo extends JpaRepository<Galleryheader, Integer> {

	//List<Galleryheader> findByDelStatus(int i);

	Galleryheader findByGalleryHeaderIdAndDelStatus(int galleryHeadId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Galleryheader SET delStatus=0  WHERE gallery_header_id=:galleryHeadId")
	int deleteGalleryHeader(@Param("galleryHeadId") int galleryHeadId);

	@Transactional
	@Modifying
	@Query("UPDATE Galleryheader SET delStatus=0  WHERE gallery_header_id IN(:galleryHeadIds)")
	int deleteMultiGalleryHeader(@Param("galleryHeadIds") List<Integer> galleryHeadIds);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Galleryheader SET isActive=:isActive WHERE gallery_header_id IN (:galleryHeadIds)")

	int activeInactiveGalleryHeaders(@Param("galleryHeadIds") List<String> galleryHeadIds, @Param("isActive") int isActive);

	//int activeInactiveGalleryHeaders(List<String> galleryHeadIds, int isActive);

	
	

}
