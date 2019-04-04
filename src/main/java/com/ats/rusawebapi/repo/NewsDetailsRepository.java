package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.NewsBlog;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.Registration;

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
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=9 and nd.ex_int1=1 ORDER BY n.newsblogs_id DESC LIMIT 4",nativeQuery=true)
	List<NewsDetails> getLastFourNewsByLangId(int langId);
	
	@Query(value="select n.*,e.ex_int1,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword \r\n" + 
			"from t_newsblogs n,t_newsblogs_description nd,event_registration e where DATE(n.event_date_from) < DATE(NOW()) and  n.is_active=1  and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=11 order by n.newsblogs_id DESC\r\n" + 
			"",nativeQuery=true)
	List<NewsDetails> getAllPreviousEvents(int langId);
	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword \r\n" + 
			"from t_newsblogs n,t_newsblogs_description nd where DATE(n.event_date_from) >= DATE(NOW()) and n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=11 order by n.newsblogs_id DESC\r\n" + 
			"",nativeQuery=true)
	List<NewsDetails> getAllUpcomingEvents(int langId);
	
	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword from t_newsblogs n,t_newsblogs_description nd where  n.is_active=1  and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=11 order by n.newsblogs_id ",nativeQuery=true)
	List<NewsDetails> getAllEvents(int langId);



	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd where n.event_date_from between :firstDate and :endDate "
			+ "and n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=1 "
			+ "and n.ex_int1=11 order by n.newsblogs_id ",nativeQuery=true)
	List<NewsDetails> getCurrentMonthE(String firstDate, String endDate);


	
	  @Query(
	  value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
	  + "from t_newsblogs n,t_newsblogs_description nd " +
	  "where n.is_active=1  and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id "
	  + "and nd.language_id=:langId and n.ex_int1=11 and n.newsblogs_id=:newsblogsId ",nativeQuery=true) 
	  NewsDetails getEventListByNewblogsId(@Param("newsblogsId") int newsblogsId,@Param("langId") int langId);

	  @Query(
			  value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			  		+ "from t_newsblogs n,t_newsblogs_description nd where n.is_active=1  "
			  		+ "and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId "
			  		+ "and n.ex_int1=9 and n.newsblogs_id=:newsblogsId ",nativeQuery=true) 
	NewsDetails getNewsListByNewsId(int newsblogsId, int langId);





	//NewsDetails getEventListByNewblogsId(int langId, int pageId, int newsblogsId);
	 

}
/*
 * select nh.*,nh.newsblogs_id,nd.heading,nd.descriptions,nd.language_id,nd.
 * page_meta_title,nd.page_meta_description,nd.page_meta_keyword,
 * coalesce((select count(event_reg_id) from event_registration where
 * nh.newsblogs_id=event_registration.newsblogs_id and
 * event_registration.status_approval=0),0) as applied, coalesce((select
 * count(event_reg_id) from event_registration where
 * nh.newsblogs_id=event_registration.newsblogs_id and
 * event_registration.status_approval=1),0) as approved ,coalesce((select
 * count(event_reg_id) from event_registration where
 * nh.newsblogs_id=event_registration.newsblogs_id and
 * event_registration.status_approval=2),0) as notApprove from t_newsblogs
 * nh,t_newsblogs_description nd where nd.newsblogs_id=nh.newsblogs_id and
 * nd.language_id=1 and nh.del_status=1 and nh.is_active=1 and nh.ex_int1=11
 * 
 * 
 */