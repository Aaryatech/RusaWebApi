package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.mst.SubCategory;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {
	
	
	List<SubCategory> findByDelStatusAndIsActive(int delStatus,int isActive);
	
	
	List<SubCategory>  findByCatIdAndDelStatusAndIsActive(int catId,int delStatus,int isActive);
	
	

}
