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
	@Query("update Registration set del_status=0 WHERE reg_id IN (:id)")
	int deleteMultipleUserReg(@Param("id") List<Integer> id);
 

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
	@Query("update Registration set user_password=:password, ex_int1=1 WHERE reg_id=:regId ") 
	int updatePasswordByRegId(@Param("regId") String regId, @Param("password")String password);

	Registration findByRegIdAndUserPassword(int userId, String pass);

	Registration findByRegIdAndUserPasswordAndExInt1(int userId, String pass, int i);

	//List<Registration> findByMobileNumberAndDelStatusAndIsActive(String trim, int i, int j);

	//List<Registration> findByEmailsAndDelStatusAndIsActive(String trim, int i, int j);

	List<Registration> findByMobileNumberAndDelStatus(String trim, int i);

	List<Registration> findByEmailsAndDelStatus(String trim, int i);

	List<Registration> findByDelStatusAndSmsVerifiedOrderByRegIdDesc(int i, int j);

	List<Registration> findByMobileNumberAndDelStatusAndSmsVerified(String trim, int i, int j);

	List<Registration> findByEmailsAndDelStatusAndSmsVerified(String trim, int i, int j);

	@Query( value="select\r\n" + 
			"        *\r\n" + 
			"    from\r\n" + 
			"        t_registration registrati0_ \r\n" + 
			"    where\r\n" + 
			"        emails=:userName\r\n" + 
			"        and binary user_password=:password \r\n" + 
			"        and del_status=1 \r\n" + 
			"        and email_verified=1 \r\n" + 
			"        and is_active=1",nativeQuery=true)
	Registration loginProcess(@Param("userName")String userName,@Param("password") String password);

	
	@Query( value="select\r\n" + 
			"        *\r\n" + 
			"    from\r\n" + 
			"        t_registration registrati0_ \r\n" + 
			"    where\r\n" + 
			"        (emails=:userName or mobile_number=:password) and del_status=1 \r\n" + 
			"        and email_verified=1 \r\n" + 
			"        and is_active=1",nativeQuery=true)
	Registration forgetPassword(@Param("userName")String userName,@Param("password") String password);

	@Query( value="select * from t_registration where reg_id=:regId and BINARY user_password=:password",nativeQuery=true)
	Registration checkPasswordByUserId(@Param("regId" )int regId,@Param("password") String password);

	@Transactional
	@Modifying
	@Query("update Registration set ex_var2=:token  WHERE reg_id=:regId")
	int updateToken(@Param("token") String token, @Param("regId")int regId);

	Registration findByExVar2AndRegIdAndDelStatus(String token, int regId, int i);

	@Transactional
	@Modifying
	@Query("update Registration set ex_int2=:getCountOtpFailed  WHERE reg_id=:regId")
	int updateOtpFailed(@Param("regId")int regId, @Param("getCountOtpFailed") int getCountOtpFailed);

	@Query( value="select ex_int2 from t_registration where reg_id=:regId",nativeQuery=true)
	String getCountOtpFailed(@Param("regId") int regId);
	
}

	
