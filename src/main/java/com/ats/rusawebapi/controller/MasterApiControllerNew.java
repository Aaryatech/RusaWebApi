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

import com.ats.rusawebapi.common.Firebase;
import com.ats.rusawebapi.common.LastUpdatedSiteDate;
import com.ats.rusawebapi.model.AppToken;
import com.ats.rusawebapi.model.BannerDetail;
import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.CMSPageDescription;
import com.ats.rusawebapi.model.CMSPages;
import com.ats.rusawebapi.model.DocumentUpload;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.GetPagesModule;
import com.ats.rusawebapi.model.ImageLink;
import com.ats.rusawebapi.model.Logo;
import com.ats.rusawebapi.model.Maintainance;
import com.ats.rusawebapi.model.MetaData;
import com.ats.rusawebapi.model.ModulesNames;
import com.ats.rusawebapi.model.NewsBlog;
import com.ats.rusawebapi.model.NewsBlogDescription;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.PagesModule;
import com.ats.rusawebapi.model.SectionDescription;
import com.ats.rusawebapi.model.SocialChannels;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.TestimonialDetail;
import com.ats.rusawebapi.model.frontend.PageContent;
import com.ats.rusawebapi.model.mst.GetCategory;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.repo.AppTokenRepository;
import com.ats.rusawebapi.repo.BannerDetailRepo;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.CMSPageDescRepository;
import com.ats.rusawebapi.repo.CMSPagesRepository;
import com.ats.rusawebapi.repo.DocumentUploadRepository;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.GetPagesModuleRepository;
import com.ats.rusawebapi.repo.ImageLinkRepository;
import com.ats.rusawebapi.repo.LoginLogsRepo;
import com.ats.rusawebapi.repo.LogoRepository;
import com.ats.rusawebapi.repo.MetaDataRepository;
import com.ats.rusawebapi.repo.ModuleNameRepository;
import com.ats.rusawebapi.repo.NewsBlogDescRepository;
import com.ats.rusawebapi.repo.NewsBlogRepository;
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.PagesModuleRepository;
import com.ats.rusawebapi.repo.SettingRepo;
import com.ats.rusawebapi.repo.SiteMaintenanceRepository;
import com.ats.rusawebapi.repo.SocialChannelRepository;
import com.ats.rusawebapi.repo.TestImonialRepository;
import com.ats.rusawebapi.repo.TestimonialDetailRepo;
import com.ats.rusawebapi.repo.mst.CategoryRepo;
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
	SettingRepo settingRepository;

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

	@Autowired
	GetPagesModuleRepository getPagesModuleRepository;

	@Autowired
	DocumentUploadRepository uploadDocRepo;

	@Autowired
	NewsBlogRepository newsBolgRepo;

	@Autowired
	NewsBlogDescRepository newsBolgDescRepo;

	@Autowired
	NewsDetailsRepository newsDetailRepo;

	@Autowired
	SocialChannelRepository socialDetailRepo;

	@Autowired
	SiteMaintenanceRepository siteMaintenanceRepo;

	@Autowired
	GallaryDetailRepository gallaryDetailRepository;

	@Autowired
	CategoryRepo catRepo;

	@Autowired
	AppTokenRepository appTokenRepo;

	@Autowired
	BannerDetailRepo bannerDetailRepo;

	@RequestMapping(value = { "/saveBannerImages" }, method = RequestMethod.POST)
	public @ResponseBody BannerImages saveBannerImages(@RequestBody BannerImages galDetailList) {

		Info errorMessage = new Info();
		System.out.println("Save Slider Images");
		BannerImages BannerImagesList = new BannerImages();
		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			BannerImagesList = bannerImagesRepo.save(galDetailList);
			
			for(int i=0;i<galDetailList.getDetillist().size();i++) {
				galDetailList.getDetillist().get(i).setCateId(BannerImagesList.getId());
			}
			
			List<BannerDetail> list = bannerDetailRepo.saveAll(galDetailList.getDetillist());
			BannerImagesList.setDetillist(list);
			
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

			List<BannerDetail> BannerDetail = bannerDetailRepo.findByCateIdAndDelStatus(id, 1);

			if (BannerDetail == null) {
				BannerDetail = new ArrayList<>();
			}
			secSaveResponse.setDetillist(BannerDetail);

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
		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			if (isDeleted >= 1) {
				infoRes.setError(false);
				infoRes.setMsg("Banner Deleted Successfully");
			} else {
				infoRes.setError(true);
				infoRes.setMsg("Banner Deletion Failed");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return infoRes;
	}

	@RequestMapping(value = { "/saveLogo" }, method = RequestMethod.POST)
	public @ResponseBody Logo saveLogo(@RequestBody Logo logoList) {

		Info errorMessage = new Info();

		Logo logoImagesList = null;
		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
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
			if (logoSaveResponse == null) {
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
		// System.out.println("Save Modules");
		ModulesNames moduleList = null;
		try {

			moduleList = moduleNameRepo.save(getmodulesList);
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
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

			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
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
		// System.out.println("Save Modules");
		CMSPages cmsPagesList = null;
		try {

			cmsPagesList = cmsPagesRepo.save(getCmsPagesList);
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
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
		// System.out.println("Save Modules");
		PagesModule modulesPagesList = null;
		try {

			modulesPagesList = pagesModuleRepo.save(getModulesPagesList);
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
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
		List<MetaData> MetaDataList = null;
		try {

			MetaDataList = metaDataRepo.saveAll(getMataDataList);
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return MetaDataList;

	}

	/*
	 * @RequestMapping(value = { "/getMetaDataById" }, method = RequestMethod.POST)
	 * public @ResponseBody MetaData getMetaDataById(@RequestParam("id") int id) {
	 * 
	 * MetaData metaResponse = new MetaData();
	 * 
	 * try { metaResponse = metaDataRepo.findById(id);
	 * 
	 * 
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return metaResponse; }
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
			if (MetaDataResponse == null) {
				MetaDataResponse = new MetaData();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return MetaDataResponse;
	}

	/*
	 * @RequestMapping(value = { "/saveMetaData" }, method = RequestMethod.POST)
	 * public @ResponseBody Section saveMetaDataNew(@RequestBody MetaData metadata)
	 * {
	 * 
	 * MetaData secSaveResponse = new MetaData();
	 * 
	 * try {
	 * 
	 * 
	 * secSaveResponse = metaDataRepo.saveAndFlush(metadata);
	 * 
	 * for(int i = 0 ; i<secSaveResponse.getMetaDescriptionList().size() ; i++) {
	 * 
	 * metadata.getMetaDescriptionList().get(i).setId(secSaveResponse.getId()); }
	 * 
	 * List<MetaData> list =
	 * metaDataRepo.saveAll(metadata.getMetaDescriptionList());
	 * secSaveResponse.setMetaDescriptionList(list);
	 * 
	 * Page pageByPageId = new Page();
	 * 
	 * if(section.getExInt2()!=0) {
	 * 
	 * pageByPageId = pageRepo.findByPageId(section.getExInt2());
	 * pageByPageId.setPageName(section.getSectionName());
	 * pageByPageId.setTypeSecCate("sec");
	 * pageByPageId.setSecCateId(secSaveResponse.getSectionId());
	 * 
	 * }else {
	 * 
	 * pageByPageId.setPageName(section.getSectionName());
	 * pageByPageId.setTypeSecCate("sec");
	 * pageByPageId.setSecCateId(secSaveResponse.getSectionId()); Page save =
	 * pageRepo.saveAndFlush(pageByPageId); section.setExInt2(save.getPageId()); }
	 * 
	 * String str = secSaveResponse.getSectionSlugname()+section.getExInt2(); int
	 * count =
	 * metaDataRepo.updateSlugName(secSaveResponse.getSectionId(),str,pageByPageId.
	 * getPageId()); pageByPageId.setPageSlug(str); Page save =
	 * pageRepo.saveAndFlush(pageByPageId);
	 * 
	 * } catch (Exception e) {
	 * 
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return secSaveResponse;
	 * 
	 * }
	 */

	@RequestMapping(value = { "/saveImageLink" }, method = RequestMethod.POST)
	public @ResponseBody ImageLink saveImageLink(@RequestBody ImageLink galDetailList) {

		Info errorMessage = new Info();
		System.out.println("Save Slider Images");
		ImageLink imagesList = null;
		try {

			imagesList = imageLinkRepo.save(galDetailList);
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
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

			imagesList = imageLinkRepo.findByDelStatusAndIsActiveOrderBySortOrder(1, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return imagesList;

	}

	@RequestMapping(value = { "/deleteImagesLink" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteImagesLink(@RequestParam("id") int id) {

		int isDeleted = imageLinkRepo.deleteImageLinks(id);
		Info infoRes = new Info();
		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			if (isDeleted >= 1) {
				infoRes.setError(false);
				infoRes.setMsg("Banner Deleted Successfully");
			} else {
				infoRes.setError(true);
				infoRes.setMsg("Banner Deletion Failed");
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return infoRes;
	}

	@RequestMapping(value = { "/saveTextImonial" }, method = RequestMethod.POST)
	public @ResponseBody TestImonial saveTextImonial(@RequestBody TestImonial getCmsPagesList) {

		Info errorMessage = new Info();
		// System.out.println("Save Modules");
		TestImonial TestImonialList = null;
		try {

			TestImonialList = testImonialListRepo.save(getCmsPagesList);
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return TestImonialList;

	}

	@Autowired
	TestimonialDetailRepo testimonialDetailRepo;
	
	@RequestMapping(value = { "/saveTestinomialsHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody TestImonial saveTestinomialsHeaderAndDetail(@RequestBody TestImonial testDesc) {

		Info errorMessage = new Info();
		TestImonial testi = new TestImonial();
		//System.out.println("head are ****"+testDesc.toString());
		///System.out.println("detail are ****"+testDesc.getDetailList().toString());

 		try {

 			testi = testImonialListRepo.save(testDesc);

			for (int i = 0; i < testDesc.getDetailList().size(); i++) {

				testDesc.getDetailList().get(i).setTestHeadId(testi.getId());

			}

			List<TestimonialDetail> gDetailsList = testimonialDetailRepo.saveAll(testDesc.getDetailList());
			testi.setDetailList(gDetailsList);

			errorMessage.setError(false);
			errorMessage.setMsg("successfully Saved ");
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return testi;

	}  
	

	@RequestMapping(value = { "/getTestinomialHeadDetById" }, method = RequestMethod.POST)
	public @ResponseBody TestImonial getTestinomialHeadDetById(@RequestParam("id") int id) {

		TestImonial testi = new TestImonial();

		try {
			System.out.println("ID: " + id);

			testi = testImonialListRepo.findById(id);
			List<TestimonialDetail> gDetailsList = testimonialDetailRepo.findAllByTestHeadId(id);
			testi.setDetailList(gDetailsList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return testi;

	}
	
	
	@RequestMapping(value = { "/getTestImonialList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPagesModule> getTestImonialList() {

		List<GetPagesModule> list = new ArrayList<>();

		try {

			list = getPagesModuleRepository.getTestImonialList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getSuccessStoryList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPagesModule> getSuccessStoryList() {

		List<GetPagesModule> list = new ArrayList<>();

		try {

			list = getPagesModuleRepository.getSuccessStoryList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getTeamList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPagesModule> getTeamList() {

		List<GetPagesModule> list = new ArrayList<>();

		try {

			list = getPagesModuleRepository.getTeamList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getTestImonialById" }, method = RequestMethod.POST)
	public @ResponseBody TestImonial getTestImonialById(@RequestParam("id") int id) {
		TestImonial testImonial = new TestImonial();

		try {

			testImonial = testImonialListRepo.getTestListById(id);
			// List<CMSPageDescription> gDetailsList = cmsPagesDescRepo.findByCmsPageId(id);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return testImonial;

	}

	@RequestMapping(value = { "/deleteTestImonial" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteTestImonial(@RequestParam("id") int id) {

		Info errorMessage = new Info();

		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int delete = testImonialListRepo.delete(id);

			if (delete == 0) {
				errorMessage.setError(true);
				errorMessage.setMsg("failed to delete ");
			} else {
				errorMessage.setError(false);
				errorMessage.setMsg(" deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to delete ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/saveDocumentFiles" }, method = RequestMethod.POST)
	public @ResponseBody DocumentUpload saveDocumentFiles(@RequestBody DocumentUpload galDetailList) {

		Info errorMessage = new Info();
		System.out.println("Save Slider Images");
		DocumentUpload documentUploadList = null;
		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			documentUploadList = uploadDocRepo.save(galDetailList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return documentUploadList;

	}

	@RequestMapping(value = { "/getDocumentList" }, method = RequestMethod.GET)
	public @ResponseBody List<DocumentUpload> getDocumentList() {

		List<DocumentUpload> list = new ArrayList<>();

		try {
			list = uploadDocRepo.getDocumentList();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getDocumentById" }, method = RequestMethod.POST)
	public @ResponseBody DocumentUpload getDocumentById(@RequestParam("id") int id) {
		DocumentUpload documentUploadList = new DocumentUpload();

		try {

			documentUploadList = uploadDocRepo.getDocumentByDocId(id);
			// List<CMSPageDescription> gDetailsList = cmsPagesDescRepo.findByCmsPageId(id);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentUploadList;

	}

	@RequestMapping(value = { "/deleteDocument" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDocument(@RequestParam("docId") int id) {

		Info errorMessage = new Info();

		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int delete = uploadDocRepo.delete(id);

			if (delete == 0) {
				errorMessage.setError(true);
				errorMessage.setMsg("failed to delete ");
			} else {
				errorMessage.setError(false);
				errorMessage.setMsg(" deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to delete ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/saveNewsBlogHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody NewsBlog saveNewsBlogHeaderAndDetail(@RequestBody NewsBlog newsBlogDesc) {

		Info errorMessage = new Info();
		NewsBlog newsBolg = new NewsBlog();
		List<AppToken> appToken = new ArrayList<AppToken>();
		try {

			newsBolg = newsBolgRepo.save(newsBlogDesc);

			for (int i = 0; i < newsBlogDesc.getDetailList().size(); i++) {

				newsBlogDesc.getDetailList().get(i).setNewsblogsId(newsBolg.getNewsblogsId());

			}

			List<NewsBlogDescription> gDetailsList = newsBolgDescRepo.saveAll(newsBlogDesc.getDetailList());
			newsBolg.setDetailList(gDetailsList);

			errorMessage.setError(false);
			errorMessage.setMsg("successfully Saved ");

			try {
				appToken = appTokenRepo.findAllByDeviceName("android");
				if (appToken != null) {
					for (int i = 0; i < appToken.size(); i++) {

						Firebase.sendPushNotification(appToken.get(i).getToken(), gDetailsList.get(0).getHeading(),
								gDetailsList.get(0).getDescriptions(), 1);
					}

				}

				String lastdate = LastUpdatedSiteDate.updateDate();
				int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return newsBolg;

	}

	@RequestMapping(value = { "/getNewsBlogsListByPageId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPagesModule> getNewsBlogsListByPageId(@RequestParam("pageId") int pageId) {

		List<GetPagesModule> list = new ArrayList<>();

		try {
			list = getPagesModuleRepository.getNewsBlogListByPageId(pageId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getNewsPagebyId" }, method = RequestMethod.POST)
	public @ResponseBody NewsBlog getNewsPagebyId(@RequestParam("newsblogsId") int newsblogsId) {

		NewsBlog cMSPages = new NewsBlog();

		try {
			System.out.println("ID: " + newsblogsId);

			cMSPages = newsBolgRepo.findByNewsblogsId(newsblogsId);
			List<NewsBlogDescription> gDetailsList = newsBolgDescRepo.findAllByNewsblogsId(newsblogsId);
			cMSPages.setDetailList(gDetailsList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cMSPages;

	}

	@RequestMapping(value = { "/getNewsBlogList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPagesModule> getNewsBlogList() {

		List<GetPagesModule> list = new ArrayList<>();

		try {
			list = getPagesModuleRepository.getNewsBlogList();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getNewsBlogsByLangId" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getNewsBlogsByLangId(@RequestParam("langId") int langId) {

		List<NewsDetails> list = new ArrayList<>();

		try {
			list = newsDetailRepo.getNewsBlogListByLangId(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getLastFourNewsByLangId" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getLastFourNewsByLangId(@RequestParam("langId") int langId) {

		List<NewsDetails> list = new ArrayList<>();

		try {
			list = newsDetailRepo.getLastFourNewsByLangId(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getAllNewsByLangId" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllNewsByLangId(@RequestParam("langId") int langId) {

		List<NewsDetails> list = new ArrayList<>();

		try {
			list = newsDetailRepo.getAllNewsBlogList(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getAllNewsByLimit" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllNewsByLimit(@RequestParam("langId") int langId,
			@RequestParam("pageid") int pageid, @RequestParam("total") int total) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			pageid = pageid - 1;
			secSaveResponse = newsDetailRepo.getAllNewsByLimit(langId, pageid, total);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getEventListByNewsblogsId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPagesModule> getEventListByNewsblogsId(@RequestParam("pageId") int pageId) {

		List<GetPagesModule> list = new ArrayList<>();

		try {
			list = getPagesModuleRepository.getEventListByPageId(pageId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getEventList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPagesModule> getEventList() {

		List<GetPagesModule> list = new ArrayList<>();

		try {
			list = getPagesModuleRepository.getEventList();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteNewsBlogContent" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteNewsBlogContent(@RequestParam("newsblogsId") int newsblogsId) {

		Info errorMessage = new Info();

		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int delete = newsBolgRepo.deleteNewsBlog(newsblogsId);

			if (delete == 0) {
				errorMessage.setError(true);
				errorMessage.setMsg("failed to delete ");
			} else {
				errorMessage.setError(false);
				errorMessage.setMsg(" deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to delete ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getNewsBlogById" }, method = RequestMethod.POST)
	public @ResponseBody NewsDetails getNewsBlogById(@RequestParam("langId") int langId,
			@RequestParam("pageId") int pageId, @RequestParam("newsblogsId") int newsblogsId) {

		NewsDetails newsDetails = new NewsDetails();
		// PageContent pageContent = new PageContent();
		try {
			System.out.println("ID: " + newsblogsId);
			System.out.println("pageId: " + pageId);
			System.out.println("langId: " + langId);

			newsDetails = newsDetailRepo.getNewsList(langId, pageId, newsblogsId);
			System.out.println("list: " + newsDetails.toString());
			// newsDetails.setDetailList(newsBlogList);
			// System.out.println("list_new: "+pageContent.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}
		return newsDetails;

	}

	@RequestMapping(value = { "/saveSocialChannel" }, method = RequestMethod.POST)
	public @ResponseBody SocialChannels saveSocialChannel(@RequestBody SocialChannels galDetailList) {

		Info errorMessage = new Info();
		System.out.println("Save Slider Images");
		SocialChannels socialChannelsList = null;
		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			socialChannelsList = socialDetailRepo.save(galDetailList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return socialChannelsList;

	}

	@RequestMapping(value = { "/getSocialChannelById" }, method = RequestMethod.POST)
	public @ResponseBody SocialChannels getSocialChannelById(@RequestParam("id") int id) {

		SocialChannels socialResponse = new SocialChannels();

		try {
			socialResponse = socialDetailRepo.findByIdAndDelStatus(id, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return socialResponse;
	}

	@RequestMapping(value = { "/getAllSocialList" }, method = RequestMethod.GET)
	public @ResponseBody List<SocialChannels> getAllSocialList() {

		List<SocialChannels> conList = new ArrayList<SocialChannels>();

		try {

			conList = socialDetailRepo.findByDelStatusAndIsActiveOrderById(1, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/deleteSocialChannel" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSocialChannel(@RequestParam("id") int id) {

		int isDeleted = socialDetailRepo.deleteChannel(id);
		Info infoRes = new Info();
		try {
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			if (isDeleted >= 1) {
				infoRes.setError(false);
				infoRes.setMsg("Social Channel Deleted Successfully");
			} else {
				infoRes.setError(true);
				infoRes.setMsg("Social Channel Deletion Failed");
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return infoRes;
	}

	@RequestMapping(value = { "/saveSiteMaintenance" }, method = RequestMethod.POST)
	public @ResponseBody Maintainance saveSiteMaintenance(@RequestBody Maintainance galDetailList) {

		Info errorMessage = new Info();
		Maintainance siteList = null;
		System.out.println(galDetailList);
		try {

			siteList = siteMaintenanceRepo.save(galDetailList);
			String lastdate = LastUpdatedSiteDate.updateDate();
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return siteList;

	}

	@RequestMapping(value = { "/getMaintananceRecord" }, method = RequestMethod.GET)
	public @ResponseBody Maintainance getMaintananceRecord() {

		Maintainance maintainance = new Maintainance();

		try {

			maintainance = siteMaintenanceRepo.checkIsMaintenance();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return maintainance;

	}

	@RequestMapping(value = { "/getListByGalleryId" }, method = RequestMethod.POST)
	public @ResponseBody GallaryDetail getListByGalleryId(@RequestParam("galleryDetailsId") int galleryDetailsId) {

		GallaryDetail list = new GallaryDetail();

		try {
			list = gallaryDetailRepository.findByGalleryDetailsId(galleryDetailsId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	@RequestMapping(value = { "/getParentIdCountByCatId" }, method = RequestMethod.POST)
	public @ResponseBody int getParentIdCountByCatId(@RequestParam("catId") int catId) {

		int conList = 0;

		try {

			conList = catRepo.getParentIdCountByCatId(catId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;
	}

	@RequestMapping(value = { "/getParentIdCountBySectionId" }, method = RequestMethod.POST)
	public @ResponseBody int getParentIdCountBySectionId(@RequestParam("sectionId") int sectionId) {

		int conList = 0;

		try {

			conList = catRepo.getParentIdCountBySectionId(sectionId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;
	}
}
