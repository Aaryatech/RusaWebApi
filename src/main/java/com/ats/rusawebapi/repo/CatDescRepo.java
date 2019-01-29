package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.mst.CategoryDescription;

public interface CatDescRepo extends JpaRepository<CategoryDescription, Integer>{

	List<CategoryDescription> findByCatId(int catId);

}
