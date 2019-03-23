package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.NewsBlog;
import com.ats.rusawebapi.model.NewsDetails;

public interface NewsDetailsRepository extends JpaRepository<NewsDetails, Integer>
{

	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword from t_newsblogs n,t_newsblogs_description nd "
			+ "where  n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId "
			+ "and n.page_id=:pageId and n.ex_int1=9 order by n.page_order",nativeQuery=true)
	List<NewsDetails> getNewsContent(@Param("langId") int langId,@Param("pageId") int pageId);

	    
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword from t_newsblogs n,t_newsblogs_description nd "
			+ "where  n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId "
			+ "and n.page_id=:pageId and n.ex_int1=9 and n.newsblogs_id=:newsblogsId order by n.page_order",nativeQuery=true)
	NewsDetails getNewsList(@Param("langId") int langId,@Param("pageId") int pageId,@Param("newsblogsId") int newsblogsId);
	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd "
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=9",nativeQuery=true)
	List<NewsDetails> getNewsBlogListByLangId(@Param("langId") int langId);
	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd "
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=1 and n.ex_int1=9",nativeQuery=true)
	List<NewsDetails> getAllNewsBlogList();

	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd "
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=1 and n.ex_int1=13",nativeQuery=true)
	List<NewsDetails> getTeamList();

	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd "
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=1 and n.ex_int1=8",nativeQuery=true)
	List<NewsDetails> getLastTenSuccessStory();

	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd "
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=9 ORDER BY n.newsblogs_id DESC LIMIT 4",nativeQuery=true)
	List<NewsDetails> getLastFourNewsByLangId(int langId);
	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword \r\n" + 
			"from t_newsblogs n,t_newsblogs_description nd where DATE(n.event_date_from) < DATE(NOW()) and  n.is_active=1  and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=11 order by n.newsblogs_id DESC\r\n" + 
			"",nativeQuery=true)
	List<NewsDetails> getAllPreviousEvents(int langId);
	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword \r\n" + 
			"from t_newsblogs n,t_newsblogs_description nd where DATE(n.event_date_from) >= DATE(NOW()) and n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=11 order by n.newsblogs_id DESC\r\n" + 
			"",nativeQuery=true)
	List<NewsDetails> getAllUpcomingEvents(int langId);
	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword from t_newsblogs n,t_newsblogs_description nd where  n.is_active=1  and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=11 order by n.newsblogs_id ",nativeQuery=true)
	List<NewsDetails> getAllEvents(int langId);
}



