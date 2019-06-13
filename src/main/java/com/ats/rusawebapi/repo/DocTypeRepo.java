package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.DocType;

public interface DocTypeRepo extends JpaRepository<DocType, Integer>{

	List<DocType> findByDelStatus(int i);

}
