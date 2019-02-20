package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.CMSPageDescription;

public interface CMSPageDescRepository extends JpaRepository<CMSPageDescription, Integer>{
 
	List<CMSPageDescription> findAllByCmsPageId(int cmsPageId);

	@Query(value="SELECT d.* FROM t_cms_pages_description d where d.ex_int1='1' ",nativeQuery=true)
	List<CMSPageDescription> getCMSDescByExInt1();

}
