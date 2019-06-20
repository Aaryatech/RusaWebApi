package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.CMSPages;

public interface CMSPagesRepository extends JpaRepository<CMSPages , Integer>{

	@Transactional
	@Modifying
	@Query("update CMSPages set del_status=0  WHERE cms_page_id=:cmsPageId")
	int delete(@Param("cmsPageId") int cmsPageId);

	CMSPages findByCmsPageId(int cmsPageId);
	
	
	@Transactional
	@Modifying
	@Query("update CMSPages set del_status=0  WHERE cms_page_id IN(:id)")

	int deleteMultipleCMSPage(@Param("id") List<Integer> id);

}
