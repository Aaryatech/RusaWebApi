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
import com.ats.rusawebapi.model.Logo;
import com.ats.rusawebapi.model.SectionDescription;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.LoginLogsRepo;
import com.ats.rusawebapi.repo.LogoRepository;
import com.ats.rusawebapi.tx.model.GalleryDetail;

@RestController
public class MasterApiControllerNew {
	@Autowired
	BannerImagesRepository bannerImagesRepo;
	
	@Autowired
	LogoRepository LogoRepo;
	
	@RequestMapping(value = { "/saveBannerImages" }, method = RequestMethod.POST)
	public @ResponseBody BannerImages saveBannerImages(@RequestBody BannerImages galDetailList) {

		Info errorMessage = new Info();
		System.out.println("Save Slider Images");
		BannerImages BannerImagesList=null;
		try {

			BannerImagesList = bannerImagesRepo.save(galDetailList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return BannerImagesList;

	}
	
	@RequestMapping(value = { "/getSliderImagesById" }, method = RequestMethod.POST)
	public @ResponseBody BannerImages getSliderImagesById(@RequestParam("id") int id) {

		BannerImages secSaveResponse = new BannerImages();
		 
		try {
			secSaveResponse = bannerImagesRepo.findByIdAndDelStatus(id, 1); 
		
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	
	@RequestMapping(value = { "/getAllBannerList" }, method = RequestMethod.GET)
	public @ResponseBody List<BannerImages> getAllBannerList() {

		List<BannerImages> conList = new ArrayList<BannerImages>();

		try {

			conList = bannerImagesRepo.findByDelStatusOrderById(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}
	@RequestMapping(value = { "/deleteBanner" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteBanner(@RequestParam("id") int id) {

		int isDeleted = bannerImagesRepo.deleteBannerImages(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Banner Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Banner Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/saveLogo" }, method = RequestMethod.POST)
	public @ResponseBody Logo saveLogo(@RequestBody Logo logoList) {

		Info errorMessage = new Info();
	
		Logo logoImagesList=null;
		try {

			logoImagesList = LogoRepo.save(logoList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return logoImagesList;

	}
	
	@RequestMapping(value = { "/getLogoListById" }, method = RequestMethod.POST)
	public @ResponseBody Logo getLogoListById(@RequestParam("id") int id) {

		Logo logoSaveResponse = new Logo();
		 
		try {
			logoSaveResponse = LogoRepo.findById(id); 
			if(logoSaveResponse==null)
			{
				logoSaveResponse = new Logo();
			}
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return logoSaveResponse;
	}
	
	/*@RequestMapping(value = { "/getAllLogoList" }, method = RequestMethod.GET)
	public @ResponseBody Logo getAllLogoList() {

		Logo logoList = new Logo();

		try {

			logoList = LogoRepo.findByOrderById(1);

			if(logoList==null)
			{
				 logoList = new Logo();
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		return logoList;

	}*/
/*	@RequestMapping(value = { "/deleteLogo" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLogo(@RequestParam("id") int id) {

		int isDeleted = LogoRepo.deleteLogo(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Logo Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Logo Deletion Failed");
		}
		return infoRes;
	}*/
}
