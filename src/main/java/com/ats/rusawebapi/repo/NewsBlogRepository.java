package com.ats.rusawebapi.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.NewsBlog;

public interface NewsBlogRepository extends JpaRepository<NewsBlog, Integer>{


	NewsBlog findByNewsblogsId(int newsblogsId);

	@Transactional
	@Modifying
	@Query("update NewsBlog set del_status=0  WHERE newsblogs_id=:newsblogsId")
	int deleteNewsBlog(@Param("newsblogsId") int newsblogsId);

}
