package com.ats.rusawebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.common.LastUpdatedSiteDate;
import com.ats.rusawebapi.model.CMSPageDescription;
import com.ats.rusawebapi.model.CMSPages;
import com.ats.rusawebapi.model.GetPagesModule;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.CMSPageDescRepository;
import com.ats.rusawebapi.repo.CMSPagesRepository;
import com.ats.rusawebapi.repo.DocumentUploadRepository;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.GetPagesModuleRepository;
import com.ats.rusawebapi.repo.NewsBlogRepository;
import com.ats.rusawebapi.repo.SettingRepo;
import com.ats.rusawebapi.repo.TestImonialRepository;
import com.ats.rusawebapi.repo.mst.FreqAskQueRepo;

@RestController
public class PagesModuleApiController {

	@Autowired
	GetPagesModuleRepository getPagesModuleRepository;

	@Autowired
	CMSPagesRepository cmsPagesRepo;

	@Autowired
	SettingRepo settingRepository;

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

			if (delete == 0) {
				errorMessage.setError(true);
				errorMessage.setMsg("failed to delete ");
			} else {
				errorMessage.setError(false);
				errorMessage.setMsg(" deleted");
			}

			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);

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

	// *******************************List Multiple Delete*********************

	@RequestMapping(value = { "/deleteMultipleCMSContentList" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleCMSContentList(@RequestParam("id") List<Integer> id) {

		System.err.println("in mul api del");
		int isDeleted = cmsPagesRepo.deleteMultipleCMSPage(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("CMSList Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("CMSList Deletion Failed");
		}
		return infoRes;
	}

	@Autowired
	FreqAskQueRepo freqAskQueRepo;

	@RequestMapping(value = { "/deleteMultipleFAQList" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleFAQList(@RequestParam("id") List<Integer> id) {

		int isDeleted = freqAskQueRepo.deleteMultipleFaqs(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("FAQ Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("FAQ Deletion Failed");
		}
		return infoRes;
	}

	@Autowired
	GallaryDetailRepository gallaryDetailRepository;

	@RequestMapping(value = { "/deleteMultipleGalleryImageVideoList" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleGalleryImageVideoList(@RequestParam("id") List<Integer> id) {

		int isDeleted = gallaryDetailRepository.deleteMultipleGalleryDetail(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("GalleryImageVide Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("GalleryImageVide Deletion Failed");
		}
		return infoRes;
	}

	@Autowired
	TestImonialRepository testImonialRepository;

	@RequestMapping(value = { "/deleteMultipleTestimonialSuccessTeamList" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleTestimonialSuccessTeamList(@RequestParam("id") List<Integer> id) {

		int isDeleted = testImonialRepository.deleteMultipleTestImonial(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Testimonial Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Testimonial Deletion Failed");
		}
		return infoRes;
	}

	@Autowired
	DocumentUploadRepository documentUploadRepository;

	@RequestMapping(value = { "/deleteMultipleDocumentList" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleDocumentList(@RequestParam("id") List<Integer> id) {

		int isDeleted = documentUploadRepository.deleteMultipleDocument(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Documents Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Documents Deletion Failed");
		}
		return infoRes;
	}
	
	
	@Autowired
	NewsBlogRepository newsBlogRepository;

	@RequestMapping(value = { "/deleteMultipleNewsBlogEventsList" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleNewsBlogList(@RequestParam("id") List<Integer> id) {

		int isDeleted = newsBlogRepository.deleteMultipleNewsBlog(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Documents Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Documents Deletion Failed");
		}
		return infoRes;
	}

}
