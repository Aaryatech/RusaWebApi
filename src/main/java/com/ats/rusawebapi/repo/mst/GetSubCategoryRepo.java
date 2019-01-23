package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.mst.GetSubCategory;

public interface GetSubCategoryRepo extends JpaRepository<GetSubCategory, Integer>{
	
	
	@Query(value="SELECT m_sub_category.*, m_category.cat_name,m_category.cat_code,m_category.cat_desc FROM"
			+ " m_category,m_sub_category WHERE m_sub_category.cat_id=m_category.cat_id AND  m_sub_category.del_status=:delStatus",nativeQuery=true)

	List<GetSubCategory> getSubAllSubCatList(@Param("delStatus") int delStatus);
	
	
 
	@Query(value="SELECT m_sub_category.*, m_category.cat_name,m_category.cat_code,m_category.cat_desc FROM"
			+ " m_category,m_sub_category WHERE m_sub_category.cat_id=m_category.cat_id AND  m_sub_category.del_status=:delStatus"
			+ " AND m_sub_category.sub_cat_id=:subCatId",nativeQuery=true) 
	GetSubCategory getSubCategory(@Param("delStatus") int delStatus,@Param("subCatId") int subCatId);

	@Query(value="SELECT m_sub_category.*, m_category.cat_name,m_category.cat_code,m_category.cat_desc FROM"
			+ " m_category,m_sub_category WHERE m_sub_category.cat_id=m_category.cat_id AND  m_sub_category.del_status=:delStatus AND m_category.cat_id=:catId",nativeQuery=true)

	List<GetSubCategory> getAllSubCatByCatId(@Param("delStatus") int delStatus,
			@Param("catId") int catId);
	
	

}
