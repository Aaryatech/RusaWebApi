package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.mst.FreqAskQueDescription;

public interface FreqAskQueDescriptionRepo extends JpaRepository<FreqAskQueDescription, Integer>{

	List<FreqAskQueDescription> findByFaqId(int faqId);

}
