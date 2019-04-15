package com.ats.rusawebapi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ats.rusawebapi.common.LastUpdatedSiteDate;
import com.ats.rusawebapi.model.CategoryList;
import com.ats.rusawebapi.model.Languages;
import com.ats.rusawebapi.model.LoginLogs;
import com.ats.rusawebapi.model.LoginResponse;
import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.SectionDescription;
import com.ats.rusawebapi.model.SectionTree;
import com.ats.rusawebapi.model.SubCategoryList;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.model.mst.User;
import com.ats.rusawebapi.repo.CategoryListRepository;
import com.ats.rusawebapi.repo.LanguagesRepository;
import com.ats.rusawebapi.repo.LoginLogsRepo;
import com.ats.rusawebapi.repo.PageRepo;
import com.ats.rusawebapi.repo.SecDescRepo;
import com.ats.rusawebapi.repo.SectionTreeRepository;
import com.ats.rusawebapi.repo.SettingRepo;
import com.ats.rusawebapi.repo.SubCategoryListRepository;
import com.ats.rusawebapi.repo.mst.SectionRepo;
import com.ats.rusawebapi.repo.mst.UserRepo;

@RestController
public class MasterApiController {

	@Autowired
	SectionRepo secRepo;
	
	@Autowired
	SecDescRepo secDescRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	SettingRepo settingRepository; 
	
	@Autowired
	LoginLogsRepo loginLogsRepo;
	
	@Autowired
	LanguagesRepository languagesRepository;

	@Autowired
	PageRepo pageRepo;
	
	@Autowired
	SectionTreeRepository sectionTreeRepository;
	
	@Autowired
	CategoryListRepository categoryListRepository;
	
	@Autowired
	SubCategoryListRepository subCategoryListRepository;
	// --------------------------------------Section-------------------------

