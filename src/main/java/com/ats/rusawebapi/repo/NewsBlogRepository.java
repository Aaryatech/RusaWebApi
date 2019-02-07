package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.NewsBlog;

public interface NewsBlogRepository extends JpaRepository<NewsBlog, Integer>{

}
