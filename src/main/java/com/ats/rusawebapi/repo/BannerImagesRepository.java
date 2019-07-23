package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.MetaData;

public interface BannerImagesRepository extends JpaRepository<BannerImages, Integer> {

	BannerImages findByIdAndDelStatus(int id, int i);

	List<BannerImages> findByDelStatusOrderById(int i);

	@Transactional
	@Modifying
	@Query("update BannerImages set del_status=0  WHERE id=:id")
	int deleteBannerImages(@Param("id") int id);

	@Query(value = "SELECT h.id,h.cate_id,d.slider_name,h.url_link,d.link_name,d.text1,d.text2,h.text3,h.slider_image,"
			+ "h.sort_order,h.add_date,h.edit_date,h.added_by_user_id,h.edit_by_user_id,h.is_active,h.del_status FROM m_banner_slider h,"
			+ "m_banner_detail d where h.is_active=1 and h.del_status=1 and d.cate_id=h.id and d.sort_order=:langId ORDER BY h.id DESC LIMIT 1", nativeQuery = true)
	BannerImages getLastSliderImagesByStatus( int langId);

//	MetaData save(MetaData getMataDataList);

}
