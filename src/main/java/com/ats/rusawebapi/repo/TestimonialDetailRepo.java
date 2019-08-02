package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.TestimonialDetail;

public interface TestimonialDetailRepo extends JpaRepository<TestimonialDetail, Integer>{

	List<TestimonialDetail> findAllByTestHeadId(int id);

}
