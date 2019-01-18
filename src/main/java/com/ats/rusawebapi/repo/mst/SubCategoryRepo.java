package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.model.mst.SubCategory;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {
	
	List<SubCategory> findByDelStatus(int delStatus);
	
	List<SubCategory>  findByCatIdInAndDelStatus(List<Integer> catId,int delStatus);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_sub_category SET del_status=:delStatus WHERE sub_cat_id IN (:subCatIdList) ",nativeQuery=true)

	int deleteSubCategory(@Param("subCatIdList") List<String> subCatIdList,@Param("delStatus") int delStatus);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_sub_category SET is_active=:isActive WHERE sub_cat_id IN (:subCatIdList) ",nativeQuery=true)

	int activeInactiveSubCategory(@Param("subCatIdList") List<String> subCatIdList,@Param("isActive") int isActive);
	
}
