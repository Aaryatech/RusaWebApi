package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.ImageLink;

public interface ImageLinkRepository extends JpaRepository<ImageLink, Integer>{

	ImageLink findByIdAndDelStatus(int id, int i);

	List<ImageLink> findByDelStatusOrderById(int i);
	@Transactional
	@Modifying
	@Query("update ImageLink set del_status=0  WHERE id=:id")
	int deleteImageLinks(@Param("id") int id);

	List<ImageLink> findByDelStatusAndIsActiveOrderBySortOrder(int i, int j);

}
