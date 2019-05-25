package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.DashboardCount;

public interface DashboardCountRepository extends JpaRepository<DashboardCount, Integer>{

	@Query(value="select coalesce((select count(*) from m_contact_us where del_status=1),0) as contact_count,coalesce((select count(*) from t_registration where del_status=1 and is_active=0 and sms_verified=1),0) as new_user_count\n" + 
			",coalesce((select count(*) from t_registration where del_status=1 and  sms_verified=1 and user_type=2),0) as collage_user_count ,coalesce((select count(*) from t_registration where del_status=1 and  sms_verified=1 and user_type=3),0) as univercity_user_count,coalesce((select count(*) from t_registration where del_status=1 and  sms_verified=1 and user_type=1),0) as individual_user_count",nativeQuery=true)
	DashboardCount dashboardCount();

}
