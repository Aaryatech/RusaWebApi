package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.Maintainance; 

public interface SiteMaintenanceRepository extends JpaRepository<Maintainance, Integer>{

	@Query(value="select * from m_maintenance  where id=1",nativeQuery=true)
	Maintainance checkIsMaintenance();



	/*@Query(value="select * from m_setting  where m_setting.key=:mantenancesKey",nativeQuery=true) 
	SiteMaitenance getSiteDetails(@Param("mantenancesKey") String mantenancesKey);*/
	
	/*@Transactional
	@Modifying
	@Query(value="update SiteMaitenance set group=:group , value=:message where setting_id=:settingId") 
	int updateSiteMaintenance(@Param("group") String group,@Param("message") String message,@Param("settingId") int settingId);*/

	
}
