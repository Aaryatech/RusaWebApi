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
	 
	@Query(value="select\n" + 
			"    c.cat_id,\n" + 
			"    cd.cat_name,\n" + 
			"    c.slug_name,\n" + 
			"    cd.cat_desc,\n" + 
			"    c.cat_sort_no,\n" + 
			"    c.ex_int2 as page_id \n" + 
			"from\n" + 
			"    m_category c,\n" + 
			"    m_category_description cd\n" + 
			"where\n" + 
			"    c.del_status=1 \n" + 
			"    and c.section_id=:sectionId\n" + 
			"    and c.parent_id=0 \n" + 
			"    and c.cat_id=cd.cat_id\n" + 
			"    and cd.language_id=:langId\n" + 
			"    and c.is_active=1\n" + 
			"order by\n" + 
			"cat_sort_no",nativeQuery=true) 
	List<CategoryList> getCategoryListByLangId(@Param("sectionId")int sectionId, @Param("langId") int langId);
    

}
