package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.mst.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	List<Category> findByDelStatusAndIsActive(int delStatus, int isActive);
	
}
