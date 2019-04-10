package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.PreviousRegRecord; 
public interface PreviousRegRecordRepo extends JpaRepository<PreviousRegRecord, Integer>{

	PreviousRegRecord findByRegId(int regId);

}
