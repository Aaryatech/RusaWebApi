package com.ats.rusawebapi.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.SectionDescription;

public interface SecDescRepo extends JpaRepository<SectionDescription, Integer>{

	List<SectionDescription> findAllBySectionId(int sectionId);

}
