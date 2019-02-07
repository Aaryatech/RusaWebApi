package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.Page;

public interface PageRepo extends JpaRepository<Page, Integer>{

	Page findByPageId(int exInt2);

	Page findByPageSlug(String slugName);

	@Query(value="select CASE             \n" + 
			"            WHEN p.type_sec_cate='sec' THEN (select\n" + 
			"                section_id \n" + 
			"            from\n" + 
			"                m_section \n" + 
			"            where\n" + 
			"                p.sec_cate_id=section_id)              \n" + 
			"            ELSE (select\n" + 
			"                s.section_id \n" + 
			"            from\n" + 
			"                m_section s,\n" + 
			"                m_category c \n" + 
			"            where\n" + 
			"                p.sec_cate_id=c.cat_id \n" + 
			"                and c.section_id= s.section_id)           \n" + 
			"        END  as secction_name\n" + 
			"    from \n" + 
			"    t_pages p\n" + 
			"    where page_id=:pageId",nativeQuery=true) 
	int getSectioinId(@Param("pageId") int pageId);

}
