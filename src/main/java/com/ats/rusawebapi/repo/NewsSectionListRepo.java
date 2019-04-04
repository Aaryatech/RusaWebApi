package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.NewsSectionList;

public interface NewsSectionListRepo extends JpaRepository<NewsSectionList, Integer>{

	
	@Query(value="select nh.*,nd.heading,nd.descriptions from t_newsblogs nh,t_newsblogs_description nd where find_in_set(:sectionId,nh.ex_var2) and "
			+ "nh.is_active=1 and nh.del_status=1 and nh.ex_int1=9 and nd.newsblogs_id=nh.newsblogs_id and nd.language_id=:langId order by page_order asc",nativeQuery=true) 
	List<NewsSectionList> getNewsSectionBySectionId(@Param("sectionId") int sectionId,@Param("langId") int langId);

}
