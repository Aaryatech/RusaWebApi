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
 
	@Query(value=("select\n" + 
			"        s.section_id,\n" + 
			"        s.section_name,\n" + 
			"        s.section_slugname,\n" + 
			"        s.section_no,\n" + 
			"        s.section_desc,\n" + 
			"        s.section_add_date,\n" + 
			"        s.section_edit_date,\n" + 
			"        s.sec_sort_no,\n" + 
			"        s.section_remark,\n" + 
			"        s.sec_date_time,\n" + 
			"        s.added_by_user_id,\n" + 
			"        s.edit_by_user_id,\n" + 
			"        s.is_active,\n" + 
			"        s.del_status,\n" + 
			"        s.ex_int1,\n" + 
			"        s.ex_int2, \n" + 
			"        s.ex_var1,\n" + 
			"        s.ex_var2,\n" + 
			"        s.ex_var3,\n" + 
			"        s.ex_date1,\n" + 
			"        s.ex_date2,\n" + 
			"        s.ex_float1,\n" + 
			"        s.ex_float2,\n" + 
			"        s.ex_float3,\n" + 
			"        s.ex_var4,\n" + 
			"        s.ex_var5,\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM  t_cms_pages c WHERE c.del_status=1 AND c.page_id=s.ex_int2  ),0) +\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_faq c WHERE c.del_status=1  AND c.page_id=s.ex_int2 ),0)  + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_testimonials c WHERE c.del_status=1 AND c.page_id=s.ex_int2 ),0)+\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_newsblogs c WHERE  c.del_status=1 AND c.page_id=s.ex_int2 ),0) + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_gallery_details c WHERE c.del_status=1 AND  c.page_id=s.ex_int2 ),0) + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_documentupload c WHERE c.del_status=1 AND c.page_id=s.ex_int2 ),0)+\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM m_category c WHERE c.del_status=1 AND c.section_id=s.section_id ),0)as ex_int3\n" + 
			"    from\n" + 
			"        m_section s \n" + 
			"    where\n" + 
			"        s.del_status=1 \n" + 
			"    order by\n" + 
			"        s.sec_sort_no asc"),nativeQuery=true)
	List<Section> getDelStatusOrderBySectionSortNo();

	@Query(value=("select  count(*) from  m_section  where section_slugname LIKE  :str% "),nativeQuery=true)
	int getCountForSlugName(@Param("str")String str);

	@Transactional
	@Modifying
	@Query("UPDATE Section SET section_slugname=:str,ex_int2=:pageId WHERE section_id = :sectionId")
	int updateSlugName(@Param("sectionId")int sectionId, @Param("str") String str, @Param("pageId") int pageId);

}
