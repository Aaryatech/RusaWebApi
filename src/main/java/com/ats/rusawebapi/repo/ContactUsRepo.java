package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.ContactUs;

public interface ContactUsRepo extends JpaRepository<ContactUs, Integer>{

	@Transactional
	@Modifying
	@Query("update ContactUs set del_status=0  WHERE id=:id")
	int deleteContactId(@Param("id")int id);

	List<ContactUs> findByDelStatusOrderById(int i);

	ContactUs findByIdAndDelStatus(int id, int i);

	@Transactional
	@Modifying
	@Query("update ContactUs set del_status=0  WHERE id in (:id)")
	int deleteMultipleContact(@Param("id") List<Integer> id);

	@Transactional
	@Modifying
	@Query("update ContactUs set del_status=1  WHERE id=:id")
	int retriveContact(@Param("id")int id);

}
