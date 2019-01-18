package com.ats.rusawebapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.mst.Category;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.mst.CategoryRepo;


@RestController
public class MasterController {
	
	
	@Autowired CategoryRepo catRepo;
	
	
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
	

}
