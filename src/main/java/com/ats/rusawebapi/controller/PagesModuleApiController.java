package com.ats.rusawebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.CMSPageDescription;
import com.ats.rusawebapi.model.CMSPages;
import com.ats.rusawebapi.model.GetPagesModule; 
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.CMSPageDescRepository;
import com.ats.rusawebapi.repo.CMSPagesRepository;
import com.ats.rusawebapi.repo.GetPagesModuleRepository; 

@RestController
public class PagesModuleApiController {
	
	 
	@Autowired
	GetPagesModuleRepository getPagesModuleRepository;
	
	@Autowired
	CMSPagesRepository cmsPagesRepo;
	 
	@Autowired
	CMSPageDescRepository cmsPagesDescRepo;
	
	@RequestMapping(value = { "/getCmsPagesModuleList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPagesModule> getCmsPagesModuleList() {

		List<GetPagesModule> list = new ArrayList<>();

		try {
 
				list = getPagesModuleRepository.getPagesModuleListByModuleIdCms();
			  
			 
		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getCmsPagesModuleListByPageId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPagesModule> getCmsPagesModuleListByPageId(@RequestParam("pageId") int pageId) {

		List<GetPagesModule> list = new ArrayList<>();

		try {
 
				list = getPagesModuleRepository.getCmsPagesModuleListByPageId(pageId);
			  
			 
		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getFaqPagesModuleList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPagesModule> getFaqPagesModuleList() {

		List<GetPagesModule> list = new ArrayList<>();

		try {
 
				list = getPagesModuleRepository.getFaqPagesModuleList();
			  
			 
		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getFaqPagesModuleListByPageId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPagesModule> getFaqPagesModuleListByPageId(@RequestParam("pageId") int pageId) {

		List<GetPagesModule> list = new ArrayList<>();

		try {
 
				list = getPagesModuleRepository.getFaqPagesModuleListByPageId(pageId);
			  
			 
		} catch (Exception e) {
		 
			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/deleteCmsContent" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCmsContent(@RequestParam("cmsPageId") int cmsPageId) {

		Info errorMessage = new Info();
		 
		try {

			int delete = cmsPagesRepo.delete(cmsPageId);
			
			if(delete==0) {
				errorMessage.setError(true);
				errorMessage.setMsg("failed to delete ");
			}else {
				errorMessage.setError(false);
				errorMessage.setMsg(" deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to delete ");

		}
		return errorMessage;

	}
	 
	 
	@RequestMapping(value = { "/getCmsPagebyId" }, method = RequestMethod.POST)
	public @ResponseBody CMSPages getCmsPagebyId(@RequestParam("cmsPageId") int cmsPageId) {

		CMSPages cMSPages = new CMSPages();
		 
		try {

			cMSPages = cmsPagesRepo.findByCmsPageId(cmsPageId);
			List<CMSPageDescription> gDetailsList = cmsPagesDescRepo.findAllByCmsPageId(cmsPageId);
			cMSPages.setDetailList(gDetailsList);
			
		} catch (Exception e) {

			e.printStackTrace();
			 

		}
		return cMSPages;

	}
	
	
	
	
}
