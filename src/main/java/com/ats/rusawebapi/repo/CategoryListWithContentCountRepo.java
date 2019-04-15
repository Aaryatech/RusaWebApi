package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.CategoryListWithContentCount;

public interface CategoryListWithContentCountRepo extends JpaRepository<CategoryListWithContentCount, Integer>{

	@Query(value="select c.cat_id,cd.cat_name,cd.cat_desc,coalesce((select count(g.gallery_details_id) from t_gallery_details g where g.del_status=1 "
			+ "and g.type_video_image=3 and p.page_id=g.page_id),0) as img_count, coalesce((select count(g.gallery_details_id) from t_gallery_details "
			+ "g where g.del_status=1 and g.type_video_image=4 and p.page_id=g.page_id),0) as video_count, coalesce((select count(distinct(g.gallery_cat_id)) "
			+ "from t_gallery_details g where g.del_status=1 and p.page_id=g.page_id ),0) as category_count,p.page_slug from m_category_description cd,m_category c,"
			+ "t_pages p where cd.cat_id=c.cat_id and cd.language_id=:langId and c.section_id=:sectionId and p.page_slug=c.slug_name and c.del_status=1 ",nativeQuery=true) 
	List<CategoryListWithContentCount> getCategoryListWithImageCount(@Param("sectionId")int sectionId, @Param("langId") int langId);

}
