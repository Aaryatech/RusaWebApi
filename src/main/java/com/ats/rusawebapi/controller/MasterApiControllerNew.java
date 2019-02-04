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
import com.ats.rusawebapi.model.CMSPages;
import com.ats.rusawebapi.model.ImageLink;
import com.ats.rusawebapi.model.Logo;
import com.ats.rusawebapi.model.MetaData;
import com.ats.rusawebapi.model.ModulesNames;
import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.PagesModule;
import com.ats.rusawebapi.model.SectionDescription;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.CMSPageDescRepository;
import com.ats.rusawebapi.repo.CMSPagesRepository;
import com.ats.rusawebapi.repo.ImageLinkRepository;
import com.ats.rusawebapi.repo.LoginLogsRepo;
import com.ats.rusawebapi.repo.LogoRepository;
import com.ats.rusawebapi.repo.MetaDataRepository;
import com.ats.rusawebapi.repo.ModuleNameRepository;
import com.ats.rusawebapi.repo.PagesModuleRepository;
import com.ats.rusawebapi.repo.TestImonialRepository;
import com.ats.rusawebapi.tx.model.GalleryDetail;
import com.ats.rusawebapi.tx.model.Galleryheader;

@RestController
public class MasterApiControllerNew {
	@Autowired
	BannerImagesRepository bannerImagesRepo;
	
	@Autowired
	LogoRepository LogoRepo;
	
	@Autowired
	ModuleNameRepository moduleNameRepo;
	
	@Autowired
	CMSPagesRepository cmsPagesRepo;
	
	@Autowired
	CMSPageDescRepository cmsPagesDescRepo;
	
	@Autowired
	PagesModuleRepository pagesModuleRepo;
	
	@Autowired
	MetaDataRepository metaDataRepo;
	
	@Autowired
	ImageLinkRepository imageLinkRepo;
	
