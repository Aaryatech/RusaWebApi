package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.EventDetails;
import com.ats.rusawebapi.model.EventRegistration;

public interface EventRegisterRepository extends JpaRepository<EventRegistration, Integer> {

	@Transactional
	@Modifying
	@Query("update EventRegistration set status_approval=1  WHERE event_reg_id=:eventId")
	int updateApproveStatus(@Param("eventId") int eventId);

	EventRegistration findByEventRegIdAndDelStatus(int eventRegId, int i);

	List<EventRegistration> findByNewsblogsIdAndUserIdAndStatusApproval(int newsblogsId, int userId, int i);

	EventRegistration findByNewsblogsIdAndUserId(int newsblogsId, int userId);

	
	
	@Transactional
	@Modifying
	@Query("update EventRegistration set doc1=:pdfName  WHERE user_id=:regId and newsblogs_id=:newsblogsId")
	int updateDocByRegId(@Param("regId") int regId, @Param("newsblogsId") int newsblogsId, @Param("pdfName") String pdfName);

	@Transactional
	@Modifying
	@Query("update EventRegistration set ex_int1=1,ex_int2=:value,ex_var1=:messge  WHERE newsblogs_id=:eventId and user_id=:userId")
	int updateEventFeedback(@Param("eventId")int eventId,@Param("userId") int userId,@Param("messge") String messge,
			@Param("value")int value);

	
	/*
	 * @Query(
	 * value="select count(*) as totalApplied from event_registration ,t_newsblogs "
	 * + "where event_registration.del_status=1 and " +
	 * "event_registration.newsblogs_id = t_newsblogs.newsblogs_id  ",nativeQuery=
	 * true) Integer getAllEventAppliedCount();
	 * 
	 * @Query(
	 * value="select count(*) as totalApproved from event_registration ,t_newsblogs "
	 * + "where event_registration.del_status=1 and " +
	 * "event_registration.newsblogs_id = t_newsblogs.newsblogs_id  ",nativeQuery=
	 * true) Integer getAllEventApprovedCount();
	 * 
	 */

}
