package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.GetPagesModule;

public interface GetPagesModuleRepository extends JpaRepository<GetPagesModule, Integer>{

	@Query(value="select\n" + 
			"        pm.*,\n" + 
			"        p.page_name,\n" + 
			"        m.name,\n" + 
			"        heading  as content,\n" + 
			"        CASE\n" + 
			"            WHEN p.type_sec_cate='sec' THEN (select section_name from m_section where p.sec_cate_id=section_id) \n" + 
			"            ELSE (select s.section_name from m_section s,m_category c where p.sec_cate_id=c.cat_id and c.section_id= s.section_id) \n" + 
			"         END  as secction_name\n" + 
			"    from\n" + 
			"        t_tpages_modules pm,\n" + 
			"        t_pages p,\n" + 
			"        m_modules_name m,\n" + 
			"        t_cms_pages_description cd,\n" + 
			"        t_cms_pages ch     \n" + 
			"    where\n" + 
			"        p.page_id=pm.page_id          \n" + 
			"        and m.id=pm.module_id          \n" + 
			"        and pm.module_id=1         \n" + 
			"        and cd.cms_page_id=pm.primary_key_id          \n" + 
			"        and cd.language_id=1         \n" + 
			"        and ch.cms_page_id=cd.cms_page_id         \n" + 
			"        and ch.del_status=1",nativeQuery=true) 
	List<GetPagesModule> getPagesModuleListByModuleIdCms();

	@Query(value="select\n" + 
			"        pm.*,\n" + 
			"        p.page_name,\n" + 
			"        m.name,\n" + 
			"        faq_que as content,\n" + 
			"        CASE\n" + 
			"            WHEN p.type_sec_cate='sec' THEN (select section_name from m_section where p.sec_cate_id=section_id) \n" + 
			"            ELSE (select s.section_name from m_section s,m_category c where p.sec_cate_id=c.cat_id and c.section_id= s.section_id) \n" + 
			"         END  as secction_name\n" + 
			"    from\n" + 
			"        t_tpages_modules pm,\n" + 
			"        t_pages p,\n" + 
			"        m_modules_name m, \n" + 
			"        t_faq_description fd,\n" + 
			"        t_faq fh\n" + 
			"    where\n" + 
			"        p.page_id=pm.page_id \n" + 
			"        and m.id=pm.module_id \n" + 
			"        and pm.module_id=2\n" + 
			"        and fd.faq_id=pm.primary_key_id \n" + 
			"        and language_id=1\n" + 
			"        and fh.faq_id=fd.faq_id\n" + 
			"        and fh.del_status=1",nativeQuery=true) 
	List<GetPagesModule> getFaqPagesModuleList();
 

}
