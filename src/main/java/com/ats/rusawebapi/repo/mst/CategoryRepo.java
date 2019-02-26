package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.model.mst.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	List<Category> findByDelStatus(int delStatus);
	
	List<Category> findByDelStatusAndSectionId(int delStatus,int sectionId);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_category SET del_status=:delStatus WHERE cat_id IN (:catIdList) ",nativeQuery=true)

	int deleteCategory(@Param("catIdList") List<String> catIdList,@Param("delStatus") int delStatus);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_category SET is_active=:isActive WHERE cat_id IN (:catIdList) ",nativeQuery=true)

	int activeInactiveCategory(@Param("catIdList") List<String> catIdList,@Param("isActive") int isActive);

	@Transactional
	@Modifying
	@Query(value="UPDATE m_category SET slug_name=:str,ex_int2=:pageId WHERE cat_id=:catId ",nativeQuery=true)
	int updateSlugName(@Param("catId")int catId,@Param("str") String str, @Param("pageId") int pageId);

	@Query(value="select count(*)\n" + 
			"from m_category\n" + 
			"where del_status=1 and parent_id=:catId and is_active=1",nativeQuery=true)
	int getParentIdCountByCatId(@Param("catId") int catId);
	
	@Query(value="SELECT \n" + 
			"	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_cms_pages c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0))+\n" + 
			"	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_faq c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0))+\n" + 
			"(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_testimonials c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.section_id=6 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0))+\n" + 
			"	(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_testimonials c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.section_id=13 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0))+\n" + 
			"	(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_testimonials c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.section_id=8 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0))+\n" + 
			"	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_newsblogs c WHERE s.del_status=1 and s.is_active=1  AND c.ex_int1=9 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0))+\n" + 
			"	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_newsblogs c WHERE s.del_status=1 and s.is_active=1 AND c.ex_int1=11 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0))+\n" + 
			"	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_gallery_details c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.type_video_image=3 \n" + 
			"	AND c.page_id=s.ex_int2 ORDER BY s.section_id),0) )+\n" + 
			"(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_gallery_details c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND  c.type_video_image=4\n" + 
			"	AND c.page_id=s.ex_int2 ORDER BY s.section_id),0) )+\n" + 
			"	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_documentupload c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 \n" + 
			"	ORDER BY s.section_id),0) ) from dual\n" + 
			"",nativeQuery=true)
	int getParentIdCountBySectionId(@Param("sectionId") int sectionId);
	
/*	SELECT 
	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_cms_pages c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0))+
	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_faq c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0))+
(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_testimonials c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.section_id=6 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0))+
	(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_testimonials c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.section_id=13 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0))+
	(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_testimonials c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.section_id=8 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0))+
	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_newsblogs c WHERE s.del_status=1 and s.is_active=1  AND c.ex_int1=9 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0))+
	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_newsblogs c WHERE s.del_status=1 and s.is_active=1 AND c.ex_int1=11 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0))+
	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_gallery_details c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.type_video_image=3 
	AND c.page_id=s.ex_int2 ORDER BY s.section_id),0) )+
(	coalesce (( SELECT COUNT(*)  FROM m_section s,t_gallery_details c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND  c.type_video_image=4
	AND c.page_id=s.ex_int2 ORDER BY s.section_id),0) )+
	(coalesce (( SELECT COUNT(*)  FROM m_section s,t_documentupload c WHERE s.del_status=1 and s.is_active=1 AND c.del_status=1 and c.is_active=1 AND c.page_id=s.ex_int2 
	ORDER BY s.section_id),0) ) from dual
*/

}
