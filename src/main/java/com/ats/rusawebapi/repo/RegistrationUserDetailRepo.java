package com.ats.rusawebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.RegistrationUserDetail;

public interface RegistrationUserDetailRepo extends JpaRepository<RegistrationUserDetail, Integer>{

	
	@Query(value="select r.*,u.uni_name,i.inst_name from t_registration r,m_university u,mh_institute_master i where u.uni_id=r.unversity_name "
			+ "and r.college_name=i.mh_inst_id and r.reg_id=:regId",nativeQuery=true)
	RegistrationUserDetail getRegUserDetailbyRegId(@Param("regId") int regId);

}
