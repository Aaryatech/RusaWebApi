package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.Setting;

public interface SettingRepo extends JpaRepository<Setting, Integer>
{

	List<Setting> findByIsActiveOrderBySettingId(int i);

	List<Setting> findByIsActive(int i);

	List<Setting> findAll();

	@Query(value="update Setting set key_value = key_value+1 where setting_id=5",nativeQuery=true) 
	Setting getWebSiteCount();
}
