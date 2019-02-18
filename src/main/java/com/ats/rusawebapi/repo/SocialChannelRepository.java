package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.ImageLink;
import com.ats.rusawebapi.model.SocialChannels;

public interface SocialChannelRepository extends JpaRepository<SocialChannels, Integer>{

	SocialChannels findByIdAndDelStatus(int id, int i);

	List<SocialChannels> findByDelStatusOrderById(int i);

	//List<ImageLink> findByDelStatusOrderById(int i);
	
	@Transactional
	@Modifying
	@Query("update SocialChannels set del_status=0  WHERE id=:id")
	int deleteChannel(int id);

}
