package com.ats.rusawebapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.mst.Category;
import com.ats.rusawebapi.model.mst.FreqAskQue;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.SubCategory;
import com.ats.rusawebapi.repo.mst.CategoryRepo;
import com.ats.rusawebapi.repo.mst.FreqAskQueRepo;
import com.ats.rusawebapi.repo.mst.SubCategoryRepo;


@RestController
public class MasterController {
	
	
	@Autowired CategoryRepo catRepo;
	@Autowired SubCategoryRepo subCatRepo;
	@Autowired FreqAskQueRepo freqAskQueRepo;
	
	@RequestMapping(value = { "/saveUpdateCategory" }, method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@RequestBody Category category) {

		Category catSaveResponse = null;
		Info info=new Info();
		try {
		
		catSaveResponse=catRepo.saveAndFlush(category);
		
		if(catSaveResponse!=null) {
			
			info.setError(false);
			info.setMsg("success");
			
		}else {
			
			info.setError(true);
			info.setMsg("failed");
		}
		
		catSaveResponse.setInfo(info);

		}catch (Exception e) {
			
			info.setError(true);
			info.setMsg("exception");
			
			catSaveResponse=new Category();
			
			catSaveResponse.setInfo(info);

			System.err.println("Exce in saveUpdateCategory @MasterController " +e.getMessage() );
			e.printStackTrace();
		}
		
		return catSaveResponse;
		
	}
	
	@RequestMapping(value = { "/getAllCategory" }, method = RequestMethod.POST)
	public @ResponseBody List<Category> getAllCategory(@RequestParam("delStatus") int delStatus,
			@RequestParam("isActive")int isActive) {
		
		List<Category> catList=null;
		
		try {
			
			catList=catRepo.findByDelStatusAndIsActive(delStatus, isActive);
			
		}catch (Exception e) {
			System.err.println("Exce in getAllCategory @Mastercontr " +e.getMessage());
			e.printStackTrace();
		}

		return catList;
		
	}


	
	@RequestMapping(value = { "/saveUpdateSubCategory" }, method = RequestMethod.POST)
	public @ResponseBody SubCategory saveUpdateSubCategory(@RequestBody SubCategory subCategory ) {

		SubCategory subCatSaveResponse = null;
		Info info=new Info();
		try {
		
		subCatSaveResponse=subCatRepo.saveAndFlush(subCategory);
		
		if(subCatSaveResponse!=null) {
			
			info.setError(false);
			info.setMsg("success");
			
		}else {
			
			info.setError(true);
			info.setMsg("failed");
		}
		
		subCatSaveResponse.setInfo(info);

		}catch (Exception e) {
			
			info.setError(true);
			info.setMsg("exception");
			
			subCatSaveResponse=new SubCategory();
			
			subCatSaveResponse.setInfo(info);

			System.err.println("Exce in saveUpdateSubCategory @MasterController " +e.getMessage() );
			e.printStackTrace();
		}
		
		return subCatSaveResponse;
		
	}
	
	
	@RequestMapping(value = { "/saveUpdateFreqAskQue" }, method = RequestMethod.POST)
	public @ResponseBody FreqAskQue saveUpdateFreqAskQue(@RequestBody FreqAskQue faq ) {

		FreqAskQue faqSaveResponse = null;
		Info info=new Info();
		try {
		
		faqSaveResponse=freqAskQueRepo.saveAndFlush(faq);
		
		if(faqSaveResponse!=null) {
			
			info.setError(false);
			info.setMsg("success");
			
		}else {
			
			info.setError(true);
			info.setMsg("failed");
		}
		
		faqSaveResponse.setInfo(info);

		}catch (Exception e) {
			
			info.setError(true);
			info.setMsg("exception");
			
			faqSaveResponse=new FreqAskQue();
			
			faqSaveResponse.setInfo(info);

			System.err.println("Exce in saveUpdateFreqAskQue @MasterController " +e.getMessage() );
			e.printStackTrace();
		}
		
		return faqSaveResponse;
		
	}

}
