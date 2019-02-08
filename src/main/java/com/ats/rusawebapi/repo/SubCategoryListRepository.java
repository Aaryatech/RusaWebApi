package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.SubCategoryList;

public interface SubCategoryListRepository extends JpaRepository<SubCategoryList, Integer>{

	@Query(value="select cat_id as sub_cat_id,cat_name as sub_cat_name,slug_name as sub_slug_name,cat_desc as sub_cat_desc,cat_sort_no as sub_sort_no, ex_int2 as page_id from m_category "
			+ "where del_status=1 and parent_id=:catId order by cat_sort_no",nativeQuery=true) 
	List<SubCategoryList> getSubCategoryList(@Param("catId") int catId);

	@Query(value="select\n" + 
			"        c.cat_id as sub_cat_id,\n" + 
			"        cd.cat_name as sub_cat_name,\n" + 
			"        c.slug_name as sub_slug_name,\n" + 
			"        cd.cat_desc as sub_cat_desc,\n" + 
			"        c.cat_sort_no as sub_sort_no,\n" + 
			"        c.ex_int2 as page_id \n" + 
			"    from\n" + 
			"        m_category c,\n" + 
			"        m_category_description cd\n" + 
			"    where\n" + 
			"        c.del_status=1 \n" + 
			"        and c.parent_id=:catId \n" + 
			"        and cd.cat_id=c.cat_id\n" + 
			"        and cd.language_id=:langId\n" + 
			"        and c.is_active=1\n" + 
			"    order by\n" + 
			"        cat_sort_no",nativeQuery=true) 
	List<SubCategoryList> getSubCategoryListByLangId(@Param("catId")int catId,@Param("langId") int langId);

}
