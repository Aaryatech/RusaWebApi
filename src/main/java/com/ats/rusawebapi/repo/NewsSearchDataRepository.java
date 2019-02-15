package com.ats.rusawebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusawebapi.model.NewsSearchData;

public interface NewsSearchDataRepository extends JpaRepository<NewsSearchData, Integer>{

	@Query(value="SELECT\n" + 
			"        cd.newsblogs_id  ,\n" + 
			"        9 as module_id,\n" + 
			"        cd.heading ,\n" + 
			"        cd.descriptions  ,\n" + 
			"        ch.add_date,\n" + 
			"        ch.edit_date,\n" + 
			"        t.page_name,\n" + 
			"        t.page_slug\n" + 
			"    from\n" + 
			"        t_newsblogs_description cd,\n" + 
			"        t_newsblogs ch,\n" + 
			"        t_pages t\n" + 
			"    WHERE\n" + 
			"        (\n" + 
			"            cd.heading LIKE  %:word% \n" + 
			"            or cd.descriptions LIKE  %:word% \n" + 
			"        ) \n" + 
			"        and cd.language_id=:langId  \n" + 
			"        and cd.newsblogs_id=ch.newsblogs_id \n" + 
			"        and ch.del_status=1 \n" + 
			"        and ch.is_active=1\n" + 
			"        and t.page_id=ch.page_id",nativeQuery=true)
	List<NewsSearchData> newsSerchList(@Param("word") String word,@Param("langId") int langId);

}
