package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.TestImonial;

public interface TestImonialRepository extends JpaRepository<TestImonial, Integer>{
	
	
	@Transactional
	@Modifying
	@Query("update TestImonial set del_status=0  WHERE id=:id")
	int delete(@Param("id") int id);

	
	@Query(value="select * from t_testimonials where id=:id and is_active=1 and del_status=1",nativeQuery=true) 
	TestImonial getTestListById(@Param("id") int id);


	List<TestImonial> findByPageIdAndDelStatusAndIsActive(int pageId, int i, int j);
	
	@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=6 ORDER BY t.id DESC LIMIT 5",nativeQuery=true)
	List<TestImonial> getLastFiveTestImonials();
	
	@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=13 ",nativeQuery=true)
	List<TestImonial> getTeamDetail();
	
	@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=8 ",nativeQuery=true)
	List<TestImonial> getSuccessStory();

	@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=6 ORDER BY t.id DESC LIMIT 5",nativeQuery=true)
	List<TestImonial> getLastFiveTestImonialsVideo();
	
}
