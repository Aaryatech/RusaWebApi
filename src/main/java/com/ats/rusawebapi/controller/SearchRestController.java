package com.ats.rusawebapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = { "/serchWordFromTable" }, method = RequestMethod.POST)
	public @ResponseBody SearchData serchWordFromTable(@RequestParam("word") String word,
			@RequestParam("langId") int langId) {

		SearchData searchData = new SearchData();

		try {
			String[] wordArray = word.split(" ");
			List<String> wordList = new ArrayList<String>(Arrays.asList(wordArray));

			 for (int i = 0; i < wordList.size(); i++) {

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
					searchData.setGallerySerchList(gallerySerchList);
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
			} 
			/*String qry1 = "SELECT cd.cms_page_id , 1 as module_id, cd.heading  , cd.page_desc , ch.add_date, ch.edit_date, t.page_name, t.page_slug from "
					+ "t_cms_pages_description cd, t_cms_pages ch, t_pages t WHERE ";
			String qry = new String();
			String qry2 = " and cd.language_id="+1+" and cd.cms_page_id=ch.cms_page_id and ch.del_status=1 and ch.is_active=1 and t.page_id=ch.page_id";
			for (int i = 0; i < wordList.size(); i++) {

				qry=qry+" cd.page_desc LIKE \"%"+wordList.get(i)+"%\" or  cd.heading LIKE \"%"+wordList.get(i)+"%\"  or ";
			}
			qry="("+qry+"  1=2)";
			qry=qry1+qry+qry2;
			
			List<CmsSearchData> cmsSerchList = cmsSearchDataRepository.cmsSerchList(qry);*/

		} catch (Exception e) {

			e.printStackTrace();
		}

		return searchData;

	}

}
