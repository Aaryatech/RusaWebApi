package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.SmsCode;

public interface SmsCodeRepository extends JpaRepository<SmsCode, Integer>{

}
