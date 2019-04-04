package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.EventCountDetails;

public interface EventCount extends JpaRepository<EventCountDetails, Integer>{


	  @Query(value="select nh.*,nd.heading,nd.descriptions,nd.language_id,nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword,\r\n" + 
			  		"coalesce((select count(event_reg_id) from event_registration where nh.newsblogs_id=event_registration.newsblogs_id and event_registration.status_approval=0),0) as applied,\r\n" + 
			  		"coalesce((select count(event_reg_id) from event_registration where nh.newsblogs_id=event_registration.newsblogs_id and event_registration.status_approval=1),0) as approved\r\n" + 
			  		",coalesce((select count(event_reg_id) from event_registration where nh.newsblogs_id=event_registration.newsblogs_id and event_registration.status_approval=2),0) as not_approved "
			  		+ "from t_newsblogs nh,t_newsblogs_description nd where nd.newsblogs_id=nh.newsblogs_id and nd.language_id=1 and nh.del_status=1 and nh.is_active=1 and nh.ex_int1=11 ",nativeQuery=true)
	List<EventCountDetails> getAllEvents();  
}
