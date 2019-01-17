package com.ats.rusawebapi.repo.mst;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.mst.Section;

public interface SectionRepo extends JpaRepository<Section, Integer> {
	
	List<Section> findByDelStatusOrderBySectionIdDesc(int i);
	
	@Transactional
	@Modifying
	@Query("update Section set del_status=0  WHERE section_id=:sectionId")
	int deleteSection(@Param("sectionId")int sectionId);

	Section findBySectionIdAndDelStatus(int sectionId,int i);
	

}
