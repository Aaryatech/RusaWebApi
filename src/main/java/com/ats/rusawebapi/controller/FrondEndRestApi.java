package com.ats.rusawebapi.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.CategoryList;
import com.ats.rusawebapi.model.DocumentUpload;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.SectionTree;
import com.ats.rusawebapi.model.SubCategoryList;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.TopMenuList;
import com.ats.rusawebapi.model.frontend.CmsContent;
import com.ats.rusawebapi.model.frontend.FaqContent;
import com.ats.rusawebapi.model.frontend.PageContent;
import com.ats.rusawebapi.repo.CategoryListRepository;
import com.ats.rusawebapi.repo.DocumentUploadRepository;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.PageRepo;
import com.ats.rusawebapi.repo.PagesModuleRepository;
import com.ats.rusawebapi.repo.SectionTreeRepository;
import com.ats.rusawebapi.repo.SubCategoryListRepository;
import com.ats.rusawebapi.repo.TestImonialRepository;
import com.ats.rusawebapi.repo.frontend.CmsContentRepository;
import com.ats.rusawebapi.repo.frontend.FaqContentRepository; 

@RestController
public class FrondEndRestApi {
	
	@Autowired
	PageRepo pageRepo;
	
	@Autowired
	PagesModuleRepository pagesModuleRepo;
	
	@Autowired
	CmsContentRepository cmsContentRepository;
	
	@Autowired
	FaqContentRepository faqContentRepository;
	
	@Autowired
	DocumentUploadRepository documentUploadRepository;
	
	@Autowired
	TestImonialRepository testImonialListRepo;
	
	@Autowired
	GallaryDetailRepository gallaryDetailRepository;
	
	@Autowired
	NewsDetailsRepository newsBolgRepo;
	
	@Autowired
	SectionTreeRepository sectionTreeRepository;
	
	@Autowired
	CategoryListRepository categoryListRepository;
	
	@Autowired
	SubCategoryListRepository subCategoryListRepository;
	
	@RequestMapping(value = { "/getDataBySlugName" }, method = RequestMethod.POST)
	public @ResponseBody PageContent getDataBySlugName(@RequestParam("slugName") String slugName,
			@RequestParam("langId") int langId) {

		 
		PageContent pageContent = new PageContent();
		try {

			Page page = pageRepo.findByPageSlug(slugName);
			 List<Integer> moduleList = pagesModuleRepo.getmoduleList(page.getPageId());
			  int sectionId = pageRepo.getSectioinId(page.getPageId());
			pageContent.setPageId(page.getPageId());
			pageContent.setPageName(page.getPageName());
			pageContent.setSectioinId(sectionId);
			for(int i = 0 ;i<moduleList.size() ; i++) {
				
				
				if(moduleList.get(i)==1) {
					
					List<CmsContent> cmsContentList = cmsContentRepository.getCmsContent(langId,page.getPageId());
					pageContent.setCmsContentList(cmsContentList);
					
				}else if(moduleList.get(i)==2) {
					
					List<FaqContent> faqContentList = faqContentRepository.getFaqContent(langId,page.getPageId());
					pageContent.setFaqContentList(faqContentList);
					
				}else if(moduleList.get(i)==7){
					
					List<DocumentUpload> documentUploadList= documentUploadRepository.findByPageIdAndDelStatusAndIsActive(page.getPageId(),1,1);
					pageContent.setDocumentUploadList(documentUploadList);
				} else if(moduleList.get(i)==6){
					
					List<TestImonial> testImonialList = testImonialListRepo.findByPageIdAndDelStatusAndIsActive(page.getPageId(),1,1);
					pageContent.setTestImonialList(testImonialList);
				}else if(moduleList.get(i)==3){
					
					 List<GallaryDetail> gallaryDetailList = gallaryDetailRepository.findByIsActiveAndDelStatusAndPageId(1,1,page.getPageId());
					pageContent.setGallaryDetailList(gallaryDetailList);
				}else if(moduleList.get(i)==9){
					
					List<NewsDetails> newsBlogList = newsBolgRepo.getNewsContent(langId,page.getPageId());
					pageContent.setDetailNewsList(newsBlogList);
				}

				
				
				
				
			}

		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return pageContent;

	}
	
	@RequestMapping(value = { "/getTopMenuList" }, method = RequestMethod.POST)
	public @ResponseBody TopMenuList getTopMenuList(@RequestParam("langId") int langId) {

		TopMenuList topMenuList = new TopMenuList();
		
		  

		try {

			List<SectionTree> list = sectionTreeRepository.getSectionListByLangId(langId);
			topMenuList.setSectionlist(list);
			
			List<CategoryList> categoryList = categoryListRepository.getCategoryListByLangId(langId);
			topMenuList.setCategoryList(categoryList);
			
			List<SubCategoryList> subCategoryList = subCategoryListRepository.getSubCategoryListByLangId(langId);
			topMenuList.setSubCatList(subCategoryList);
			
			 

		} catch (Exception e) {
			 
			e.printStackTrace();

		}

		return topMenuList;

	}

}