	@RequestMapping(value = { "/loginResponse" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponse loginResponse(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {

		User user = new User();
		LoginResponse loginResponse = new LoginResponse();
		try {
			
			//user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			user = userRepo.findByUserNameAndDelStatusAndIsActive(userName, 1,1);
			
			if (user != null) {
 
				User user1 = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);
				if (user1 != null) {
					loginResponse.setError(false);
					loginResponse.setMsg("Login Sucess ");
					loginResponse.setUser(user);
				}
				else {
					
					int updateDate = userRepo.updateCount(user.getLoginFailureCount()+1,user.getUserId());
					loginResponse.setError(true);
					loginResponse.setMsg("password Wrong");
				}
				
				
			} else {

				loginResponse.setError(true);
				loginResponse.setMsg("Invalid Credencials");
			}
			 

		} catch (Exception e) {
			loginResponse.setError(true);
			loginResponse.setMsg("exception");
			 
			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}
		return loginResponse;

	}
	
	@RequestMapping(value = { "/saveLoginLogs" }, method = RequestMethod.POST)
	public @ResponseBody LoginLogs saveLoginLogs(@RequestBody LoginLogs loginLogs) {

		 
		LoginLogs save = new LoginLogs();
		try {
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
			
			loginLogs.setCreatedDate(date);
			save = loginLogsRepo.saveAndFlush(loginLogs);
 
			//int updateDate = userRepo.updateLastLoginDate(sf.format(date),loginLogs.getUserId());

		} catch (Exception e) {
 
			e.printStackTrace();
		}

		return save;

	}
	
	
	@RequestMapping(value = { "/getLanguageList" }, method = RequestMethod.GET)
	public @ResponseBody List<Languages> getLanguageList() {

		List<Languages> list = new ArrayList<>();
		 
		try {

			list = languagesRepository.findByIsActiveOrderBySortOrder(1);
 

		} catch (Exception e) {
 
		}

		return list;

	}
	
	@RequestMapping(value = { "/saveSection" }, method = RequestMethod.POST)
	public @ResponseBody Section saveSection(@RequestBody Section section) {

		Section secSaveResponse = new Section();
		 
		try {
			 
			
			secSaveResponse = secRepo.saveAndFlush(section); 
			 
			for(int i = 0 ; i<section.getSectionDescriptionList().size() ; i++) {
				
				section.getSectionDescriptionList().get(i).setSectionId(secSaveResponse.getSectionId());
			}
			
			List<SectionDescription> list = secDescRepo.saveAll(section.getSectionDescriptionList());
			secSaveResponse.setSectionDescriptionList(list);
			
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
			int count = secRepo.updateSlugName(secSaveResponse.getSectionId(),str,pageByPageId.getPageId());
			pageByPageId.setPageSlug(str);
			Page save = pageRepo.saveAndFlush(pageByPageId);
			
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);

		} catch (Exception e) {

			 
			e.printStackTrace();
		}

		return secSaveResponse;

	}

	@RequestMapping(value = { "/getPageByPageId" }, method = RequestMethod.POST)
	public @ResponseBody Page getPageByPageId(@RequestParam("pageId") int pageId) {

		Page page = new Page();
		 
		try {
			page = pageRepo.findByPageId(pageId);
			  

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return page;

	}
	
	@RequestMapping(value = { "/savePage" }, method = RequestMethod.POST)
	public @ResponseBody Page savePage(@RequestBody Page page) {

		Page save = new Page();
		 
		try {
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			save = pageRepo.save(page);
			  

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return save;

	}
	
	@RequestMapping(value = { "/getSectionBySectionId" }, method = RequestMethod.POST)
	public @ResponseBody Section getContractorById(@RequestParam("sectionId") int sectionId) {

		Section secSaveResponse = new Section();
		 
		try {
			secSaveResponse = secRepo.findBySectionIdAndDelStatus(sectionId, 1); 
			List<SectionDescription> list = secDescRepo.findAllBySectionId(sectionId);
			
			secSaveResponse.setSectionDescriptionList(list);
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;

	}

	@RequestMapping(value = { "/getAllSectionList" }, method = RequestMethod.GET)
	public @ResponseBody List<Section> getAllSectionList() {

		List<Section> conList = new ArrayList<Section>();

		try {

			conList = secRepo.getDelStatusOrderBySectionSortNo();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}
	
	@RequestMapping(value = { "/getCountForSlugName" }, method = RequestMethod.POST)
	public @ResponseBody Info getCountForSlugName(@RequestParam("str") String str) {

		Info info = new Info();

		try {

			int count = secRepo.getCountForSlugName(str);
			info.setError(false);
			info.setMsg(String.valueOf(count));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return info;

	}
	
	/*@RequestMapping(value = { "/updateSlugName" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSlugName(@RequestParam("sectionId") int sectionId) {

		Info info = new Info();

		try {
			String newStr="";
			int count = secRepo.updateSlugName(sectionId);
			info.setError(false);
			info.setMsg("");

		} catch (Exception e) {

			e.printStackTrace();

		}
		return info;

	}*/

	@RequestMapping(value = { "/deleteSection" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSection(@RequestParam("sectionId") int sectionId) {
		Info infoRes = new Info();
		try {
		String lastdate=LastUpdatedSiteDate.updateDate();			
		int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
		int isDeleted = secRepo.deleteSection(sectionId);
	
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

	@RequestMapping(value = { "/deleteMultiSection" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiSection(@RequestParam("sectionIds") List<Integer> sectionIds) {

		Info info = new Info();

		try {
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int delete = secRepo.deleteMultiContDetail(sectionIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMsg("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMsg(" Failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg(" Failed to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/activeInactiveSections" }, method = RequestMethod.POST)
	public @ResponseBody Info activeInactiveSections(@RequestParam("sectionIdList") List<String> sectionIdList,
			@RequestParam("isActive") int isActive) {

		Info info = new Info();

		try {
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int deleteRes = secRepo.activeInactiveSection(sectionIdList, isActive);

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
			System.err.println("Exce in activeInactiveSections @MasterApicontr " + e.getMessage());
			e.printStackTrace();

		}

		return info;

	}

	

	// --------------------------------------User-------------------------

	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public @ResponseBody User saveUser(@RequestBody User usr) {

		User secSaveResponse = new User();
		Info info = new Info();
		try {

			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			secSaveResponse = userRepo.saveAndFlush(usr);

			if (secSaveResponse != null) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}
			 

		} catch (Exception e) {

			info.setError(true);
			info.setMsg("exception");
			secSaveResponse = new User();
			  
			System.err.println("Exce in saveUser @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return secSaveResponse;

	}
	
	
	@RequestMapping(value = { "/getUserByUserId" }, method = RequestMethod.POST)
	public @ResponseBody User getUserByUserId(@RequestParam("userId") int userId) {

		User secSaveResponse = new User();
		Info info = new Info();
		try {
		
			secSaveResponse = userRepo.findByUserIdAndDelStatus(userId, 1);

			if (secSaveResponse != null) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}
			 

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("exception");
			secSaveResponse = new User();
			 

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}
		return secSaveResponse;

	}
	
	
	
	@RequestMapping(value = { "/getAllUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUserList() {

		List<User> conList = new ArrayList<User>();

		try {
  
			conList = userRepo.findByDelStatusAndRolesIsNotOrderByUserIdAsc(1,"DA");

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteUser(@RequestParam("userId") int userId) {

		int isDeleted = userRepo.deleteUser(userId);
		Info infoRes = new Info();
		try {
		String lastdate=LastUpdatedSiteDate.updateDate();			
		int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("User Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("User Deletion Failed");
		}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return infoRes;
	}

	@RequestMapping(value = { "/deleteMultiUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiUser(@RequestParam("userIds") List<Integer> userIds) {

		Info info = new Info();

		try {
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int delete = userRepo.deleteMultiUser(userIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMsg("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMsg(" Failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg(" Failed to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/activeInactiveUsers" }, method = RequestMethod.POST)
	public @ResponseBody Info activeInactiveUsers(@RequestParam("userIdList") List<String> userIdList,
			@RequestParam("isActive") int isActive) {

		Info info = new Info();

		try {
			String lastdate=LastUpdatedSiteDate.updateDate();			
			int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
			int deleteRes = userRepo.activeInactiveUser(userIdList, isActive);

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
			System.err.println("Exce in activeInactiveUsers @MasterApicontr " + e.getMessage());
			e.printStackTrace();

		}

		return info;

	}

	
	@RequestMapping(value = { "/getSectionTreeStructure" }, method = RequestMethod.GET)
	public @ResponseBody List<SectionTree> getSectionTreeStructure( ) {

		List<SectionTree> list = new ArrayList<SectionTree>();

		try {

			list = sectionTreeRepository.getSectionTreeStructure();

			for(int i = 0 ; i < list.size() ; i++) {
				
				List<CategoryList> categoryList = categoryListRepository.getCategoryList(list.get(i).getSectionId());
				
				for(int j = 0 ; j<categoryList.size() ; j++ ) {
					
					List<SubCategoryList> subCategoryList = subCategoryListRepository.getSubCategoryList(categoryList.get(j).getCatId());
					categoryList.get(j).setSubCatList(subCategoryList);
				}
				list.get(i).setCatList(categoryList);
			}
			 

		} catch (Exception e) {
			 
			e.printStackTrace();

		}

		return list;

	}
	//==========================================Android=======================================================//
	  public static String path="http://tomcat.aaryatechindia.in:6435/media/pdf/";
	    

	    @RequestMapping(value = { "/docUpload" }, method = RequestMethod.POST)
	    public @ResponseBody Info docUpload(@RequestParam("file") MultipartFile uploadfile,
	            @RequestParam("docName") String docName) {

	        //System.err.println(" no  of files to push " + uploadfile.length);
	        Info info = new Info();

	        try {
	        	String lastdate=LastUpdatedSiteDate.updateDate();			
	    		int updateLastDate = settingRepository.updateWebSiteDate(lastdate);
	            saveUploadedFiles(uploadfile, path, docName);

	            info.setError(false);
	            info.setMsg("File uploaded successfully");

	        } catch (IOException e) {

	            e.printStackTrace();
	            info.setError(true);
	            info.setMsg("File upload failed");
	        }

	        return info;
	    }
	    

	    public void saveUploadedFiles(MultipartFile file, String filePath, String imageName) throws IOException {

	        Path path = Paths.get(filePath + imageName);

	        byte[] bytes = file.getBytes();

	         
	            System.out.println("Inside Image Type =1");

	            path = Paths.get(filePath + imageName);

	            System.out.println("Path= " + path.toString());


	        Files.write(path, bytes);

	    }
	
	/*@RequestMapping(value = { "/getSectionListByLangId" }, method = RequestMethod.POST)
	public @ResponseBody List<SectionTree> getSectionListByLangId(@RequestParam("langId") int langId) {

		List<SectionTree> list = new ArrayList<SectionTree>();

		try {

			list = sectionTreeRepository.getSectionListByLangId(langId);
 
			for(int i = 0 ; i < list.size() ; i++) {
				
				List<CategoryList> categoryList = categoryListRepository.getCategoryListByLangId(list.get(i).getSectionId(),langId);
				
				for(int j = 0 ; j<categoryList.size() ; j++ ) {
					
					List<SubCategoryList> subCategoryList = subCategoryListRepository.getSubCategoryListByLangId(categoryList.get(j).getCatId(),langId);
					categoryList.get(j).setSubCatList(subCategoryList);
				}
				list.get(i).setCatList(categoryList);
			} 
			 

		} catch (Exception e) {
			 
			e.printStackTrace();

		}

		return list;

	}*/
	
	
/*	@RequestMapping(value = { "/getUserByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody Info getUserByTypeId(@RequestParam("typeId") int typeId) {

		User secSaveResponse = null;
		Info info = new Info();
		try {
			secSaveResponse = userRepo.findByTypeIdAndDelStatus(typeId, 1);

			if (secSaveResponse != null) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}
			secSaveResponse.setInfo(info);

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("exception");
			secSaveResponse = new User();
			secSaveResponse.setInfo(info);

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}
		return info;

	}
	
	
	*/


}
