package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.University;

public interface UniversityRepo extends JpaRepository<University, Integer>{

	List<University> findByDelStatus(int i);

}
