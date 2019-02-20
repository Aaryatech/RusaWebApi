package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.PageMetaData;

public interface PageMetaDataRepository extends JpaRepository<PageMetaData, Integer>{

	@Query(value="select page_id,page_name,page_meta_title,page_meta_description,page_meta_keyword,\n" + 
			"        CASE                          \n" + 
			"            WHEN p.type_sec_cate='sec' THEN (select\n" + 
			"                section_id              \n" + 
			"            from\n" + 
			"                m_section              \n" + 
			"            where\n" + 
			"                p.sec_cate_id=section_id)                           \n" + 
			"            ELSE (select\n" + 
			"                s.section_id              \n" + 
			"            from\n" + 
			"                m_section s,\n" + 
			"                m_category c              \n" + 
			"            where\n" + 
			"                p.sec_cate_id=c.cat_id                  \n" + 
			"                and c.section_id= s.section_id)                    \n" + 
			"        END  as secction_id     \n" + 
			"    from\n" + 
			"        t_pages p     \n" + 
			"    where\n" + 
			"        page_slug=:slugName or external_url=:slugName",nativeQuery=true) 
	PageMetaData getPageMetaData(@Param("slugName") int slugName);

}
