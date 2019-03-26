package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{

	@Query(value="SELECT ev.newsblogs_id as id,'event-info' as class, (unix_timestamp( DATE_FORMAT(ev.event_date_from, '%Y/%m/%d 10:00:00')) * 1000 ) as start , (unix_timestamp( DATE_FORMAT(ev.event_date_from, '%Y/%m/%d 10:00:00')) * 1000 ) as end , ed.heading as title ,'#' as url       FROM `t_newsblogs` ev\n" + 
			"inner join t_newsblogs_description ed on ev.newsblogs_id = ed.newsblogs_id \n" + 
			"where   ed.language_id=1 and ev.ex_int1=11 and ev.event_date_from >= CURDATE();",nativeQuery=true)
	List<Result> getEventListforCalender();

	 
}
