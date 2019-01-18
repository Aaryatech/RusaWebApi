package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.model.mst.FreqAskQue;

public interface FreqAskQueRepo extends JpaRepository<FreqAskQue, Integer> {
	
	
	List<FreqAskQue> findByDelStatus(int delStatus);
	
	List<FreqAskQue>  findByCatIdInAndSubCatIdInAndDelStatus(List<Integer> catIdList,List<Integer> subCatIdList,int delStatus);

	List<FreqAskQue>  findBySubCatIdInAndDelStatus(List<Integer> subCatIdList,int delStatus);
	
	List<FreqAskQue>  findByCatIdInAndDelStatus(List<Integer> catIdList,int delStatus);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_faq SET del_status=:delStatus WHERE faq_id IN (:faqIdIdList) ",nativeQuery=true)

	int deleteFaqs(@Param("faqIdIdList") List<String> faqIdIdList,@Param("delStatus") int delStatus);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_faq SET is_active=:isActive WHERE faq_id IN (:faqIdIdList) ",nativeQuery=true)

	int activeInactiveFaqs(@Param("faqIdIdList") List<String> faqIdIdList,@Param("isActive") int isActive);
	

	
}
