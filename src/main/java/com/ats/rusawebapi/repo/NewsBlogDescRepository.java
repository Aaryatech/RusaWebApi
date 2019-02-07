package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.NewsBlogDescription;

public interface NewsBlogDescRepository extends JpaRepository<NewsBlogDescription, Integer> {

}
