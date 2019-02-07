package com.ats.rusawebapi.repo.frontend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.frontend.FaqContent;

public interface FaqContentRepository extends JpaRepository<FaqContent, Integer>{

	@Query(value="select c.*,cd.faq_que,cd.faq_ans,cd.language_id from t_faq c,t_faq_description cd where  "
			+ "c.is_active=1 and c.del_status=1 and c.faq_id=cd.faq_id and cd.language_id=:langId and c.page_id=:pageId order by c.faq_sort_no",nativeQuery=true)
	List<FaqContent> getFaqContent(@Param("langId") int langId,@Param("pageId") int pageId);

}
