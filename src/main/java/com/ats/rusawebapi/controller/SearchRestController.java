package com.ats.rusawebapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.CmsSearchData;
import com.ats.rusawebapi.model.DocumentSearchData;
import com.ats.rusawebapi.model.FaqSearchData;
import com.ats.rusawebapi.model.GallerySearchData;
import com.ats.rusawebapi.model.NewsSearchData;
import com.ats.rusawebapi.model.SearchData;
import com.ats.rusawebapi.repo.CmsSearchDataRepository;
import com.ats.rusawebapi.repo.DocumentSearchDataRepository;
import com.ats.rusawebapi.repo.FaqSearchDataRepository;
import com.ats.rusawebapi.repo.GallerySearchDataRepository;
import com.ats.rusawebapi.repo.NewsSearchDataRepository;

@RestController
public class SearchRestController {

	@Autowired
	CmsSearchDataRepository cmsSearchDataRepository;

	@Autowired
	FaqSearchDataRepository faqSearchDataRepository;

	@Autowired
	NewsSearchDataRepository newsSearchDataRepository;

	@Autowired
	GallerySearchDataRepository gallerySearchDataRepository;

	@Autowired
	DocumentSearchDataRepository documentSearchDataRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = { "/serchWordFromTable" }, method = RequestMethod.POST)
	public @ResponseBody SearchData serchWordFromTable(@RequestParam("word") String word,
			@RequestParam("langId") int langId) {

		SearchData searchData = new SearchData();

		try {
			String[] wordArray = word.split(" ");
			List<String> wordList = new ArrayList<String>(Arrays.asList(wordArray));

			   /*for (int i = 0; i < wordList.size(); i++) {

				List<CmsSearchData> cmsSerchList = cmsSearchDataRepository.cmsSerchList(wordList.get(i), langId);
				List<FaqSearchData> faqSerchList = faqSearchDataRepository.faqSerchList(wordList.get(i), langId);
				List<NewsSearchData> newsSerchList = newsSearchDataRepository.newsSerchList(wordList.get(i), langId);
				List<GallerySearchData> gallerySerchList = gallerySearchDataRepository
						.gallerySerchList(wordList.get(i));
				List<DocumentSearchData> documentSerchList = documentSearchDataRepository
						.documentSerchList(wordList.get(i));

				if (i == 0) {
					searchData.setCmsSerchList(cmsSerchList);
					searchData.setFaqSerchList(faqSerchList);
					searchData.setNewsSerchList(newsSerchList);
					//searchData.setGallerySerchList(gallerySerchList);
					searchData.setDocumentSerchList(documentSerchList);
				}else {
					
					if(cmsSerchList.size()>0) {
						for(int j = 0 ; j< cmsSerchList.size() ; j++) {
							
							searchData.getCmsSerchList().add(cmsSerchList.get(j));
						}
					}
					if(faqSerchList.size()>0) {
						for(int j = 0 ; j< faqSerchList.size() ; j++) {
							
							searchData.getFaqSerchList().add(faqSerchList.get(j));
						}
					}
					if(newsSerchList.size()>0) {
						for(int j = 0 ; j< newsSerchList.size() ; j++) {
							
							searchData.getNewsSerchList().add(newsSerchList.get(j));
						}
					}
					if(gallerySerchList.size()>0) {
						for(int j = 0 ; j< gallerySerchList.size() ; j++) {
							
							searchData.getGallerySerchList().add(gallerySerchList.get(j));
						}
					}
					if(documentSerchList.size()>0) {
						for(int j = 0 ; j< documentSerchList.size() ; j++) {
							
							searchData.getDocumentSerchList().add(documentSerchList.get(j));
						}
					}
					
				}
			} */
			
			   String cmsUpperQuery = "SELECT cd.cms_page_id , 1 as module_id, cd.heading  , cd.page_desc , ch.add_date, ch.edit_date, t.page_name, t.page_slug from "
						+ "t_cms_pages_description cd, t_cms_pages ch, t_pages t WHERE ";
			   String cmsBaseQuery = " and cd.language_id="+langId+" and cd.cms_page_id=ch.cms_page_id and ch.del_status=1 and ch.is_active=1 and t.page_id=ch.page_id";
			   
			   String faqUpperQuery = "SELECT cd.faq_id , 2 as module_id, cd.faq_que , cd.faq_ans , ch.add_date, ch.edit_date, t.page_name, t.page_slug from "
			   		+ "t_faq_description cd, t_faq ch, t_pages t WHERE ";
			   String faqBaseQuery = " and cd.language_id="+langId+" and cd.faq_id=ch.faq_id and ch.del_status=1 and ch.is_active=1 and t.page_id=ch.page_id";
			   
			   String newsUpperQuery = "SELECT cd.newsblogs_id  , 9 as module_id, cd.heading , cd.descriptions  , ch.add_date, ch.edit_date, t.page_name, "
			   		+ "t.page_slug from t_newsblogs_description cd, t_newsblogs ch, t_pages t WHERE ";
			   String newsBaseQuery = " and cd.language_id="+langId+" and cd.newsblogs_id=ch.newsblogs_id and ch.del_status=1 and ch.is_active=1 and t.page_id=ch.page_id";
			   
			   String documentUpperQuery = "SELECT cd.doc_id , 7 as module_id, cd.file_name , cd.add_date, cd.edit_date, t.page_name, t.page_slug from"
			   		+ " t_documentupload cd, t_pages t WHERE ";
			   String documentBaseQuery = " and cd.del_status=1 and cd.is_active=1 and t.page_id=cd.page_id";
			   
			String cmsMiddleQuery = new String();
			String faqMiddleQuery = new String();
			String newsMiddleQuery = new String();
			String documentMiddleQuery = new String();
			 
			for (int i = 0; i < wordList.size(); i++) {

				cmsMiddleQuery=cmsMiddleQuery+" cd.page_desc LIKE \"%"+wordList.get(i)+"%\" or  cd.heading LIKE \"%"+wordList.get(i)+"%\"  or ";
				faqMiddleQuery=faqMiddleQuery+" cd.faq_que LIKE  \"%"+wordList.get(i)+"%\"or cd.faq_ans LIKE \"%"+wordList.get(i)+"%\" or";
				newsMiddleQuery=newsMiddleQuery+" cd.heading LIKE  \"%"+wordList.get(i)+"%\" or cd.descriptions LIKE \"%"+wordList.get(i)+"%\" or";
				documentMiddleQuery=documentMiddleQuery+" cd.file_name LIKE \"%"+wordList.get(i)+"%\" or";
			}
			
			cmsMiddleQuery="("+cmsMiddleQuery+"  1=2)";
			faqMiddleQuery="("+faqMiddleQuery+"  1=2)";
			newsMiddleQuery="("+newsMiddleQuery+"  1=2)";
			documentMiddleQuery="("+documentMiddleQuery+"  1=2)";
			  
			String cmsQry=cmsUpperQuery+cmsMiddleQuery+cmsBaseQuery; 
			List<CmsSearchData> cmsSerchList = jdbcTemplate.query(cmsQry, new BeanPropertyRowMapper(CmsSearchData.class));
			
			String faqQry=faqUpperQuery+faqMiddleQuery+faqBaseQuery; 
			List<FaqSearchData> faqSerchList = jdbcTemplate.query(faqQry, new BeanPropertyRowMapper(FaqSearchData.class));
			
			String newsQry=newsUpperQuery+newsMiddleQuery+newsBaseQuery; 
			List<NewsSearchData> newsSerchList = jdbcTemplate.query(newsQry, new BeanPropertyRowMapper(NewsSearchData.class));
			
			String docQry=documentUpperQuery+documentMiddleQuery+documentBaseQuery; 
			List<DocumentSearchData> documentSerchList = jdbcTemplate.query(docQry, new BeanPropertyRowMapper(DocumentSearchData.class));
			 
			 for (int i = 0; i < cmsSerchList.size(); i++) {
				
				StringBuilder sb = new StringBuilder(); 
				 String nohtml = sb.append(cmsSerchList.get(i).getPageDesc()).toString().replaceAll("\\<.*?>","");
				 cmsSerchList.get(i).setPageDesc(nohtml);
				 
			} 
			
			for (int i = 0; i < faqSerchList.size(); i++) {
				
				StringBuilder sb = new StringBuilder(); 
				 String nohtml = sb.append(faqSerchList.get(i).getFaqAns()).toString().replaceAll("\\<.*?>","");
				 faqSerchList.get(i).setFaqAns(nohtml);
			}
			
			for (int i = 0; i < newsSerchList.size(); i++) {
				
				StringBuilder sb = new StringBuilder(); 
				 String nohtml = sb.append(newsSerchList.get(i).getDescriptions()).toString().replaceAll("\\<.*?>","");
				 newsSerchList.get(i).setDescriptions(nohtml);;
			}
			 
			searchData.setCmsSerchList(cmsSerchList);
			searchData.setFaqSerchList(faqSerchList);
			searchData.setNewsSerchList(newsSerchList);
			searchData.setDocumentSerchList(documentSerchList);
			
			//System.out.println(searchData);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return searchData;

	}

}
