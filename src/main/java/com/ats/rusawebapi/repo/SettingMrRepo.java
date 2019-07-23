package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.Setting;
import com.ats.rusawebapi.model.SettingMr;

public interface SettingMrRepo extends JpaRepository<SettingMr, Integer> {
	
	@Query(value="select * from m_settingsall order by setting_id asc",nativeQuery=true) 
	List<SettingMr> findAllOrderByAsc();
	
	@Query(value="select * from m_settingsall_mr order by setting_id asc",nativeQuery=true) 
	List<SettingMr> findAllMrOrderByAsc();
	
	
}
