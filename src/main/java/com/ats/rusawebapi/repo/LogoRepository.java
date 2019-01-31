package com.ats.rusawebapi.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.Logo;

public interface LogoRepository extends JpaRepository<Logo, Integer> {

	Logo findById(int id);

	//Logo findByOrderById(int i);
  

}
