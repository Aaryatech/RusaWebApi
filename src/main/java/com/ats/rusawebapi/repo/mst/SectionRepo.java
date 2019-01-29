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
	int deleteSection(@Param("sectionId") int sectionId);

	Section findBySectionIdAndDelStatus(int sectionId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Section SET delStatus=0  WHERE section_id IN(:sectionIds)")
	int deleteMultiContDetail(@Param("sectionIds") List<Integer> sectionIds);
	

	@Transactional
	@Modifying
	@Query("UPDATE Section SET isActive=:isActive WHERE section_id IN (:sectionIdList)")

	int activeInactiveSection(@Param("sectionIdList") List<String> sectionIdList, @Param("isActive") int isActive);
 
	List<Section> findByDelStatusOrderBySectionSortNo(int i);

	@Query(value=("select  count(*) from  m_section  where section_slugname LIKE  :str% "),nativeQuery=true)
	int getCountForSlugName(@Param("str")String str);

	@Transactional
	@Modifying
	@Query("UPDATE Section SET section_slugname=:str WHERE section_id = :sectionId")
	int updateSlugName(@Param("sectionId")int sectionId, @Param("str") String str);

}
