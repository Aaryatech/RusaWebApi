package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.ModulesNames;

public interface ModuleNameRepository extends JpaRepository<ModulesNames, Integer>{

	ModulesNames findByIdAndStatus(int id, int i);

	List<ModulesNames> findByStatusOrderById(int i);

}
