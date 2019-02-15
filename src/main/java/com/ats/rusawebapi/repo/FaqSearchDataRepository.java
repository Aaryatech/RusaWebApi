package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.FaqSearchData;

public interface FaqSearchDataRepository extends JpaRepository<FaqSearchData, Integer>{

	@Query(value="SELECT\n" + 
			"        cd.faq_id ,\n" + 
			"        2 as module_id,\n" + 
			"        cd.faq_que ,\n" + 
			"        cd.faq_ans ,\n" + 
			"        ch.add_date,\n" + 
			"        ch.edit_date,\n" + 
			"        t.page_name,\n" + 
			"        t.page_slug\n" + 
			"    from\n" + 
			"        t_faq_description cd,\n" + 
			"        t_faq ch,\n" + 
			"        t_pages t\n" + 
			"    WHERE\n" + 
			"        (\n" + 
			"            cd.faq_que LIKE  %:word% \n" + 
			"            or cd.faq_ans LIKE  %:word% \n" + 
			"        ) \n" + 
			"        and cd.language_id=:langId  \n" + 
			"        and cd.faq_id=ch.faq_id \n" + 
			"        and ch.del_status=1 \n" + 
			"        and ch.is_active=1\n" + 
			"        and t.page_id=ch.page_id",nativeQuery=true) 
	List<FaqSearchData> faqSerchList(@Param("word") String word, @Param("langId") int langId);

}
