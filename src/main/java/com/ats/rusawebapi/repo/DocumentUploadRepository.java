package com.ats.rusawebapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusawebapi.model.DocumentUpload;

public interface DocumentUploadRepository extends JpaRepository<DocumentUpload, Integer>{

	

	@Transactional
	@Modifying
	@Query("update DocumentUpload set del_status=0  WHERE doc_id=:id")
	int delete(int id);  

	DocumentUpload getDocumentByDocId(int id);

	@Query(value="select * from t_documentupload where del_status=1",nativeQuery=true) 
	List<DocumentUpload> getDocumentList();
 
	List<DocumentUpload> findByPageIdAndDelStatusAndIsActive(int pageId, int i, int j);

	
}
