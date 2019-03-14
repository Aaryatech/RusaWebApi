package com.ats.rusawebapi.repo;

import java.util.List;

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

	List<Registration> findByDelStatusOrderByRegId(int i);

	@Transactional
	@Modifying
	@Query("update Registration set email_verified=1  WHERE reg_id=:regId")
	int updateEmailStatus(@Param("regId") int regId);

	Registration findByUserUuidAndDelStatusAndSmsVerified(String uuid, int i, int j);

	@Transactional
	@Modifying
	@Query("update Registration set sms_code=:otp  WHERE reg_id=:uuid")
	int updateOtpByUuid(String uuid,String otp);
	

	

}
