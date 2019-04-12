package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.EventDetail;

public interface EventDetailRepo extends JpaRepository<EventDetail, Integer> {

	@Query(value = "select e.* ,r.name,nd.heading,r.mobile_number "
			+ "from t_registration r,event_registration e, t_newsblogs_description nd,t_newsblogs n "
			+ "where n.newsblogs_id=e.newsblogs_id and n.is_active=1 and "
			+ " n.newsblogs_id=nd.newsblogs_id and n.ex_int1=11  and r.reg_id=e.user_id and e.newsblogs_id=:eventRegId group by :eventRegId ", nativeQuery = true)
	List<EventDetail> getEventDetailList(@Param("eventRegId") int eventRegId);

	
	@Query(value = " select e.* ,r.name,nd.heading,r.mobile_number from t_registration r,event_registration e, t_newsblogs_description nd,t_newsblogs n \n" + 
			"where e.newsblogs_id=:newsblogsId and n.is_active=1 and e.newsblogs_id= n.newsblogs_id  and  n.newsblogs_id=nd.newsblogs_id and n.ex_int1=11  and r.reg_id=e.user_id group by event_reg_id", nativeQuery = true)	
	List<EventDetail> getUserDetailList(@Param("newsblogsId") int newsblogsId);
}

/*
 * 
 * @Query(value = "select e.* ,r.name,nd.heading,r.mobile_number " +
 * "from t_registration r,event_registration e, t_newsblogs_description nd,t_newsblogs n "
 * +
 * "where n.newsblogs_id=e.newsblogs_id and n.is_active=1 and e.user_id=:regId and n.newsblogs_id=nd.newsblogs_id and n.ex_int1=11 AND e.event_reg_id=:eventRegId "
 * , nativeQuery = true) List<EventDetail> getEventDetailList(@Param("regId")
 * int regId, @Param("eventRegId") int eventRegId);
 */
/*
 * select e.* ,r.name,nd.heading,r.mobile_number from t_registration
 * r,event_registration e, t_newsblogs_description nd,t_newsblogs n where
 * n.newsblogs_id=e.newsblogs_id and n.is_active=1 and e.user_id IN(2,5) and
 * n.newsblogs_id=nd.newsblogs_id and n.ex_int1=11 and r.reg_id=e.user_id and
 * e.newsblogs_id=18 group by e.event_reg_id
 * 
 * select e.* ,r.name,nd.heading,r.mobile_number from t_registration
 * r,event_registration e, t_newsblogs_description nd,t_newsblogs n where
 * n.newsblogs_id=e.newsblogs_id and n.is_active=1 and e.user_id IN(2,5) and
 * n.newsblogs_id=nd.newsblogs_id and n.ex_int1=11 and r.reg_id=e.user_id and
 * e.newsblogs_id=18
 */