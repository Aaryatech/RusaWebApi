package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.mst.GetCategory;

public interface GetCategoryRepo extends JpaRepository<GetCategory, Integer> {

	
	@Query(value="SELECT m_category.*, m_section.section_name from m_category,m_section WHERE m_category.del_status=:delStatus and m_section.section_id=m_category.section_id",nativeQuery=true)
	List<GetCategory> getAllCatList(@Param("delStatus") int delStatus);
	

}
