package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.TestimonialDetail;

public interface TestImonialRepository extends JpaRepository<TestImonial, Integer>{
	
	
	@Transactional
	@Modifying
	@Query("update TestImonial set del_status=0  WHERE id=:id")
	int delete(@Param("id") int id);
	
	TestImonial findById(int id);


	@Transactional
	@Modifying
	@Query("update TestImonial set del_status=0  WHERE id IN(:id)")
	int deleteMultipleTestImonial(@Param("id") List<Integer> id);

	
	@Query(value="select * from t_testimonials where id=:id  and del_status=1",nativeQuery=true) 
	TestImonial getTestListById(@Param("id") int id); 
	
	@Query(value="SELECT t.id,t.cate_type,t.page_id,t.section_id,td.from_name,td.designation,td.location,td.message,t.image_name,"
			+ "t.sort_no,t.add_date,t.edit_date,t.added_by_user_id,t.edit_by_user_id,t.is_active,t.del_status,t.ex_int1,t.ex_int2,t.ex_var1,t.ex_var2 FROM t_testimonials t,t_testimonials_detail td where t.is_active=:i and t.del_status=:j and t.section_id=:k and t.id=td.test_head_id "
			+ "and td.lang_id=:langId and t.page_id=:pageId ORDER BY t.sort_no",nativeQuery=true)
	List<TestImonial> findByPageIdAndDelStatusAndIsActiveAndSectionIdOrderBySortNo(@Param("pageId")int pageId,@Param("i") int i,
			@Param("j")int j,@Param("k") int k,@Param("langId") int langId);
	
	/*@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=6 ORDER BY t.id DESC LIMIT 5",nativeQuery=true)*/
	@Query(value="SELECT t.id,t.cate_type,t.page_id,t.section_id,td.from_name,td.designation,td.location,td.message,t.image_name,t.sort_no,t.add_date,t.edit_date,t.added_by_user_id,t.edit_by_user_id,t.is_active,t.del_status,t.ex_int1,t.ex_int2,t.ex_var1,t.ex_var2 FROM t_testimonials t,t_testimonials_detail td where t.is_active=1 and t.del_status=1 and t.section_id=6 and t.id=td.test_head_id "
			+ "and td.lang_id=:langId ORDER BY t.id DESC LIMIT 10",nativeQuery=true)
	List<TestImonial> getLastFiveTestImonials(@Param("langId") int langId);
	
	@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=13 ",nativeQuery=true)
	List<TestImonial> getTeamDetail();
	
	@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=8 ",nativeQuery=true)
	List<TestImonial> getSuccessStory();

	@Query(value="SELECT t.* FROM t_testimonials t where t.is_active=1 and t.del_status=1 and t.section_id=6 ORDER BY t.id DESC LIMIT 5",nativeQuery=true)
	List<TestImonial> getLastFiveTestImonialsVideo();
	
	@Query(value="SELECT t.* FROM t_testimonials t where t.ex_int1=:valueType and t.is_active=1 and t.del_status=1 and t.section_id=6 ORDER BY t.id DESC ",nativeQuery=true)
	List<TestImonial> getAllTestImonials(@Param("valueType") int valueType);
}
