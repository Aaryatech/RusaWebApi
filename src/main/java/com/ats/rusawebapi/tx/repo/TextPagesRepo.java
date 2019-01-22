package com.ats.rusawebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.tx.model.TextPages;

public interface TextPagesRepo  extends JpaRepository<TextPages, Integer>{

	TextPages save(TextPages textPages);
	
	List<TextPages> findByDelStatus(int delStatus);
	
	List<TextPages> findByCatIdAndDelStatus(int catId,int delStatus);
	 
	List<TextPages> findBySectionIdAndCatIdAndDelStatus(int sectionId,int catId,int delStatus);

	@Transactional
	@Modifying
	@Query("UPDATE TextPages SET delStatus=:delStatus WHERE textPageId IN (:textPageIdList) ")
	int deleteTextPages(List<String> textPageIdList, int delStatus);
	

}
