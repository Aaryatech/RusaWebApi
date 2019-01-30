package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.SectionTree;

public interface SectionTreeRepository extends JpaRepository<SectionTree, Integer>{

	@Query(value="select section_id,section_name,section_slugname,section_desc,sec_sort_no, ex_int2 as page_id from m_section where del_status=1 "
			+ " order by sec_sort_no",nativeQuery=true) 
	List<SectionTree> getSectionTreeStructure();

}
