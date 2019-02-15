package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.SubCategoryList;

public interface SubCategoryListRepository extends JpaRepository<SubCategoryList, Integer>{

	@Query(value="select cat_id as sub_cat_id,cat_name as sub_cat_name,slug_name as sub_slug_name,parent_id,section_id,cat_desc as sub_cat_desc,cat_sort_no as sub_sort_no, ex_int2 as page_id, t.external_url,\n" + 
			"        t.external_url_target from m_category,t_pages t "
			+ "where del_status=1 and parent_id=:catId and t.page_slug=slug_name order by cat_sort_no",nativeQuery=true) 
	List<SubCategoryList> getSubCategoryList(@Param("catId") int catId);

	@Query(value="select\n" + 
			"        c.cat_id as sub_cat_id,\n" + 
			"        cd.cat_name as sub_cat_name,\n" + 
			"        c.slug_name as sub_slug_name,c.parent_id,c.section_id,\n" + 
			"        cd.cat_desc as sub_cat_desc,\n" + 
			"        c.cat_sort_no as sub_sort_no,\n" + 
			"        c.ex_int2 as page_id,t.external_url,\n" + 
			"        t.external_url_target \n" + 
			"    from\n" + 
			"        m_category c,\n" + 
			"        m_category_description cd, t_pages t\n" + 
			"    where\n" + 
			"        c.del_status=1 \n" + 
			"        and c.parent_id!=0 \n" + 
			"        and cd.cat_id=c.cat_id\n" + 
			"        and cd.language_id=:langId\n" + 
			"        and c.is_active=1 and c.slug_name=t.page_slug\n" + 
			"    order by\n" + 
			"        cat_sort_no",nativeQuery=true) 
	List<SubCategoryList> getSubCategoryListByLangId(@Param("langId")int langId);

}
