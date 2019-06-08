package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.Setting;

public interface SettingRepo extends JpaRepository<Setting, Integer>
{

	List<Setting> findByIsActiveOrderBySettingId(int i);

	List<Setting> findByIsActive(int i);

	List<Setting> findAll();
	
	@Transactional
	@Modifying
	@Query(value="update m_settingsall set key_values = key_value+1 where setting_id=5",nativeQuery=true) 
	Setting getWebSiteCount();
	
	@Transactional
	@Modifying
	@Query(value="update m_settingsall set key_values =:lastdate where setting_id=6",nativeQuery=true) 
	int updateWebSiteDate(@Param("lastdate") String lastdate);

	Setting findByKeyName(String key);

	@Query(value="select * from m_settingsall order by setting_id asc",nativeQuery=true) 
	List<Setting> findAllOrderByAsc();
	
	
	@Transactional
	@Modifying
	@Query(value="update m_settingsall set key_values =:value where key_name=:keyName",nativeQuery=true) 
	int updateSetting(@Param("value") String value,@Param("keyName") String keyName);
}
