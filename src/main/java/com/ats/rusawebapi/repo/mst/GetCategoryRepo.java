package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.mst.GetCategory;

public interface GetCategoryRepo extends JpaRepository<GetCategory, Integer> {

	
	@Query(value="SELECT m_category.*, m_section.section_name,coalesce(0) as category_name from m_category,m_section WHERE m_category.del_status=:delStatus and m_section.section_id=m_category.section_id and m_category.parent_id=0",nativeQuery=true)
	List<GetCategory> getAllCatList(@Param("delStatus") int delStatus);

	@Query(value="SELECT m_category.*, m_section.section_name,coalesce(0) as category_name from m_category,m_section WHERE  m_category.cat_id=:catId "
			+ "and m_section.section_id=m_category.section_id",nativeQuery=true)
	GetCategory getCatListByCatId(@Param("catId") int catId);

	@Query(value="SELECT m_category.*, m_section.section_name,coalesce(0) as category_name from m_category,m_section WHERE  m_category.section_id=m_section.section_id "
			+ "and m_category.section_id=:sectionId and m_category.del_status=1 and m_category.parent_id=0",nativeQuery=true)
	List<GetCategory> getAllCatIdBySectionId(@Param("sectionId")int sectionId);

	@Query(value="SELECT m_category.*, m_section.section_name,coalesce((select m.cat_name from m_category "
			+ "m where m.cat_id=m_category.parent_id)) as category_name from m_category,m_section WHERE m_category.section_id=m_section.section_id  "
			+ "and m_category.del_status=:delStatus and m_category.parent_id!=0",nativeQuery=true)
	List<GetCategory> getSubCatList(@Param("delStatus")int delStatus);
	

}
