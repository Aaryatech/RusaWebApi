package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.EventView;


public interface EventViewRepository extends JpaRepository<EventView, Integer>{

	
	/*
	 * @Query(value="  select\n" + "        t.newsblogs_id,\n" +
	 * "        pm.module_id,\n" + "        nd.heading,\n" +
	 * "        nd.descriptions,\n" + "        t.add_date,\n" +
	 * "        t.edit_date,\n" + "        t.event_location,\n" +
	 * "        t.event_date_from,\n" + "        t.event_contact_person,\n" +
	 * "        t.event_contact_number,\n" + "        t.ex_int2   ,\n" +
	 * "        (select\n" + "            count(*) \n" + "        from\n" +
	 * "            event_registration e \n" + "        where\n" +
	 * "            e.del_status=1 \n" +
	 * "            and t.newsblogs_id=e.newsblogs_id ) as totalApplied ,	  (select  count(*) from   event_registration e  where   e.del_status=1 and  e.status_approval=1  and t.newsblogs_id=e.newsblogs_id ) as totalApproved\n"
	 * + "    from\n" + "        t_tpages_modules pm,\n" + "        t_pages p,\n" +
	 * "        m_modules_name m,\n" + "        t_newsblogs t  ,\n" +
	 * "        t_newsblogs_description nd  \n" + "    where\n" +
	 * "        p.page_id=pm.module_id  \n" +
	 * "        and t.newsblogs_id=pm.primary_key_id \n" +
	 * "        and pm.module_id=11 \n" + "        and t.del_status=1 \n" +
	 * "        and t.newsblogs_id=nd.newsblogs_id \n" +
	 * "        and nd.language_id=1 \n" + "    group by\n" +
	 * "        t.newsblogs_id   \n" + "",nativeQuery=true)
	 * 
	 * List<EventView> getAllEventsListCount();
	 */
 
	@Query(value="  select\n" + 
			"        t.newsblogs_id,\n" + 
			"        pm.module_id,\n" + 
			"        nd.heading,\n" + 
			"        nd.descriptions,\n" + 
			"        t.add_date,\n" + 
			"        t.edit_date,\n" + 
			"        t.event_location,\n" + 
			"        t.event_date_from,\n" + 
			"        t.event_contact_person,\n" + 
			"        t.event_contact_number,\n" + 
			"        t.ex_int2 "
			+ "from\n" + 
			"        t_tpages_modules pm,\n" + 
			"        t_pages p,\n" + 
			"        m_modules_name m,\n" + 
			"        t_newsblogs t  ,\n" + 
			"        t_newsblogs_description nd  \n" + 
			"    where\n" + 
			"        p.page_id=pm.module_id  \n" + 
			"        and t.newsblogs_id=pm.primary_key_id \n" + 
			"        and pm.module_id=11 \n" + 
			"        and t.del_status=1 \n" + 
			"        and t.newsblogs_id=nd.newsblogs_id and t.ex_int1=11\n" + 
			"        and nd.language_id=1 \n" + 
			"    group by\n" + 
			"        t.newsblogs_id   \n" + 
			"",nativeQuery=true) 

	List<EventView> getAllEvents();
	
	/*
	 * @Query(
	 * value="select count(*) as totalApplied, t.newsblogs_id, pm.module_id,nd.heading,nd.descriptions,t.add_date,t.edit_date,t.event_location,t.event_date_from,t.event_contact_person,t.event_contact_number,t.ex_int2\r\n"
	 * +
	 * "	from t_tpages_modules pm, t_pages p, m_modules_name m,t_newsblogs t  ,t_newsblogs_description nd ,event_registration e "
	 * +
	 * "where p.page_id=pm.module_id  and t.newsblogs_id=pm.primary_key_id and pm.module_id=11 and t.del_status=1 and t.newsblogs_id=nd.newsblogs_id and nd.language_id=1 and t.newsblogs_id=e.newsblogs_id  group by t.newsblogs_id\r\n"
	 * + "	",nativeQuery=true)
	 * 
	 * List<EventView> getAllEventAppliedCount();
	 * 
	 * @Query(
	 * value="select count(*) as totalApproved, t.newsblogs_id, pm.module_id,nd.heading,nd.descriptions,t.add_date,t.edit_date,t.event_location,t.event_date_from,t.event_contact_person,t.event_contact_number,t.ex_int2\r\n"
	 * +
	 * "	from t_tpages_modules pm, t_pages p, m_modules_name m,t_newsblogs t  ,t_newsblogs_description nd ,event_registration e	"
	 * +
	 * "where p.page_id=pm.module_id  and t.newsblogs_id=pm.primary_key_id and pm.module_id=11 and t.del_status=1 and t.newsblogs_id=nd.newsblogs_id and nd.language_id=1 and t.newsblogs_id=e.newsblogs_id and e.status_approval=1 group by t.newsblogs_id\r\n"
	 * + "	",nativeQuery=true)
	 * 
	 * List<EventView> getAllEventApprovedCount();
	 */
}
