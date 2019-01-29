package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusawebapi.model.LoginLogs;

public interface LoginLogsRepo extends JpaRepository<LoginLogs, Integer>{

}
