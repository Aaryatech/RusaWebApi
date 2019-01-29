package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.Languages;

public interface LanguagesRepository extends JpaRepository<Languages, Integer>{

	List<Languages> findByIsActiveOrderBySortOrder(int i);

}
