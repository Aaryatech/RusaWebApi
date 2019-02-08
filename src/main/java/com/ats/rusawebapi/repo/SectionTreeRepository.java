package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.SectionTree;

public interface SectionTreeRepository extends JpaRepository<SectionTree, Integer>{

	@Query(value="select section_id,section_name,section_slugname,section_desc,sec_sort_no, ex_int2 as page_id from m_section where del_status=1 "
			+ " order by sec_sort_no",nativeQuery=true) 
	List<SectionTree> getSectionTreeStructure();

	@Query(value="select\n" + 
			"        s.section_id,\n" + 
			"        sd.section_name,\n" + 
			"        s.section_slugname,\n" + 
			"        sd.section_desc,\n" + 
			"        s.sec_sort_no,\n" + 
			"        s.ex_int2 as page_id \n" + 
			"    from\n" + 
			"        m_section s,\n" + 
			"        m_section_description sd\n" + 
			"    where\n" + 
			"        s.del_status=1  \n" + 
			"        and sd.section_id=s.section_id\n" + 
			"        and sd.language_id=:langId\n" + 
			"        and s.is_active=1\n" + 
			"    order by\n" + 
			"        s.sec_sort_no",nativeQuery=true) 
	List<SectionTree> getSectionListByLangId(@Param("langId")int langId);

}
