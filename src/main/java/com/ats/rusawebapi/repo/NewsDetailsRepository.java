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
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=9",nativeQuery=true)
	List<NewsDetails> getAllNewsBlogList(@Param("langId") int langId);

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
	NewsDetails getNewsListByNewsId(@Param("newsblogsId") int newsblogsId,@Param("langId") int langId);

	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd "
			+ "where n.is_active=1  and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=11 order by n.newsblogs_id limit :pageid,:total ",nativeQuery=true)
	List<NewsDetails> getAllEventsByLimit(@Param("langId") int langId,@Param("pageid") int pageid,@Param("total") int total);

	@Query(value="select n.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword "
			+ "from t_newsblogs n,t_newsblogs_description nd "
			+ "where n.is_active=1 and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and nd.language_id=:langId and n.ex_int1=9 order by n.newsblogs_id limit :pageid,:total",nativeQuery=true)
	List<NewsDetails> getAllNewsByLimit(int langId, int pageid, int total);



	@Query(value="select\r\n" + 
			"        n.*,\r\n" + 
			"        nd.heading,\r\n" + 
			"        nd.descriptions,\r\n" + 
			"        nd.language_id,\r\n" + 
			"        nd.page_meta_title,\r\n" + 
			"        nd.page_meta_description,\r\n" + 
			"        nd.page_meta_keyword   \r\n" + 
			"    from\r\n" + 
			"        t_newsblogs n,\r\n" + 
			"        t_newsblogs_description nd \r\n" + 
			"    where\r\n" + 
			"        n.event_date_from >= :date\r\n" + 
			"        and n.is_active=1 \r\n" + 
			"        and n.del_status=1 \r\n" + 
			"        and n.newsblogs_id=nd.newsblogs_id \r\n" + 
			"        and nd.language_id=:langId \r\n" + 
			"        and n.ex_int1=11 \r\n" + 
			"    order by\r\n" + 
			"        n.event_date_from DESC ",nativeQuery=true)
	List<NewsDetails> newsListForHomePage(@Param("langId")int langId, @Param("date")String date);


	@Query(value="select\r\n" + 
			"        n.*,\r\n" + 
			"        nd.heading,\r\n" + 
			"        nd.descriptions,\r\n" + 
			"        nd.language_id,\r\n" + 
			"        nd.page_meta_title,\r\n" + 
			"        nd.page_meta_description,\r\n" + 
			"        nd.page_meta_keyword   \r\n" + 
			"    from\r\n" + 
			"        t_newsblogs n,\r\n" + 
			"        t_newsblogs_description nd \r\n" + 
			"    where\r\n" + 
			"        n.event_date_from < :date\r\n" + 
			"        and n.is_active=1 \r\n" + 
			"        and n.del_status=1 \r\n" + 
			"        and n.newsblogs_id=nd.newsblogs_id \r\n" + 
			"        and nd.language_id=:langId \r\n" + 
			"        and n.ex_int1=11 \r\n" + 
			"    order by\r\n" + 
			"        n.event_date_from DESC \r\n" + 
			"    limit 10",nativeQuery=true)
	List<NewsDetails> newsExpiredListForHomePage(@Param("langId") int langId,@Param("date")  String date);


	@Query(value="select \r\n" + 
			"        n.newsblogs_id,\r\n" + 
			"        n.newsblogs_cat_id,\r\n" + 
			"        n.page_id,\r\n" + 
			"        n.news_source_url_name,\r\n" + 
			"        n.event_location,\r\n" + 
			"        n.event_date_from,\r\n" + 
			"        n.event_date_to,\r\n" + 
			"        n.event_contact_person,\r\n" + 
			"        n.event_contact_number,\r\n" + 
			"        n.page_order,\r\n" + 
			"        n.featured_image,\r\n" + 
			"        n.featured_image_alignment,\r\n" + 
			"        n.download_pdf,\r\n" + 
			"        n.is_active,\r\n" + 
			"        n.del_status,\r\n" + 
			"        n.add_date,\r\n" + 
			"        n.edit_date,\r\n" + 
			"        n.added_by_user_id,\r\n" + 
			"        n.edit_by_user_id,\r\n" + 
			"        n.views_count,\r\n" + 
			"        n.ex_int2,\r\n" + 
			"        n.ex_var1,\r\n" + 
			"        n.ex_var2,\r\n" + 
			"        coalesce((select\r\n" + 
			"            1 \r\n" + 
			"        from\r\n" + 
			"            event_registration \r\n" + 
			"        where\r\n" + 
			"            user_id=:userId \r\n" + 
			"            and newsblogs_id=n.newsblogs_id),\r\n" + 
			"        0)  as ex_int1,\r\n" + 
			"        nd.heading,\r\n" + 
			"        nd.descriptions,\r\n" + 
			"        nd.language_id,\r\n" + 
			"        nd.page_meta_title,\r\n" + 
			"        nd.page_meta_description,\r\n" + 
			"        nd.page_meta_keyword   \r\n" + 
			"    from\r\n" + 
			"        t_newsblogs n,\r\n" + 
			"        t_newsblogs_description nd \r\n" + 
			"    where\r\n" + 
			"        DATE(n.event_date_from) >= DATE(NOW()) \r\n" + 
			"        and n.is_active=1 \r\n" + 
			"        and n.del_status=1 \r\n" + 
			"        and n.newsblogs_id=nd.newsblogs_id \r\n" + 
			"        and nd.language_id=:langId \r\n" + 
			"        and n.ex_int1=11 \r\n" + 
			"    order by\r\n" + 
			"        n.newsblogs_id DESC",nativeQuery=true)
	List<NewsDetails> getAllUpcomingEventsWithIsApply(@Param("langId")int langId, @Param("userId") int userId);
	 

}
 