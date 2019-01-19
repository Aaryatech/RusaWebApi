package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.mst.FreqAskQue;

public interface FreqAskQueRepo extends JpaRepository<FreqAskQue, Integer> {
	
	
	List<FreqAskQue> findByDelStatus(int delStatus);
	
	List<FreqAskQue>  findByCatIdInAndSubCatIdInAndDelStatus(List<String> catIdList,List<String> subCatIdList,int delStatus);
	

}
