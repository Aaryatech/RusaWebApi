package com.ats.rusawebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.GetPagesModule; 
import com.ats.rusawebapi.repo.GetPagesModuleRepository;

@RestController
public class PagesModuleApiController {
	
	 
	@Autowired
	GetPagesModuleRepository getPagesModuleRepository;
	
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

}
