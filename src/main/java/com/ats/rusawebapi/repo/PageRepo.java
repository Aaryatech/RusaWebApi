package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.Page;

public interface PageRepo extends JpaRepository<Page, Integer>{

	Page findByPageId(int exInt2);

}
