package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.NewsDetails;

public interface NewsDetailsRepository extends JpaRepository<NewsDetails, Integer>{

	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id from t_newsblogs n,t_newsblogs_description nd "
			+ "where  n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId "
			+ "and n.page_id=:pageId and n.ex_int1=9 order by n.page_order",nativeQuery=true)
	List<NewsDetails> getNewsContent(@Param("langId") int langId,@Param("pageId") int pageId);
}
