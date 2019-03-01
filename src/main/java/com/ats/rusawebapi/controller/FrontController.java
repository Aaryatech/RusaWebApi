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

import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.CMSPageDescription;
import com.ats.rusawebapi.model.CmsSearchData;
import com.ats.rusawebapi.model.ContactUs;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.NewsBlog;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.CMSPageDescRepository;
import com.ats.rusawebapi.repo.CmsSearchDataRepository;
import com.ats.rusawebapi.repo.ContactUsRepo;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.PageRepo;
import com.ats.rusawebapi.repo.TestImonialRepository;

@RestController
public class FrontController {

	@Autowired
	ContactUsRepo contactUsRepo;
	
	
	
	@Autowired
	GallaryDetailRepository gallaryDetailRepository;
	
	@Autowired
	CmsSearchDataRepository cmsPageDescRepository;
	
	@Autowired
	TestImonialRepository testImonialListRepo;
	
	@Autowired
	NewsDetailsRepository newsDetailRepo;
	
	@Autowired
	BannerImagesRepository bannerImagesRepo;
	
	@RequestMapping(value = { "/saveContactUs" }, method = RequestMethod.POST)
	public @ResponseBody ContactUs saveContactUs(@RequestBody ContactUs getContactList) {

		Info errorMessage = new Info();
		ContactUs ContactUsList=null;
		try {

			ContactUsList = contactUsRepo.save(getContactList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return ContactUsList;

	}
	@RequestMapping(value = { "/getContactById" }, method = RequestMethod.POST)
	public @ResponseBody ContactUs getContactById(@RequestParam("id") int id) {
		ContactUs secSaveResponse = new ContactUs();
		 
		try {
			secSaveResponse = contactUsRepo.findByIdAndDelStatus(id, 1); 
		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	
	@RequestMapping(value = { "/getAllContactList" }, method = RequestMethod.GET)
	public @ResponseBody List<ContactUs> getAllContactList() {

		List<ContactUs> conList = new ArrayList<ContactUs>();

		try {

			conList = contactUsRepo.findByDelStatusOrderById(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}
	@RequestMapping(value = { "/deleteContact" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteContact(@RequestParam("id") int id) {

		int isDeleted = contactUsRepo.deleteContactId(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Contact Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Contact Deletion Failed");
		}
		return infoRes;
	}
	@RequestMapping(value = { "/getLastTenVideos" }, method = RequestMethod.GET)
	public @ResponseBody List<GallaryDetail> getLastTenVideos() {
		List<GallaryDetail> secSaveResponse = new  ArrayList<GallaryDetail>();
		 
		try {
			secSaveResponse = gallaryDetailRepository.getLastTenVedios(); 
		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	@RequestMapping(value = { "/getLastTenPhotos" }, method = RequestMethod.GET)
	public @ResponseBody List<GallaryDetail> getLastTenPhotos() {
		List<GallaryDetail> secSaveResponse = new  ArrayList<GallaryDetail>();
		 
		try {
			secSaveResponse = gallaryDetailRepository.getLastTenPhotos(); 
		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	@RequestMapping(value = { "/getCMSDescByExInt1" }, method = RequestMethod.POST)
	public @ResponseBody List<CmsSearchData> getCMSDescByExInt1(@RequestParam("langId") int langId) {
		List<CmsSearchData> secSaveResponse = new  ArrayList<CmsSearchData>();
		 
		try {
			secSaveResponse = cmsPageDescRepository.getCMSDescByExInt1(langId); 
		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	
	@RequestMapping(value = { "/getLastFiveTestImonials" }, method = RequestMethod.GET)
	public @ResponseBody List<TestImonial> getLastFiveTestImonials() {
		List<TestImonial> secSaveResponse = new  ArrayList<TestImonial>();
		 
		try {
			secSaveResponse = testImonialListRepo.getLastFiveTestImonials(); 
		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	@RequestMapping(value = { "/getTeamDetail" }, method = RequestMethod.GET)
	public @ResponseBody List<TestImonial> getLastTenTeam() {
		List<TestImonial> secSaveResponse = new  ArrayList<TestImonial>();
		 
		try {
			secSaveResponse = testImonialListRepo.getTeamDetail(); 
		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	@RequestMapping(value = { "/getSuccessStory" }, method = RequestMethod.GET)
	public @ResponseBody List<TestImonial> getLastTenSuccessStory() {
		List<TestImonial> secSaveResponse = new  ArrayList<TestImonial>();
		 
		try {
			secSaveResponse = testImonialListRepo.getSuccessStory(); 
		
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	@RequestMapping(value = { "/getLastSliderImagesByStatus" }, method = RequestMethod.GET)
	public @ResponseBody BannerImages getLastSliderImagesByStatus() {

		BannerImages secSaveResponse = new BannerImages();
		 
		try {
			secSaveResponse = bannerImagesRepo.getLastSliderImagesByStatus(1); 
		
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	
	
}
