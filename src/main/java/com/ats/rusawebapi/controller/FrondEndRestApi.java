package com.ats.rusawebapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ats.rusawebapi.model.CalenderList;
import com.ats.rusawebapi.model.CategoryList;
import com.ats.rusawebapi.model.DocumentUpload;
import com.ats.rusawebapi.model.EventRecord;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.ImageListByCategory;
import com.ats.rusawebapi.model.Maintainance;
import com.ats.rusawebapi.model.MetaData;
import com.ats.rusawebapi.model.NewsBlog;
import com.ats.rusawebapi.model.NewsBlogDescription;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.NewsSectionList;
import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.PageMetaData;
import com.ats.rusawebapi.model.PreviousRegRecord;
import com.ats.rusawebapi.model.Registration;
import com.ats.rusawebapi.model.Result;
import com.ats.rusawebapi.model.SectionTree;
import com.ats.rusawebapi.model.SmsCode;
import com.ats.rusawebapi.model.SubCategoryList;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.TopMenuList;
import com.ats.rusawebapi.model.frontend.CmsContent;
import com.ats.rusawebapi.model.frontend.FaqContent;
import com.ats.rusawebapi.model.frontend.PageContent;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.CategoryListRepository;
import com.ats.rusawebapi.repo.DocumentUploadRepository;
import com.ats.rusawebapi.repo.EventRecordRepo;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.ImageListByCategoryRepo;
import com.ats.rusawebapi.repo.MetaDataRepository;
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.NewsSectionListRepo;
import com.ats.rusawebapi.repo.PageMetaDataRepository;
import com.ats.rusawebapi.repo.PageRepo;
import com.ats.rusawebapi.repo.PagesModuleRepository;
import com.ats.rusawebapi.repo.PreviousRegRecordRepo;
import com.ats.rusawebapi.repo.ResultRepository;
import com.ats.rusawebapi.repo.SectionTreeRepository;
import com.ats.rusawebapi.repo.SiteMaintenanceRepository;
import com.ats.rusawebapi.repo.SmsCodeRepository;
import com.ats.rusawebapi.repo.SubCategoryListRepository;
import com.ats.rusawebapi.repo.TestImonialRepository;
import com.ats.rusawebapi.repo.frontend.CmsContentRepository;
import com.ats.rusawebapi.repo.frontend.FaqContentRepository;

@RestController
public class FrondEndRestApi {

	@Autowired
	PageRepo pageRepo;

	@Autowired
	PagesModuleRepository pagesModuleRepo;

	@Autowired
	CmsContentRepository cmsContentRepository;

	@Autowired
	FaqContentRepository faqContentRepository;

	@Autowired
	DocumentUploadRepository documentUploadRepository;

	@Autowired
	TestImonialRepository testImonialListRepo;

	@Autowired
	GallaryDetailRepository gallaryDetailRepository;

	@Autowired
	NewsDetailsRepository newsBolgRepo;

	@Autowired
	SectionTreeRepository sectionTreeRepository;

	@Autowired
	CategoryListRepository categoryListRepository;

	@Autowired
	SubCategoryListRepository subCategoryListRepository;

	@Autowired
	SiteMaintenanceRepository siteMaintenanceRepo;

	@Autowired
	MetaDataRepository metaDataRepo;

	@Autowired
	PageMetaDataRepository pageMetaDataRepo;
	
	@Autowired
	ResultRepository resultRepository;

	@Autowired
	ImageListByCategoryRepo  imageListByCategoryRepo;
	
	@Autowired
	EventRecordRepo eventRecordRepo;
	
	@Autowired
	NewsSectionListRepo newsSectionListRepo;
	
	@Autowired
	PreviousRegRecordRepo previousRegRecordRepo;
	
	@Autowired
	SmsCodeRepository smsCodeRepo;
	
