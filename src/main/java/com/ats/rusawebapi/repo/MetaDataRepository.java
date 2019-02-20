package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.MetaData;

public interface MetaDataRepository extends JpaRepository<MetaData, Integer>{

	MetaData findById(int id);

	MetaData findByLanguageId(int langId);

//	MetaData findByLanguageId();

	//MetaData findByLanguageId(int i);

	//MetaData find();

	//List<MetaData> findByOrderById(int i);

}
