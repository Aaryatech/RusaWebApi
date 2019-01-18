package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.tx.model.GetGalleryHeaderByCatId;

public interface GetGalleryHeaderRepo  extends JpaRepository<GetGalleryHeaderByCatId, Integer>{
	
	
	
	/*@Query(value=" SELECT  t.gallery_header_id,t.gallery_title,t.gallery_add_date,t.gallery_edit_date, "
			+ " t.gallery_header_desc,t.gallery_sort_no,t.user_id,t.is_active, t.del_status "
			+ " FROM t_gallery_header t WHERE  t.cat_id IN(:catIdList) AND  t.sub_cat_id IN(:subCatIdList) AND t.del_status=1 ",nativeQuery = true)
	List<GetGalleryHeaderByCatId> findByCatId(@Param("catIdList") List<Integer> catIdList,@Param("subCatIdList") List<Integer> subCatIdList);*/

	

	@Query(value=" SELECT  t.*,u.user_name "
			+ " FROM t_gallery_header t,m_user u WHERE  t.cat_id IN(:catIdList) AND  t.sub_cat_id IN(:subCatIdList) AND t.del_status=1  AND  u.user_id=t.user_id ",nativeQuery = true)
	List<GetGalleryHeaderByCatId> findByCatId1(@Param("catIdList") List<Integer> catIdList,@Param("subCatIdList") List<Integer> subCatIdList);

	@Query(value=" SELECT  t.*,u.user_name "
			+ " FROM t_gallery_header t ,m_user u WHERE  t.sub_cat_id IN(:subCatIdList) AND t.del_status=1  AND  u.user_id=t.user_id ",nativeQuery = true)
	List<GetGalleryHeaderByCatId> findBySubCatId(@Param("subCatIdList") List<Integer>  subCatIdList);
	
	
	@Query(value=" SELECT  t.*,u.user_name "
			+ " FROM t_gallery_header t ,m_user u WHERE  t.cat_id IN(:catIdList) AND t.del_status=1  AND  u.user_id=t.user_id",nativeQuery = true)
	List<GetGalleryHeaderByCatId> findByCatId(@Param("catIdList") List<Integer> catIdList);

	@Query(value=" SELECT  t.*,u.user_name FROM t_gallery_header t,m_user u WHERE u.user_id=t.user_id"
			+ " AND t.del_status=1",nativeQuery = true)
	List<GetGalleryHeaderByCatId> find();

}
