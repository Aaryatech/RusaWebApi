package com.ats.rusawebapi.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.TestImonial;

public interface TestImonialRepository extends JpaRepository<TestImonial, Integer>{
	
	
	@Transactional
	@Modifying
	@Query("update TestImonial set del_status=0  WHERE id=:id")
	int delete(@Param("id") int id);

	
	@Query(value="select * from t_testimonials where id=:id",nativeQuery=true) 
	TestImonial getTestListById(@Param("id") int id);
}
