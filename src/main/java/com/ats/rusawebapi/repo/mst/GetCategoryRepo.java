package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.mst.GetCategory;

public interface GetCategoryRepo extends JpaRepository<GetCategory, Integer> {

	
	@Query(value=" SELECT\n" + 
			"       m_category.cat_id,\n" + 
			"        m_category.parent_id,\n" + 
			"        m_category.cat_name,\n" + 
			"        m_category.slug_name,\n" + 
			"        m_category.cat_code,\n" + 
			"        m_category.cat_desc,\n" + 
			"        m_category.image_name, \n" + 
			"        m_category.external_url_target,\n" + 
			"        m_category.cat_edit_date, \n" + 
			"        m_category.cat_add_date,\n" + 
			"        m_category.cat_sort_no,\n" + 
			"        m_category.cat_remark,\n" + 
			"        m_category.section_id,\n" + 
			"        m_category.added_by_user_id,\n" + 
			"        m_category.edit_by_user_id,\n" + 
			"        m_category.is_active,\n" + 
			"        m_category.del_status,\n" + 
			"        m_section.section_name,\n" + 
			"        coalesce(0) as category_name,m_category.ex_int2,\n" + 
			"        coalesce((select\n" + 
			"            m.cat_name \n" + 
			"        from\n" + 
			"            m_category m \n" + 
			"        where\n" + 
			"            m.cat_id=m_category.parent_id)) as category_name, \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM  t_cms_pages c WHERE c.del_status=1 AND c.page_id=m_category.ex_int2  ),0) +\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_faq c WHERE c.del_status=1  AND c.page_id=m_category.ex_int2 ),0)  + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_testimonials c WHERE c.del_status=1 AND c.page_id=m_category.ex_int2 ),0)+\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_newsblogs c WHERE  c.del_status=1 AND c.page_id=m_category.ex_int2 ),0) + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_gallery_details c WHERE c.del_status=1 AND  c.page_id=m_category.ex_int2 ),0) + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_documentupload c WHERE c.del_status=1 AND c.page_id=m_category.ex_int2 ),0)+\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM m_category c WHERE c.del_status=1 AND c.parent_id=m_category.cat_id and c.parent_id!=0),0)as external_url\n" + 
			"    from\n" + 
			"        m_category,\n" + 
			"        m_section \n" + 
			"    WHERE\n" + 
			"        m_category.del_status=:delStatus\n" + 
			"        and m_section.section_id=m_category.section_id \n" + 
			"        and m_category.parent_id=0",nativeQuery=true)
	List<GetCategory> getAllCatList(@Param("delStatus") int delStatus);

	@Query(value="SELECT m_category.*, m_section.section_name,coalesce(0) as category_name from m_category,m_section WHERE  m_category.cat_id=:catId "
			+ "and m_section.section_id=m_category.section_id",nativeQuery=true)
	GetCategory getCatListByCatId(@Param("catId") int catId);

	@Query(value="SELECT m_category.*, m_section.section_name,coalesce(0) as category_name from m_category,m_section WHERE  m_category.section_id=m_section.section_id "
			+ "and m_category.section_id=:sectionId and m_category.del_status=1 and m_category.parent_id=0",nativeQuery=true)
	List<GetCategory> getAllCatIdBySectionId(@Param("sectionId")int sectionId);
	
	@Query(value="SELECT m_category.*, m_section.section_name,coalesce(0) as category_name from m_category,m_section WHERE  m_category.section_id=m_section.section_id "
			+ "and m_category.section_id=:sectionId and m_category.del_status=1 and m_category.parent_id=0 order by m_category.cat_sort_no desc",nativeQuery=true)
	List<GetCategory> getAllCatIdBySectionIdOrderByDesc(@Param("sectionId")int sectionId);

	@Query(value=" SELECT\n" + 
			"        m_category.cat_id,\n" + 
			"        m_category.parent_id,\n" + 
			"        m_category.cat_name,\n" + 
			"        m_category.slug_name,\n" + 
			"        m_category.cat_code,\n" + 
			"        m_category.cat_desc,\n" + 
			"        m_category.image_name, \n" + 
			"        m_category.external_url_target,\n" + 
			"        m_category.cat_edit_date, \n" + 
			"        m_category.cat_add_date,\n" + 
			"        m_category.cat_sort_no,\n" + 
			"        m_category.cat_remark,\n" + 
			"        m_category.section_id,\n" + 
			"        m_category.added_by_user_id,\n" + 
			"        m_category.edit_by_user_id,\n" + 
			"        m_category.is_active,\n" + 
			"        m_category.del_status,\n" + 
			"        m_section.section_name,m_category.ex_int2, \n" + 
			"        coalesce((select\n" + 
			"            m.cat_name \n" + 
			"        from\n" + 
			"            m_category m \n" + 
			"        where\n" + 
			"            m.cat_id=m_category.parent_id)) as category_name, \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM  t_cms_pages c WHERE c.del_status=1 AND c.page_id=m_category.ex_int2  ),0) +\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_faq c WHERE c.del_status=1  AND c.page_id=m_category.ex_int2 ),0)  + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_testimonials c WHERE c.del_status=1 AND c.page_id=m_category.ex_int2 ),0)+\n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_newsblogs c WHERE  c.del_status=1 AND c.page_id=m_category.ex_int2 ),0) + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_gallery_details c WHERE c.del_status=1 AND  c.page_id=m_category.ex_int2 ),0) + \n" + 
			"         coalesce (( SELECT COUNT(*)  FROM t_documentupload c WHERE c.del_status=1 AND c.page_id=m_category.ex_int2 ),0) as external_url\n" + 
			"    from\n" + 
			"        m_category,\n" + 
			"        m_section \n" + 
			"    WHERE\n" + 
			"        m_category.section_id=m_section.section_id  \n" + 
			"        and m_category.del_status=:delStatus \n" + 
			"        and m_category.parent_id!=0",nativeQuery=true)
	List<GetCategory> getSubCatList(@Param("delStatus")int delStatus);
	

}
