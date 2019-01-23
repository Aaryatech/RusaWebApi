package com.ats.rusawebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.mst.GetFreqAskQue;

public interface GetFreqAskQueRepo extends JpaRepository<GetFreqAskQue, Integer> {

	@Query(value = " SELECT t_faq.*, m_category.cat_name,m_category.cat_code,m_category.cat_desc,"
			+ "m_sub_category.sub_cat_name," + " m_sub_category.sub_cat_code,m_sub_category.sub_cat_desc "
			+ " FROM m_sub_category,m_category,t_faq "
			+ " WHERE t_faq.cat_id=m_category.cat_id AND m_category.cat_id=m_sub_category.cat_id "
			+ " AND t_faq.del_status=:delStatus ", nativeQuery = true)

	List<GetFreqAskQue> getFaqList(@Param("delStatus") int delStatus);

	@Query(value = " SELECT t_faq.*, m_category.cat_name,m_category.cat_code,m_category.cat_desc,"
			+ "m_sub_category.sub_cat_name," + " m_sub_category.sub_cat_code,m_sub_category.sub_cat_desc "
			+ " FROM m_sub_category,m_category,t_faq "
			+ " WHERE t_faq.cat_id=m_category.cat_id AND m_category.cat_id=m_sub_category.cat_id "
			+ "  AND t_faq.faq_id=:faqId  ", nativeQuery = true)

	GetFreqAskQue getFaq(@Param("faqId") int faqId);

}
