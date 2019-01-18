package com.ats.rusawebapi.repo.mst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.SubCategory;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {
	
	List<SubCategory> findByDelStatusAndIsActive(int delStatus,int isActive);
	
	List<SubCategory>  findByCatIdAndDelStatusAndIsActive(int catId,int delStatus,int isActive);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE SubCategory SET delStatus=:delStatus WHERE subCatId IN (:subCatIdList) ",nativeQuery=true)

	int deleteSubCategory(@Param("subCatIdList") List<String> subCatIdList,@Param("delStatus") int delStatus);
	
}
