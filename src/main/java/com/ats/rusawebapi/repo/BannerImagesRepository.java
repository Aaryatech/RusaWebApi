package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.MetaData;

public interface BannerImagesRepository extends JpaRepository<BannerImages, Integer>{

	BannerImages findByIdAndDelStatus(int id, int i);

	List<BannerImages> findByDelStatusOrderById(int i);

	@Transactional
	@Modifying
	@Query("update BannerImages set del_status=0  WHERE id=:id")
	int deleteBannerImages(@Param("id") int id);
	
	@Query(value="SELECT b.* FROM m_banner_slider b where is_active=1 and del_status=1 ORDER BY b.id DESC LIMIT 1",nativeQuery=true)
	BannerImages getLastSliderImagesByStatus(int i);

//	MetaData save(MetaData getMataDataList);

}
