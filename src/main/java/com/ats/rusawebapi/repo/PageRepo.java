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
	
    @Query(value="select\n" + 
    		"    page_id,\n" + 
    		"    template_id,\n" + 
    		"    module_id,\n" + 
    		"    CASE                          \n" + 
    		"        WHEN p.type_sec_cate='sec' THEN (select\n" + 
    		"            section_name              \n" + 
    		"        from\n" + 
    		"            m_section_description              \n" + 
    		"        where\n" + 
    		"            p.sec_cate_id=section_id and language_id=:langId)                           \n" + 
    		"        ELSE (select\n" + 
    		"            cat_name              \n" + 
    		"        from \n" + 
    		"            m_category_description c              \n" + 
    		"        where\n" + 
    		"            p.sec_cate_id=c.cat_id                  \n" + 
    		"            and language_id=:langId)                    \n" + 
    		"    END as page_name,\n" + 
    		"    page_slug,\n" + 
    		"    external_url,\n" + 
    		"    external_url_target,\n" + 
    		"    type_sec_cate,\n" + 
    		"    sec_cate_id,\n" + 
    		"    page_meta_title,\n" + 
    		"    page_meta_description,\n" + 
    		"    page_meta_keyword \n" + 
    		"from\n" + 
    		"    t_pages p\n" + 
    		"where\n" + 
    		"    p.page_slug=:slugName",nativeQuery=true) 
	Page findByPageSlug(@Param("slugName")String slugName, @Param("langId") int langId);

}
