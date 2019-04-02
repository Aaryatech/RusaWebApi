package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.EventReg;


public interface EventRegRepo extends JpaRepository<EventReg, Integer>{
	
	@Query(value="select n.newsblogs_id,n.event_location,n.event_date_from,n.event_date_to,n.event_contact_person,n.event_contact_number"
			+ ",n.featured_image,n.download_pdf,n.is_active,n.del_status,n.ex_int1,e.ex_int2,nd.heading,nd.descriptions,nd.language_id"
			+ ",nd.page_meta_title,nd.page_meta_description,nd.page_meta_keyword,e.user_id,e.reg_date,e.status_approval,e.doc1,e.doc2,r.name  \r\n" + 
			"from t_newsblogs n,t_newsblogs_description nd,event_registration e,t_registration r "
			+ "where DATE(n.event_date_from) < DATE(NOW()) and n.is_active=1  and n.del_status=1 and n.newsblogs_id=nd.newsblogs_id and "
			+ "nd.language_id=:langId and n.ex_int1=11 group by n.newsblogs_id DESC\r\n" + 
			"",nativeQuery=true)
	List<EventReg> getAllPreviousEvents(int langId);

}
