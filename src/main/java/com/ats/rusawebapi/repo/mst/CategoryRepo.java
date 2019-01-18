package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.model.mst.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	List<Category> findByDelStatus(int delStatus);
	
	List<Category> findByDelStatusAndSectionId(int delStatus,int sectionId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_category SET del_status=:delStatus WHERE cat_id IN (:catIdList) ",nativeQuery=true)

	int deleteCategory(@Param("catIdList") List<String> catIdList,@Param("delStatus") int delStatus);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_category SET is_active=:isActive WHERE cat_id IN (:catIdList) ",nativeQuery=true)

	int activeInactiveCategory(@Param("catIdList") List<String> catIdList,@Param("isActive") int isActive);
	
	
}
