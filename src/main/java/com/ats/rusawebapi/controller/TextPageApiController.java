package com.ats.rusawebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.common.LastUpdatedSiteDate;
import com.ats.rusawebapi.model.mst.Category;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.SettingRepo;
import com.ats.rusawebapi.tx.model.TextPages;
import com.ats.rusawebapi.tx.repo.TextPagesRepo;

@RestController
public class TextPageApiController {

	
	@Autowired TextPagesRepo textPagesRepo;
	
	@Autowired
	SettingRepo settingRepository; 
	
	@RequestMapping(value = { "/saveUpdateTextPage" }, method = RequestMethod.POST)
	public @ResponseBody TextPages saveUpdateTextPage(@RequestBody TextPages textPage) {

		TextPages textPageRes = null;
		
		Info info = new Info();
		
		try {
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			textPageRes = textPagesRepo.saveAndFlush(textPage);

			if (textPageRes != null) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}

			textPageRes.setInfo(info);

		} catch (Exception e) {

			info.setError(true);
			info.setMsg("exception");

			textPageRes = new TextPages();

			textPageRes.setInfo(info);

			System.err.println("Exce in saveUpdateTextPage @TextPageApiController " + e.getMessage());
			e.printStackTrace();
		}

		return textPageRes;

	}
	
	
	
	@RequestMapping(value = { "/getAllTextPages" }, method = RequestMethod.POST)
	public @ResponseBody List<TextPages> getAllTextPages(@RequestParam("delStatus") int delStatus) {

		List<TextPages> textPageList = null;

		try {

			textPageList = textPagesRepo.findByDelStatus(delStatus);

		} catch (Exception e) {
			System.err.println("Exce in getAllTextPages @TextPageApiController " + e.getMessage());
			e.printStackTrace();
		}

		return textPageList;

	}
	//Category -3
	@RequestMapping(value = { "/deleteMultiTextPages" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiTextPages(@RequestParam("delStatus") int delStatus,
			@RequestParam("textPageIdList") List<String> textPageIdList) {

		Info info = new Info();

		try {
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int deleteRes = textPagesRepo.deleteTextPages(textPageIdList,delStatus);

			if (deleteRes > 0) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}

		} catch (Exception e) {
			
			System.err.println("Exce in deleteMultiCategory @Mastercontr " + e.getMessage());
			e.printStackTrace();
			
		}

		return info;

	}
	
	//Category -4
		@RequestMapping(value = { "/activeInactiveTextPages" }, method = RequestMethod.POST)
		public @ResponseBody Info activeInactiveTextPages(@RequestParam("isActive") int isActive,
				@RequestParam("textPageIdList") List<String> textPageIdList) {

			Info info = new Info();

			try {

				int deleteRes = 0;//textPagesRepo.activeInactiveTextPages(textPageIdList, isActive);

				if (deleteRes > 0) {

					info.setError(false);
					info.setMsg("success");

				} else {

					info.setError(true);
					info.setMsg("failed");
				}

			} catch (Exception e) {
				info.setError(true);
				info.setMsg("exception");
				System.err.println("Exce in activeInactiveTextPages @TextPageApiController " + e.getMessage());
				e.printStackTrace();
				
			}

			return info;

		}


}
