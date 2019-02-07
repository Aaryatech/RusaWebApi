package com.ats.rusawebapi.repo.frontend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.frontend.CmsContent;

public interface CmsContentRepository extends JpaRepository<CmsContent, Integer>{

	@Query(value="select c.*,cd.heading,cd.smallheading,cd.page_desc,cd.language_id from t_cms_pages c,t_cms_pages_description cd where  c.is_active=1 and c.del_status=1 "
			+ "and c.cms_page_id=cd.cms_page_id and cd.language_id=:langId and c.page_id=:pageId order by c.page_order",nativeQuery=true)
	List<CmsContent> getCmsContent(@Param("langId") int langId,@Param("pageId") int pageId);

}