	@RequestMapping(value = { "/getDataBySlugName" }, method = RequestMethod.POST)
	public @ResponseBody PageContent getDataBySlugName(@RequestParam("slugName") String slugName,
			@RequestParam("langId") int langId) {

		PageContent pageContent = new PageContent();
		try {

			Page page = pageRepo.findByPageSlug(slugName,langId);
			List<Integer> moduleList = pagesModuleRepo.getmoduleList(page.getPageId());
			int sectionId = pageRepo.getSectioinId(page.getPageId());
			pageContent.setPageId(page.getPageId());
			pageContent.setPageName(page.getPageName());
			pageContent.setSectioinId(sectionId);
			for (int i = 0; i < moduleList.size(); i++) {

				if (moduleList.get(i) == 1) {

					List<CmsContent> cmsContentList = cmsContentRepository.getCmsContent(langId, page.getPageId());
					pageContent.setCmsContentList(cmsContentList);

				} else if (moduleList.get(i) == 2) {

					List<FaqContent> faqContentList = faqContentRepository.getFaqContent(langId, page.getPageId());
					pageContent.setFaqContentList(faqContentList);

				} else if (moduleList.get(i) == 7) {

					List<DocumentUpload> documentUploadList = documentUploadRepository
							.findByPageIdAndDelStatusAndIsActiveOrderBySortNo(page.getPageId(), 1, 1);
					pageContent.setDocumentUploadList(documentUploadList);
				} else if (moduleList.get(i) == 6) {

					List<TestImonial> testImonialList = testImonialListRepo
							.findByPageIdAndDelStatusAndIsActiveAndSectionIdOrderBySortNo(page.getPageId(), 1, 1, 6);
					pageContent.setTestImonialList(testImonialList);
				} else if (moduleList.get(i) == 3) {

					List<GallaryDetail> gallaryDetailList = gallaryDetailRepository
							.findByIsActiveAndDelStatusAndPageIdAndTypeVideoImage(1, 1, page.getPageId(),"3");
					pageContent.setGallaryDetailList(gallaryDetailList);
				} else if (moduleList.get(i) == 9) {

					List<NewsDetails> newsBlogList = newsBolgRepo.getNewsContent(langId, page.getPageId());
					pageContent.setDetailNewsList(newsBlogList);
				} else if (moduleList.get(i) == 13) {

					List<TestImonial> testImonialList = testImonialListRepo
							.findByPageIdAndDelStatusAndIsActiveAndSectionIdOrderBySortNo(page.getPageId(), 1, 1, 13);
					pageContent.setTeamList(testImonialList);
				} else if (moduleList.get(i) == 8) {

					List<TestImonial> testImonialList = testImonialListRepo
							.findByPageIdAndDelStatusAndIsActiveAndSectionIdOrderBySortNo(page.getPageId(), 1, 1, 8);
					pageContent.setSuccessList(testImonialList);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return pageContent;

	}
	
	@RequestMapping(value = { "/getImages" }, method = RequestMethod.POST)
	public @ResponseBody PageContent getImages(@RequestParam("slugName") String slugName,@RequestParam("langId") int langId) {

		PageContent pageContent = new PageContent();
		try {

			Page page = pageRepo.findByPageSlug(slugName,langId);
			List<Integer> moduleList = pagesModuleRepo.getmoduleList(page.getPageId());
			int sectionId = pageRepo.getSectioinId(page.getPageId());
			pageContent.setPageId(page.getPageId());
			pageContent.setPageName(page.getPageName());
			pageContent.setSectioinId(sectionId);
			for (int i = 0; i < moduleList.size(); i++) {

				  if (moduleList.get(i) == 3) {

					List<GallaryDetail> gallaryDetailList = gallaryDetailRepository
							.findByIsActiveAndDelStatusAndPageIdAndTypeVideoImage(1, 1, page.getPageId(),"3");
					pageContent.setGallaryDetailList(gallaryDetailList);
					
					List<ImageListByCategory> imageListByCategoryList = imageListByCategoryRepo
							.imageListByCategoryList(page.getPageId(),langId);
					pageContent.setImageListByCategory(imageListByCategoryList);
				}  
				  
				  if (moduleList.get(i) == 4) {

						List<GallaryDetail> gallaryDetailList = gallaryDetailRepository
								.findByIsActiveAndDelStatusAndPageIdAndTypeVideoImage(1, 1, page.getPageId(),"4");
						pageContent.setVideoList(gallaryDetailList);
						
						List<ImageListByCategory> imageListByCategoryList = imageListByCategoryRepo
								.imageListByCategoryList(page.getPageId(),langId);
						pageContent.setImageListByCategory(imageListByCategoryList);
					}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return pageContent;

	}

	@RequestMapping(value = { "/getTopMenuList" }, method = RequestMethod.POST)
	public @ResponseBody TopMenuList getTopMenuList(@RequestParam("langId") int langId,
			@RequestParam("type") List<Integer> type) {

		TopMenuList topMenuList = new TopMenuList();

		try {

			List<SectionTree> list = sectionTreeRepository.getSectionListByLangId(langId, type);
			topMenuList.setSectionlist(list);

			List<CategoryList> categoryList = categoryListRepository.getCategoryListByLangId(langId);
			topMenuList.setCategoryList(categoryList);

			List<SubCategoryList> subCategoryList = subCategoryListRepository.getSubCategoryListByLangId(langId);
			topMenuList.setSubCatList(subCategoryList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return topMenuList;

	}

	@RequestMapping(value = { "/checkIsMaintenance" }, method = RequestMethod.GET)
	public @ResponseBody Maintainance checkIsMaintenance() {

		Maintainance maintainance = new Maintainance();

		try {

			maintainance = siteMaintenanceRepo.checkIsMaintenance();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return maintainance;

	}

	@RequestMapping(value = { "/getPageMetaData" }, method = RequestMethod.POST)
	public @ResponseBody PageMetaData getPageMetaData(@RequestParam("slugName") String slugName) {

		PageMetaData pageMetaData = new PageMetaData();

		try {

			pageMetaData = pageMetaDataRepo.getPageMetaData(slugName);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return pageMetaData;

	}

	@RequestMapping(value = { "/getHomePageMetaDataByLangId" }, method = RequestMethod.POST)
	public @ResponseBody MetaData getHomePageMetaDataByLangId(@RequestParam("langId") int langId) {

		MetaData metaResponse = new MetaData();

		try {
			metaResponse = metaDataRepo.findByLanguageId(langId);
			System.out.println(metaResponse);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return metaResponse;
	}
	
	@RequestMapping(value = { "/getEventListforCalender" }, method = RequestMethod.GET)
	public @ResponseBody CalenderList getEventListforCalender() {

		CalenderList calenderList = new CalenderList();

		try {
			List<Result> result = resultRepository.getEventListforCalender(); 
			calenderList.setResult(result);
			calenderList.setSuccess(1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return calenderList;
	}
	
	@RequestMapping(value = { "/allPreviousEventWithApllied" }, method = RequestMethod.POST)
	public @ResponseBody List<EventRecord> allPreviousEventWithApllied(@RequestParam("langId") int langId,@RequestParam("userId") int userId) {
		List<EventRecord> secSaveResponse = new ArrayList<EventRecord>();

		try {
			secSaveResponse = eventRecordRepo.getAllPreviousEvents(langId,userId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}
	
	@RequestMapping(value = { "/getNewsSectionBySectionId" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsSectionList> getNewsSectionBySectionId(@RequestParam("sectionId") int sectionId,
			@RequestParam("langId") int langId) {

		List<NewsSectionList> newsSectionList = new ArrayList<>();
		 
		try {  
			 
			newsSectionList = newsSectionListRepo.getNewsSectionBySectionId(sectionId,langId);
		 
		} catch (Exception e) {

			e.printStackTrace();
			 

		}
		return newsSectionList;

	}
	
	@RequestMapping(value = { "/savePreviousRecord" }, method = RequestMethod.POST)
	public @ResponseBody PreviousRegRecord savePreviousRecord(@RequestBody PreviousRegRecord previousRegRecord) {

		PreviousRegRecord save = new PreviousRegRecord();
		 
		try {  
			 
			save = previousRegRecordRepo.save(previousRegRecord);
		 
		} catch (Exception e) {

			e.printStackTrace();
			 

		}
		return save;

	}
	
	@RequestMapping(value = { "/getPrevRecordByRegId" }, method = RequestMethod.POST)
	public @ResponseBody PreviousRegRecord getPrevRecordByRegId(@RequestParam("regId") int regId) {

		PreviousRegRecord getPrevRecordByRegId = new PreviousRegRecord();
		 
		try {  
			 
			getPrevRecordByRegId = previousRegRecordRepo.findByRegId(regId);
			
			if(getPrevRecordByRegId==null) {
				
				getPrevRecordByRegId = new PreviousRegRecord();
				getPrevRecordByRegId.setError(true);
				getPrevRecordByRegId.setMessage("Not Found");
			}else {
				
				getPrevRecordByRegId.setError(false);
				getPrevRecordByRegId.setMessage("Found");
			}
		 
		} catch (Exception e) {

			e.printStackTrace();
			getPrevRecordByRegId = new PreviousRegRecord();
			getPrevRecordByRegId.setError(true);
			getPrevRecordByRegId.setMessage("Not Found");

		}
		return getPrevRecordByRegId;

	}
	
	@RequestMapping(value = { "/sendOtp" }, method = RequestMethod.POST)
	public @ResponseBody Info sendOtp(@RequestParam("uuid") String uuid,@RequestParam("mobileNo") String mobileNo) {
 
		  
		Info info = new Info();
		
		try {
			
			
			RestTemplate restTemplate = new RestTemplate();
				int randomPin = (int) (Math.random() * 9000) + 1000;
				String otp = String.valueOf(randomPin);
				System.out.println("You OTP is " + otp);
				String msg=" Your verification OTP for Registration is " +otp+ ". Do not share OTP with anyone. RUSA Maharashtra";
 
				Date date = new Date(); // your date
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);

				SmsCode sms = new SmsCode();

				sms.setSmsCode(otp);
				sms.setUserUuid(uuid);
				sms.setSmsType(1);
				sms.setDateSent(sf.format(date));

				smsCodeRepo.saveAndFlush(sms);
				
				MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();		           
		           
	            map.add("senderID", "RUSAMH");
	            map.add("user", "spdrusamah@gmail.com:Cyber@mva");
	            map.add("receipientno", mobileNo);
	            map.add("dcs", "0");
	            map.add("msgtxt",msg);
	            map.add("state", "4");
	           
	            String response = restTemplate.postForObject("http://api.mVaayoo.com/mvaayooapi/MessageCompose", map,
	                    String.class); 
	            info.setError(false);
	            info.setMsg(otp);
				//Info info1 = EmailUtility.sendMsg(otp, studResp.getMobileNumber());

				//System.err.println("Info email sent response   " + info1.toString());

		
		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
			
			 info.setError(true);
	            info.setMsg("failed");
		}

		return info;

	}

}
