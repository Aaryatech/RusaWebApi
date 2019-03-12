package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{

	Registration findByUserUuidAndUserTypeAndDelStatus(int suuid, int type, int i);

}
