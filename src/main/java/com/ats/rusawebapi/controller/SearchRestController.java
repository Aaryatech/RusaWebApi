package com.ats.rusawebapi.controller;

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
	public @ResponseBody SearchData serchWordFromTable(@RequestParam("word") String word) {

		SearchData searchData = new SearchData();
		 
		try {

			List<CmsSearchData> cmsSerchList = cmsSearchDataRepository.cmsSerchList(word);
			List<FaqSearchData> faqSerchList = faqSearchDataRepository.faqSerchList(word);
			List<NewsSearchData> newsSerchList = newsSearchDataRepository.newsSerchList(word);
			List<GallerySearchData> gallerySerchList = gallerySearchDataRepository.gallerySerchList(word);
			List<DocumentSearchData> documentSerchList = documentSearchDataRepository.documentSerchList(word);
			
			searchData.setCmsSerchList(cmsSerchList);
			searchData.setFaqSerchList(faqSerchList);
			searchData.setNewsSerchList(newsSerchList);
			searchData.setGallerySerchList(gallerySerchList);
			searchData.setDocumentSerchList(documentSerchList);
			
		} catch (Exception e) {

		 
			e.printStackTrace();
		}

		return searchData;

	}

}
