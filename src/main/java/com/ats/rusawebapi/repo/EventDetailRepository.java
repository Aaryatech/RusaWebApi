package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.EventDetail;
import com.ats.rusawebapi.model.EventDetails;

public interface EventDetailRepository extends JpaRepository<EventDetails, Integer>{
	
	@Query(value="select n.*,nd.event_reg_id,nd.user_id,nd.reg_date,nd.event_reg_id "
			+ "from t_registration n,event_registration nd "
			+ "where n.del_status=1 and n.reg_id=nd.user_id",nativeQuery=true)
	List<EventDetails> getAllEventRegisteredUser();
	
	

}
