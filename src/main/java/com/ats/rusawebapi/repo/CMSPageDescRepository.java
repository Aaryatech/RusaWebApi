package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.CMSPageDescription;

public interface CMSPageDescRepository extends JpaRepository<CMSPageDescription, Integer>{
 
	List<CMSPageDescription> findAllByCmsPageId(int cmsPageId);

}
