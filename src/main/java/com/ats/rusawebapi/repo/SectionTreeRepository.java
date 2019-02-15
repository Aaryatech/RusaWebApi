package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.SectionTree;

public interface SectionTreeRepository extends JpaRepository<SectionTree, Integer>{

	@Query(value="select\n" + 
			"        m_section.section_id,\n" + 
			"        m_section.section_name,\n" + 
			"        m_section.section_slugname,\n" + 
			"        m_section.section_desc,\n" + 
			"        m_section.sec_sort_no,\n" + 
			"        m_section.ex_int2 as page_id,\n" + 
			"        t.external_url,\n" + 
			"        t.external_url_target\n" + 
			"    from\n" + 
			"        m_section ,\n" + 
			"        t_pages t\n" + 
			"    where\n" + 
			"        m_section.del_status=1  \n" + 
			"        and t.page_slug=m_section.section_slugname\n" + 
			"    order by\n" + 
			"        m_section.sec_sort_no",nativeQuery=true) 
	List<SectionTree> getSectionTreeStructure();

	@Query(value="select\n" + 
			"        s.section_id,\n" + 
			"        sd.section_name,\n" + 
			"        s.section_slugname,\n" + 
			"        sd.section_desc,\n" + 
			"        s.sec_sort_no,\n" + 
			"        s.ex_int2 as page_id,\n" + 
			"        t.external_url,\n" + 
			"        t.external_url_target, \n" + 
			"        coalesce((select count(*) from m_category where parent_id=0 and section_id=s.section_id and del_status=1 and is_active=1),0) as cat_count \n" + 
			"    from\n" + 
			"        m_section s,\n" + 
			"        m_section_description sd,\n" + 
			"        t_pages t      \n" + 
			"    where\n" + 
			"        s.del_status=1           \n" + 
			"        and sd.section_id=s.section_id         \n" + 
			"        and sd.language_id=:langId       \n" + 
			"        and s.is_active=1 \n" + 
			"        and t.page_slug=s.section_slugname     \n" + 
			"    order by\n" + 
			"        s.sec_sort_no",nativeQuery=true) 
	List<SectionTree> getSectionListByLangId(@Param("langId") int langId);

}
