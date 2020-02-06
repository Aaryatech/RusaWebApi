package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.UploadDocument;

public interface UploadDocumentRepo extends JpaRepository<UploadDocument, Integer> {

	@Query(value = "select up.doc_id,up.reg_id,up.title,up.file_name,up.type_id,up.del_status,up.extra_int1,up.extra_varchar1,up.upload_date_time,"
			+ " up.doc_size,t.type_name from t_upload_doc up,m_doc_type t where t.type_id=up.type_id and up.reg_id=:regId and up.del_status=1 order by doc_id desc", nativeQuery = true)
	List<UploadDocument> getDocumentByRegId(@Param("regId") int regId);

	@Query(value = "select up.doc_id,up.reg_id,up.title,up.file_name,up.type_id,up.del_status,up.extra_int1,up.extra_varchar1,up.upload_date_time,"
			+ " up.doc_size,t.type_name from t_upload_doc up,m_doc_type t where t.type_id=up.type_id and up.reg_id=:regId and up.del_status=1 and doc_id=:docId order by doc_id desc", nativeQuery = true)
	UploadDocument getDocumentByRegIdAndDocId(@Param("regId")int regId, @Param("docId") int docId);

}