	@Autowired
	TestImonialRepository testImonialListRepo;
	
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
	@RequestMapping(value = { "/saveModuleNames" }, method = RequestMethod.POST)
	public @ResponseBody ModulesNames saveModuleNames(@RequestBody ModulesNames getmodulesList) {

		Info errorMessage = new Info();
		//System.out.println("Save Modules");
		ModulesNames moduleList=null;
		try {

			moduleList = moduleNameRepo.save(getmodulesList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return moduleList;

	}
	
	@RequestMapping(value = { "/getModuleNameById" }, method = RequestMethod.POST)
	public @ResponseBody ModulesNames getModuleNameById(@RequestParam("id") int id) {

		ModulesNames moduleSaveRes = new ModulesNames();
		 
		try {
			moduleSaveRes = moduleNameRepo.findByIdAndStatus(id, 1); 
		
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return moduleSaveRes;
	}
	
	@RequestMapping(value = { "/getAllModuleNameList" }, method = RequestMethod.GET)
	public @ResponseBody List<ModulesNames> getAllModuleNameList() {

		List<ModulesNames> moduleList = new ArrayList<ModulesNames>();

		try {

			moduleList = moduleNameRepo.findByStatusOrderById(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return moduleList;

	}
	
	
	@RequestMapping(value = { "/saveCMSPagesHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody CMSPages saveCMSPagesHeaderAndDetail(@RequestBody CMSPages cmsPageDesc) {

		Info errorMessage = new Info();
		CMSPages gHeader = new CMSPages();
		try {

			gHeader = cmsPagesRepo.save(cmsPageDesc);

			for (int i = 0; i < cmsPageDesc.getDetailList().size(); i++) {

				cmsPageDesc.getDetailList().get(i).setCmsPageId(gHeader.getCmsPageId());

			}

			List<CMSPageDescription> gDetailsList = cmsPagesDescRepo.saveAll(cmsPageDesc.getDetailList());
			gHeader.setDetailList(gDetailsList);

			errorMessage.setError(false);
			errorMessage.setMsg("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return gHeader;

	}
	
	
	@RequestMapping(value = { "/saveCMSPages" }, method = RequestMethod.POST)
	public @ResponseBody CMSPages saveCMSPages(@RequestBody CMSPages getCmsPagesList) {

		Info errorMessage = new Info();
		//System.out.println("Save Modules");
		CMSPages cmsPagesList=null;
		try {

			cmsPagesList = cmsPagesRepo.save(getCmsPagesList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return cmsPagesList;

	}
	@RequestMapping(value = { "/savePagesModules" }, method = RequestMethod.POST)
	public @ResponseBody PagesModule savePagesModules(@RequestBody PagesModule getModulesPagesList) {

		Info errorMessage = new Info();
		//System.out.println("Save Modules");
		PagesModule modulesPagesList=null;
		try {

			modulesPagesList = pagesModuleRepo.save(getModulesPagesList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return modulesPagesList;
	}
	
	@RequestMapping(value = { "/saveMetaData" }, method = RequestMethod.POST)
	public @ResponseBody List<MetaData> saveMetaData(@RequestBody List<MetaData> getMataDataList) {

		Info errorMessage = new Info();
		System.out.println("Save Slider Images");
		List<MetaData> MetaDataList=null;
		try {

			MetaDataList = metaDataRepo.saveAll(getMataDataList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return MetaDataList;

	}
	/*
	@RequestMapping(value = { "/getMetaDataById" }, method = RequestMethod.POST)
	public @ResponseBody MetaData getMetaDataById(@RequestParam("id") int id) {

		MetaData metaResponse = new MetaData();
		 
		try {
			metaResponse = metaDataRepo.findById(id); 
		
			   

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return metaResponse;
	}   
	*/
	@RequestMapping(value = { "/getAllMetaDataList" }, method = RequestMethod.GET)
	public @ResponseBody List<MetaData> getAllMetaDataList() {

		List<MetaData> metaList = new ArrayList<MetaData>();

		try {

			metaList = metaDataRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return metaList;  

	}

	@RequestMapping(value = { "/getMetaListById" }, method = RequestMethod.POST)
	public @ResponseBody MetaData getMetaListById(@RequestParam("id") int id) {

		MetaData MetaDataResponse = new MetaData();
		 
		try {
			MetaDataResponse = metaDataRepo.findById(id); 
			if(MetaDataResponse==null)
			{
				MetaDataResponse = new MetaData();
			}
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return MetaDataResponse;
	}
	
	/*@RequestMapping(value = { "/saveMetaData" }, method = RequestMethod.POST)
	public @ResponseBody Section saveMetaDataNew(@RequestBody MetaData metadata) {

		MetaData secSaveResponse = new MetaData();
		 
		try {
			 
			
			secSaveResponse = metaDataRepo.saveAndFlush(metadata); 
			 
			for(int i = 0 ; i<secSaveResponse.getMetaDescriptionList().size() ; i++) {
				
				metadata.getMetaDescriptionList().get(i).setId(secSaveResponse.getId());
			}
			
			List<MetaData> list = metaDataRepo.saveAll(metadata.getMetaDescriptionList());
			secSaveResponse.setMetaDescriptionList(list);
			
			Page pageByPageId = new Page();
			
			if(section.getExInt2()!=0) {
				
				pageByPageId = pageRepo.findByPageId(section.getExInt2());
				pageByPageId.setPageName(section.getSectionName());
				pageByPageId.setTypeSecCate("sec");
				pageByPageId.setSecCateId(secSaveResponse.getSectionId());
				 
			}else {
				 
				pageByPageId.setPageName(section.getSectionName());
				pageByPageId.setTypeSecCate("sec");
				pageByPageId.setSecCateId(secSaveResponse.getSectionId());
				Page save = pageRepo.saveAndFlush(pageByPageId);
				section.setExInt2(save.getPageId());
			}
			 
			String str = secSaveResponse.getSectionSlugname()+section.getExInt2();
			int count = metaDataRepo.updateSlugName(secSaveResponse.getSectionId(),str,pageByPageId.getPageId());
			pageByPageId.setPageSlug(str);
			Page save = pageRepo.saveAndFlush(pageByPageId);

		} catch (Exception e) {

			 
			e.printStackTrace();
		}

		return secSaveResponse;

	}
*/
	
	@RequestMapping(value = { "/saveImageLink" }, method = RequestMethod.POST)
	public @ResponseBody ImageLink saveImageLink(@RequestBody ImageLink galDetailList) {

		Info errorMessage = new Info();
		System.out.println("Save Slider Images");
		ImageLink imagesList=null;
		try {

			imagesList = imageLinkRepo.save(galDetailList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return imagesList;

	}
	
	@RequestMapping(value = { "/getImageLinksById" }, method = RequestMethod.POST)
	public @ResponseBody ImageLink getImageLinksById(@RequestParam("id") int id) {

		ImageLink imageLinkList = new ImageLink();
		 
		try {
			imageLinkList = imageLinkRepo.findByIdAndDelStatus(id, 1); 
		
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return imageLinkList;
	}
	
	
	@RequestMapping(value = { "/getAllImageLinkList" }, method = RequestMethod.GET)
	public @ResponseBody List<ImageLink> getAllImageLinkList() {

		List<ImageLink> imagesList = new ArrayList<ImageLink>();

		try {

			imagesList = imageLinkRepo.findByDelStatusOrderById(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return imagesList;

	}
	@RequestMapping(value = { "/deleteImagesLink" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteImagesLink(@RequestParam("id") int id) {

		int isDeleted = imageLinkRepo.deleteImageLinks(id);
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
	
	@RequestMapping(value = { "/saveTextImonial" }, method = RequestMethod.POST)
	public @ResponseBody TestImonial saveTextImonial(@RequestBody TestImonial getCmsPagesList) {

		Info errorMessage = new Info();
		//System.out.println("Save Modules");
		TestImonial TestImonialList=null;
		try {

			TestImonialList = testImonialListRepo.save(getCmsPagesList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return TestImonialList;

	}
}
