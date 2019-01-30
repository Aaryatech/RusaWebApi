package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.CategoryList;

public interface CategoryListRepository extends JpaRepository<CategoryList, Integer>{
	
	
	@Query(value="select cat_id,cat_name,slug_name,cat_desc,cat_sort_no, ex_int2 as page_id from m_category where "
			+ "del_status=1 and section_id=:sectionId and parent_id=0 order by cat_sort_no",nativeQuery=true) 
	List<CategoryList> getCategoryList(@Param("sectionId") int sectionId);

}
