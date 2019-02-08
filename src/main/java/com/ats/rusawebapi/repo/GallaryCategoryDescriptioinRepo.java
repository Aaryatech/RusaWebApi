package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.GallaryCategoryDescriptioin;

public interface GallaryCategoryDescriptioinRepo extends JpaRepository<GallaryCategoryDescriptioin, Integer>{

	List<GallaryCategoryDescriptioin> findAllByGalleryCatId(int galleryCatId);

}
