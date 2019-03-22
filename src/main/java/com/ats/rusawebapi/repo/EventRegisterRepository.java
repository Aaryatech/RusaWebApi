package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.EventDetails;
import com.ats.rusawebapi.model.EventRegistration;

public interface EventRegisterRepository extends JpaRepository<EventRegistration, Integer>{

	@Transactional
	@Modifying
	@Query("update EventRegistration set status_approval=1  WHERE event_reg_id=:eventId")
	int updateApproveStatus(@Param("eventId") int eventId);

	EventRegistration findByEventRegIdAndDelStatus(int eventRegId, int i);


}
