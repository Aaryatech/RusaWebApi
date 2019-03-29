package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.ImageListByCategory;

public interface ImageListByCategoryRepo extends JpaRepository<ImageListByCategory, Integer>{
	
	@Query(value="select\n" + 
			"        g.gallery_details_id,\n" + 
			"        g.gallery_cat_id,\n" + 
			"        count(g.gallery_details_id) as total_count,\n" + 
			"        coalesce((select count(a.gallery_details_id) from t_gallery_details a where a.page_id=:pageId and a.type_video_image=3 and  a.del_status=1 and a.gallery_cat_id  = c.gallery_cat_id),0) as pic_count,\n" + 
			"        coalesce((select count(a.gallery_details_id) from t_gallery_details a where a.page_id=:pageId and a.type_video_image=4 and  a.del_status=1 and a.gallery_cat_id  = c.gallery_cat_id),0) as video_count,\n" + 
			"        d.cat_name as cate_name,\n" + 
			"        g.file_name \n" + 
			"    from\n" + 
			"        t_gallery_details g,\n" + 
			"        m_gallery_cat c,\n" + 
			"        m_gallery_cat_description d\n" + 
			"    where\n" + 
			"        g.page_id=:pageId\n" + 
			"        and g.del_status=1\n" + 
			"        and g.gallery_cat_id  = c.gallery_cat_id\n" + 
			"        and g.del_status=1\n" + 
			"        and c.gallery_cat_id=d.gallery_cat_id and d.language_id=:langId\n" + 
			"    group by\n" + 
			"        g.gallery_cat_id\n" + 
			"    order by\n" + 
			"        c.sort_no",nativeQuery=true)
	List<ImageListByCategory> imageListByCategoryList(@Param("pageId") int pageId,@Param("langId") int langId);

}
