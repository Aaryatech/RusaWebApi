package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.PagesModule;

public interface PagesModuleRepository extends JpaRepository<PagesModule ,Integer>{

	@Query(value="select module_id from t_tpages_modules where  page_id=:pageId group by module_id",nativeQuery=true) 
	List<Integer> getmoduleList(@Param("pageId") int pageId);

}
