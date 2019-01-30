package com.ats.rusawebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.LoginLogsRepo;
import com.ats.rusawebapi.tx.model.GalleryDetail;

@RestController
public class MasterApiControllerNew {
	@Autowired
	BannerImagesRepository bannerImagesRepo;
	
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
	
}
