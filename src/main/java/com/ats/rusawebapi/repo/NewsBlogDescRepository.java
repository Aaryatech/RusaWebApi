package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.NewsBlogDescription;

public interface NewsBlogDescRepository extends JpaRepository<NewsBlogDescription, Integer> {

	//List<NewsBlogDescription> findAllByNewsblogId(int newsPageId);

	List<NewsBlogDescription> findAllByNewsblogsId(int newsPageId);
     
}
