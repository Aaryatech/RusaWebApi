package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.DocumentSearchData;

public interface DocumentSearchDataRepository extends JpaRepository<DocumentSearchData, Integer>{

	@Query(value="SELECT\n" + 
			"        cd.doc_id ,\n" + 
			"        7 as module_id,\n" + 
			"        cd.file_name ,\n" + 
			"        cd.add_date,\n" + 
			"        cd.edit_date,\n" + 
			"        t.page_name,\n" + 
			"        t.page_slug\n" + 
			"    from\n" + 
			"        t_documentupload cd,\n" + 
			"        t_pages t\n" + 
			"    WHERE\n" + 
			"        (\n" + 
			"            cd.file_name LIKE %:word% \n" + 
			"        )  \n" + 
			"        and cd.del_status=1 \n" + 
			"        and cd.is_active=1\n" + 
			"        and t.page_id=cd.page_id",nativeQuery=true)
	List<DocumentSearchData> documentSerchList(@Param("word") String word);

}
