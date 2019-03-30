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

	Registration findByUserUuidAndDelStatusAndSmsVerified(String uuid, int i, int j);

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

	//Registration findByUserUuidAndDelStatusAndSmsVerified(String uuid, int i, int j);

	@Transactional
	@Modifying
	@Query("update Registration set sms_code=:otp  WHERE user_uuid=:uuid")
	int updateOtpByUuid(@Param("uuid") String uuid,@Param("otp") String otp);

	Registration findByRegIdAndDelStatus(int regId, int i);

	Registration findByUserUuidAndDelStatus(String uuid, int i);

	@Transactional
	@Modifying
	@Query("update Registration set sms_code=:otp  WHERE user_uuid=:uuid")
	int updateOtp(@Param("otp") String otp, @Param("uuid") String uuid);

	//Registration findByEmailsAndUserPasswordAndDelStatusAndEmailVerifiedAndIsActive(String userName, String password, int i,int j);

	Registration findByMobileNumberAndUserPasswordAndDelStatusAndEmailVerifiedAndIsActive(String userName,String password, int i, int j, int k);

	Registration findByEmailsAndUserPasswordAndDelStatusAndEmailVerifiedAndIsActive(String userName, String password,
			int i, int j, int k);

	Registration findByEmailsAndMobileNumberAndDelStatusAndEmailVerifiedAndIsActive(String email, String mobileNumber,
			int i, int j, int k);

	
	@Transactional
	@Modifying
	@Query("update Registration set user_password=:password  WHERE user_uuid=:userUuid")
	int updatePassword(String password, String userUuid);

	
	@Transactional
	@Modifying
	@Query("update Registration set user_password=:password WHERE reg_id=:regId ") 
	int updatePasswordByRegId(@Param("regId") String regId, @Param("password")String password);

	Registration findByRegIdAndUserPassword(int userId, String pass);

	Registration findByRegIdAndUserPasswordAndExInt1(int userId, String pass, int i);
	
}

	
