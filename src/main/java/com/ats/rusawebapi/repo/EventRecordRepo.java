package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.EventRecord;

public interface EventRecordRepo extends JpaRepository<EventRecord, Integer>{

	
	@Query(value="select\n" + 
			"        n.newsblogs_id, \n" + 
			"        nd.heading,\n" + 
			"        nd.descriptions,\n" + 
			"        nd.language_id,\n" + 
			"        n.featured_image,\n" + 
			"        n.download_pdf,\n" + 
			"        DATE(n.event_date_from) as date,\n" + 
			"        coalesce((select 1 from event_registration where user_id=:userId and newsblogs_id=n.newsblogs_id),0) as apply ,coalesce((select\n" + 
			"            ex_int1 \n" + 
			"        from\n" + 
			"            event_registration \n" + 
			"        where\n" + 
			"            user_id=:userId \n" + 
			"            and newsblogs_id=n.newsblogs_id),\n" + 
			"        0) as is_feedback, coalesce((select\n" + 
			"            ex_var1          \n" + 
			"        from\n" + 
			"            event_registration          \n" + 
			"        where\n" + 
			"            user_id=:userId              \n" + 
			"            and newsblogs_id=n.newsblogs_id),\n" + 
			"        '-') as feedback \n" + 
			"    from\n" + 
			"        t_newsblogs n,\n" + 
			"        t_newsblogs_description nd \n" + 
			"    where\n" + 
			"        DATE(n.event_date_from) < DATE(NOW()) \n" + 
			"        and  n.is_active=1  \n" + 
			"        and n.del_status=1 \n" + 
			"        and n.newsblogs_id=nd.newsblogs_id \n" + 
			"        and nd.language_id=:langId\n" + 
			"        and n.ex_int1=11 \n" + 
			"    order by\n" + 
			"        n.newsblogs_id DESC ",nativeQuery=true) 
	List<EventRecord> getAllPreviousEvents(@Param("langId") int langId,@Param("userId") int userId);

}
