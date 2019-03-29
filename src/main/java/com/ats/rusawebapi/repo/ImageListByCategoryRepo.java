package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.ImageListByCategory;

public interface ImageListByCategoryRepo extends JpaRepository<ImageListByCategory, Integer>{
	
	@Query(value="select  g.gallery_details_id,g.gallery_cat_id,count(g.gallery_details_id) as pic_count,c.cate_name , g.file_name from t_gallery_details g \n" + 
			"	inner join  m_gallery_cat c on g.gallery_cat_id  = c.gallery_cat_id \n" + 
			"	where g.page_id=:pageId  and g.del_status=1 group by g.gallery_cat_id order by c.sort_no ",nativeQuery=true)
	List<ImageListByCategory> imageListByCategoryList(@Param("pageId") int pageId);

}
