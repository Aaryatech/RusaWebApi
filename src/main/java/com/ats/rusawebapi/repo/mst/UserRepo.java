package com.ats.rusawebapi.repo.mst;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.model.mst.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUserIdAndDelStatus(int userId, int i);

	
	List<User> findByDelStatusOrderByUserIdAsc(int i);

	@Transactional
	@Modifying
	@Query("update User set del_status=0  WHERE user_id=:userId and user_id!=1")
	int deleteUser(@Param("userId") int sectionId);
	
	@Transactional
	@Modifying
	@Query("UPDATE User SET delStatus=0  WHERE user_id IN(:userIds)")
	int deleteMultiUser(@Param("userIds") List<Integer> userIds);
	
	@Transactional
	@Modifying
	@Query("UPDATE User SET isActive=:isActive WHERE user_id IN (:userIdList)") 
	int activeInactiveUser(@Param("userIdList") List<String> userIdList, @Param("isActive") int isActive);


	@Query(value="SELECT * From m_user where BINARY m_user.user_name=:userName AND BINARY m_user.user_pass=:password AND m_user.del_status=1",nativeQuery=true) 
	User searchUser(@Param("userName") String userName,@Param("password") String password);

	@Transactional
	@Modifying
	@Query("UPDATE User SET lastlogin_date=:date WHERE user_id=:userId ") 
	int updateLastLoginDate(@Param("date")String date,@Param("userId") int userId);

	@Query(value="SELECT * From m_user where BINARY m_user.user_name=:userName AND m_user.is_active=1 AND m_user.del_status=1",nativeQuery=true) 
	User searchUser1(@Param("userName") String userName);

 
	@Transactional
	@Modifying
	@Query("UPDATE User SET loginFailureCount=:count WHERE user_id=:userId ") 
	int updateCount(@Param("count")int count,@Param("userId") int userId);


	List<User> findByDelStatusAndRolesIsNotOrderByUserIdAsc(int i, String string);


	//User findByTypeIdAndDelStatus(int typeId, int i);
	
	
	
}
