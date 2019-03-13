package com.ats.rusawebapi.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.Registration;
import com.ats.rusawebapi.model.mst.User;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{

	Registration findByUserUuidAndUserTypeAndDelStatus(int suuid, int type, int i);

	Registration findByUserUuidAndDelStatusAndIsActiveAndSmsVerified(String uuid, int i, int j, int k);

	Registration findBySmsCodeAndUserUuidAndDelStatus(String userOtp, String uuid, int i);
	
	@Transactional
	@Modifying
	@Query("UPDATE Registration SET sms_verified=:i WHERE reg_id=:regId ") 
	int updateSmsStatus(@Param("i") int i, @Param("regId") int regId);
	

	

}
