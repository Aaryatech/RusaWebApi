package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.InstituteInfo;

public interface InstituteInfoRepo extends JpaRepository<InstituteInfo, Integer>{

	@Query(value="select i.*,u.uni_name from mh_institute_master i,m_university u where i.aishe_code=:asheCode and u.uni_id=i.aff_university",nativeQuery=true)
	InstituteInfo getInstituteInfoByAsheCode(@Param("asheCode") String asheCode);

	@Query(value="select i.*,u.uni_name from mh_institute_master i,m_university u where  u.uni_id=i.aff_university and i.aff_university=:uniId",nativeQuery=true)
	List<InstituteInfo> getInstituteListByUniversityId(@Param("uniId") int uniId);

	@Query(value="select i.*,u.uni_name from mh_institute_master i,m_university u where i.mh_inst_id=:instiId and u.uni_id=i.aff_university",nativeQuery=true)
	InstituteInfo getInstituteInfoById(@Param("instiId") int instiId);

	@Query(value="select  coalesce((select reg_id from t_registration where aishe_code=:asheCode and user_type in (2,3) and sms_verified=1 and del_status=1),0) as yes_no ",nativeQuery=true)
	int registerOrnot(@Param("asheCode")  String asheCode);

}
