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

import com.ats.rusawebapi.common.LastUpdatedSiteDate;
import com.ats.rusawebapi.model.GallaryCategory;
import com.ats.rusawebapi.model.GallaryCategoryDescriptioin;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.PagesModule;
import com.ats.rusawebapi.model.SectionDescription;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.repo.GallaryCategoryDescriptioinRepo;
import com.ats.rusawebapi.repo.GallaryCategoryRepository;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.PageRepo;
import com.ats.rusawebapi.repo.PagesModuleRepository;
import com.ats.rusawebapi.repo.SettingRepo;

@RestController
public class GalleryRestApiController {
	
	@Autowired
	GallaryCategoryRepository gallaryCategoryRepository;
	
	@Autowired
	GallaryCategoryDescriptioinRepo gallaryCategoryDescriptioinRepo;
	
	@Autowired
	GallaryDetailRepository gallaryDetailRepository;
	
	@Autowired
	PagesModuleRepository pagesModuleRepository;
	
	@Autowired
	SettingRepo settingRepository; 
	
	@RequestMapping(value = { "/saveGalleryCategory" }, method = RequestMethod.POST)
	public @ResponseBody GallaryCategory saveGalleryCategory(@RequestBody GallaryCategory gallaryCategory) {

		 
		GallaryCategory save = new GallaryCategory();
		try {

			save = gallaryCategoryRepository.save(gallaryCategory); 
			gallaryCategory.setSlugName(gallaryCategory.getSlugName()+save.getGalleryCatId()); 
			save = gallaryCategoryRepository.save(gallaryCategory);
			
			for(int i=0 ; i<gallaryCategory.getGallaryCategoryDescriptioinList().size() ; i++) {
				
				gallaryCategory.getGallaryCategoryDescriptioinList().get(i).setGalleryCatId(save.getGalleryCatId());
			}
			
			
			List<GallaryCategoryDescriptioin> list = gallaryCategoryDescriptioinRepo.saveAll(gallaryCategory.getGallaryCategoryDescriptioinList());

			save.setGallaryCategoryDescriptioinList(list);
			
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			
		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return save;

	}
	
	@RequestMapping(value = { "/getGalleryCategoryList" }, method = RequestMethod.GET)
	public @ResponseBody List<GallaryCategory> getGalleryCategoryList() {

		 
		List<GallaryCategory> list = new ArrayList<>();
		try {

			list = gallaryCategoryRepository.findByDelStatus(1); 
			
		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return list;

	}
	
	 @RequestMapping(value = { "/saveGalleryDetails" }, method = RequestMethod.POST)
	public @ResponseBody GallaryDetail saveGalleryDetail(@RequestBody GallaryDetail gallaryDetail) {

		 
		 GallaryDetail save = new GallaryDetail();
		try {

			save = gallaryDetailRepository.save(gallaryDetail);
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);

		} catch (Exception e) {

			e.printStackTrace();
			 
		}
		return save;

	} 
	 
	 @RequestMapping(value = { "/galleryDetailListByCatId" }, method = RequestMethod.POST)
		public @ResponseBody List<GallaryDetail> galleryDetailListByCatId(@RequestParam("catId") int catId,
				@RequestParam("moduleId") String moduleId) {

			 
		 List<GallaryDetail> list = new ArrayList<>();
			try {

				list = gallaryDetailRepository.findByGalleryCatIdAndIsActiveAndDelStatusAndTypeVideoImage(catId,1,1,moduleId);
				 

			} catch (Exception e) {

				e.printStackTrace();
				 
			}
			return list;

		} 
	 
	 @RequestMapping(value = { "/galleryDetailList" }, method = RequestMethod.POST)
		public @ResponseBody List<GallaryDetail> galleryDetailList(@RequestParam("moduleId") String moduleId) {

			 
		 List<GallaryDetail> list = new ArrayList<>();
			try {

				list = gallaryDetailRepository.findByIsActiveAndDelStatusAndTypeVideoImage(1,1,moduleId);
				 

			} catch (Exception e) {

				e.printStackTrace();
				 
			}
			
			return list;

		} 
	 
	 @RequestMapping(value = { "/deleteGalleryDetails" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteGalleryDetails(@RequestParam("galleryDetailsId") int galleryDetailsId) {
			Info infoRes = new Info();
		 try {
		 	String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int isDeleted = gallaryDetailRepository.deleteGalleryDetail(galleryDetailsId);
		
			if (isDeleted >= 1) {
				infoRes.setError(false);
				infoRes.setMsg("Section Deleted Successfully");
			} else {
				infoRes.setError(true);
				infoRes.setMsg("Section Deletion Failed");
			}
		 } catch (Exception e) {

				e.printStackTrace();
				 
			}
			return infoRes;
		}
	 
	 @RequestMapping(value = { "/updateTitleName" }, method = RequestMethod.POST)
		public @ResponseBody Info updateTitleName(@RequestParam("galleryDetailsId") int galleryDetailsId,
				@RequestParam("title") String title,@RequestParam("sortNo") int sortNo) {
		 Info infoRes = new Info();
	 
		 try {
		 String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int update = gallaryDetailRepository.updateTitleName(galleryDetailsId,title,sortNo);
			
			if (update >= 1) {
				infoRes.setError(false);
				infoRes.setMsg("Section Deleted Successfully");
			} else {
				infoRes.setError(true);
				infoRes.setMsg("Section Deletion Failed");
			}
		 } catch (Exception e) {

				e.printStackTrace();
				 
			}
			return infoRes;
		}
	 
	 @RequestMapping(value = { "/deleteGalleryCategory" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteGalleryCategory(@RequestParam("galleryCatId") int galleryCatId) {

			Info infoRes = new Info();
		 try {
		 String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int isDeleted = gallaryCategoryRepository.deleteGalleryCategory(galleryCatId);
		
			if (isDeleted >= 1) {
				infoRes.setError(false);
				infoRes.setMsg("Section Deleted Successfully");
			} else {
				infoRes.setError(true);
				infoRes.setMsg("Section Deletion Failed");
			}
		 } catch (Exception e) {

				e.printStackTrace();
				 
			}
			return infoRes;
		}
	 
	 @RequestMapping(value = { "/getCatName" }, method = RequestMethod.POST)
		public @ResponseBody Info getCatName(@RequestParam("galleryCatId") int galleryCatId,@RequestParam("langId") int langId) {

		 Info info = new Info();
			 
			try {
				 
				
				String catName = gallaryCategoryDescriptioinRepo.getCatName(galleryCatId,langId);
				info.setError(false);
				info.setMsg(catName);
				 
			} catch (Exception e) {
				info.setError(true); 
				e.printStackTrace();
			}
			return info;

		}
	 
	 @RequestMapping(value = { "/getGalleryCatByCatId" }, method = RequestMethod.POST)
		public @ResponseBody GallaryCategory getContractorById(@RequestParam("galleryCatId") int galleryCatId) {

		 GallaryCategory secSaveResponse = new GallaryCategory();
			 
			try {
				secSaveResponse = gallaryCategoryRepository.findByGalleryCatId(galleryCatId); 
				
				List<GallaryCategoryDescriptioin> list = gallaryCategoryDescriptioinRepo.findAllByGalleryCatId(galleryCatId);
				
				secSaveResponse.setGallaryCategoryDescriptioinList(list);
				 
				//String lastdate=LastUpdatedSiteDate.updateDate();			
				//int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
			return secSaveResponse;

		}
	 
	 @RequestMapping(value = { "/findPageModuleByModuleIdAndPageId" }, method = RequestMethod.POST)
		public @ResponseBody PagesModule findPageModuleByModuleIdAndPageId(@RequestParam("pageId") int pageId,
				@RequestParam("moduleId") int moduleId) {

		 PagesModule pagesModule = new PagesModule();
			 
			try {
				pagesModule = pagesModuleRepository.findByModuleIdAndPageId(moduleId,pageId); 
				 if(pagesModule==null) {
					 pagesModule = new PagesModule();
				 }

			} catch (Exception e) {
				 
				e.printStackTrace();
				 pagesModule = new PagesModule();
			}
			return pagesModule;

		}

}
