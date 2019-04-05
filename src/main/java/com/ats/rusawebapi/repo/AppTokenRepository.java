package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.AppToken;

public interface AppTokenRepository extends JpaRepository<AppToken, Integer>{

	List<AppToken> findAllByDeviceName(String string);

}
