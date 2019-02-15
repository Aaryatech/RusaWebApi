package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.CmsSearchData;
 

public interface CmsSearchDataRepository extends JpaRepository<CmsSearchData, Integer>{
	
	@Query(value="SELECT\n" + 
			"        cd.cms_page_id ,\n" + 
			"        1 as module_id,\n" + 
			"        cd.heading  ,\n" + 
			"        cd.page_desc ,\n" + 
			"        ch.add_date,\n" + 
			"        ch.edit_date,\n" + 
			"        t.page_name,\n" + 
			"        t.page_slug\n" + 
			"    from\n" + 
			"        t_cms_pages_description cd,\n" + 
			"        t_cms_pages ch,\n" + 
			"        t_pages t\n" + 
			"    WHERE\n" + 
			"        (\n" + 
			"            cd.page_desc LIKE  %:word%  \n" + 
			"            or cd.heading LIKE  %:word%   \n" + 
			"        ) \n" + 
			"        and cd.language_id=1  \n" + 
			"        and cd.cms_page_id=ch.cms_page_id \n" + 
			"        and ch.del_status=1 \n" + 
			"        and ch.is_active=1\n" + 
			"        and t.page_id=ch.page_id",nativeQuery=true) 
	List<CmsSearchData> cmsSerchList(@Param("word") String word);

}
