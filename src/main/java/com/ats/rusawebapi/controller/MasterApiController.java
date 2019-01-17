package com.ats.rusawebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.repo.mst.SectionRepo;





@RestController
public class MasterApiController {
	
	@Autowired
	SectionRepo secRepo;
	
	// --------------------------------------Section-------------------------

		@RequestMapping(value = { "/saveSection" }, method = RequestMethod.POST)
		public @ResponseBody Info saveSection(@RequestBody Section section) {

			Section secSaveResponse = null;
			Info info=new Info();
			try {
			
				secSaveResponse=secRepo.saveAndFlush(section);
			
			if(secSaveResponse!=null) {
				
				info.setError(false);
				info.setMsg("success");
				
			}else {
				
				info.setError(true);
				info.setMsg("failed");
			}
			secSaveResponse.setInfo(info);

			}catch (Exception e) {
				
				info.setError(true);
				info.setMsg("exception");
				secSaveResponse=new Section();
				secSaveResponse.setInfo(info);

				System.err.println("Exce in saveUpdateSection @MasterController " +e.getMessage() );
				e.printStackTrace();
			}
			
			return info;
			
		}
		
		
		@RequestMapping(value = { "/getSectionBySectionId" }, method = RequestMethod.POST)
		public @ResponseBody Info getContractorById(@RequestParam("sectionId") int sectionId) {

			Section secSaveResponse=null;
			Info info=new Info();
         try {
			secSaveResponse=secRepo.findBySectionIdAndDelStatus(sectionId,1);
			
			
	            if(secSaveResponse!=null) {
				
				info.setError(false);
				info.setMsg("success");
				
			    }else {
				
				info.setError(true);
				info.setMsg("failed");
			        }
			secSaveResponse.setInfo(info);


			} catch (Exception e) {
				info.setError(true);
				info.setMsg("exception");
				secSaveResponse=new Section();
				secSaveResponse.setInfo(info);

				System.err.println("Exce in getSection @MasterController " +e.getMessage() );
				e.printStackTrace();
			}
			return info;

		}
			
		
		@RequestMapping(value = { "/getAllSectionList" }, method = RequestMethod.GET)
		public @ResponseBody List<Section> getAllSectionList() {

			List<Section> conList = new ArrayList<Section>();

			try {

				conList = secRepo.findByDelStatusOrderBySectionIdDesc(1);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return conList;

		}

		@RequestMapping(value = { "/deleteSection" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteSection(@RequestParam("sectionId") int sectionId) {

			int isDeleted = secRepo.deleteSection(sectionId);
			Info infoRes=new Info();
			if(isDeleted>=1)
			{
				infoRes.setError(false);
				infoRes.setMsg("Section Deleted Successfully");
			}
			else
			{
				infoRes.setError(true);
				infoRes.setMsg("Section Deletion Failed");
			}
			return infoRes;
		}
	

	
	//*********************galleryHeader******************//
	
	
	
	
	
	
}
