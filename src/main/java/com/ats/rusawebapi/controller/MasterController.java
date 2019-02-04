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

import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.mst.Category;
import com.ats.rusawebapi.model.mst.CategoryDescription;
import com.ats.rusawebapi.model.mst.FreqAskQue;
import com.ats.rusawebapi.model.mst.FreqAskQueDescription;
import com.ats.rusawebapi.model.mst.GetCategory;
import com.ats.rusawebapi.model.mst.GetFreqAskQue;
import com.ats.rusawebapi.model.mst.GetSubCategory;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.SubCategory;
import com.ats.rusawebapi.repo.CatDescRepo;
import com.ats.rusawebapi.repo.FreqAskQueDescriptionRepo;
import com.ats.rusawebapi.repo.PageRepo;
import com.ats.rusawebapi.repo.mst.CategoryRepo;
import com.ats.rusawebapi.repo.mst.FreqAskQueRepo;
import com.ats.rusawebapi.repo.mst.GetCategoryRepo;
import com.ats.rusawebapi.repo.mst.GetSubCategoryRepo;
import com.ats.rusawebapi.repo.mst.SubCategoryRepo;
import com.ats.rusawebapi.tx.repo.GetFreqAskQueRepo;

@RestController
public class MasterController {

	@Autowired CategoryRepo catRepo;
	
	@Autowired 
	CatDescRepo catDescRepo;
	
	@Autowired SubCategoryRepo subCatRepo;
	@Autowired FreqAskQueRepo freqAskQueRepo;
	@Autowired GetCategoryRepo getGetCategoryRepo;
	@Autowired GetFreqAskQueRepo getGetFreqAskQueRepo;
	
	@Autowired GetSubCategoryRepo getGetSubCategoryRepo;
	
	@Autowired
	PageRepo pageRepo;
	
	@Autowired
	FreqAskQueDescriptionRepo freqAskQueDescriptionRepo;
	
	@RequestMapping(value = { "/getFreqAskQueList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFreqAskQue> getFreqAskQueList(@RequestParam("delStatus") int delStatus) {

		List<GetFreqAskQue> faqList = null;

		try {

			faqList = getGetFreqAskQueRepo.getFaqList(delStatus);

			System.out.println(faqList);
		} catch (Exception e) {
			System.err.println("Exce in getFreqAskQueList @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return faqList;

	}
	
	@RequestMapping(value = { "/getFreqAskQue" }, method = RequestMethod.POST)
	public @ResponseBody GetFreqAskQue getFreqAskQue(@RequestParam("faqId") int faqId) {

		GetFreqAskQue faq=null;

		try {

			faq = getGetFreqAskQueRepo.getFaq(faqId);

		//	System.out.println(faqList);
		} catch (Exception e) {
			System.err.println("Exce in getFreqAskQue @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return faq;

	}
	
	
	@RequestMapping(value = { "/deleteFaq" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteFaq(@RequestParam("delStatus") int delStatus,
			@RequestParam("faqIdList") List<String> faqIdList) {

		Info info = new Info();

		try {

			int deleteRes = freqAskQueRepo.deleteFaqs(faqIdList, delStatus);
			if (deleteRes > 0) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}

		} catch (Exception e) {
			
			System.err.println("Exce in deleteFaq @Mastercontr " + e.getMessage());
			e.printStackTrace();
			
		}

		return info;

	}
	
	
	
	@RequestMapping(value = { "/getAllCatList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCategory> getAllCatList(@RequestParam("delStatus") int delStatus) {

		List<GetCategory> catList = null;

		try {

			catList = getGetCategoryRepo.getAllCatList(delStatus);

			System.out.println(catList);
		} catch (Exception e) {
			System.err.println("Exce in getAllCatList @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return catList;

	}
	
	@RequestMapping(value = { "/getSubCatList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCategory> getSubCatList(@RequestParam("delStatus") int delStatus) {

		List<GetCategory> catList = null;

		try {

			catList = getGetCategoryRepo.getSubCatList(delStatus);

			System.out.println(catList);
		} catch (Exception e) {
			System.err.println("Exce in getAllCatList @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return catList;

	}
	
	
	@RequestMapping(value = { "/getAllSubCatList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSubCategory> getAllSubCatList(@RequestParam("delStatus") int delStatus) {

		List<GetSubCategory> subCatList = null;

		try {

			subCatList = getGetSubCategoryRepo.getSubAllSubCatList(delStatus);
			
		} catch (Exception e) {
			System.err.println("Exce in getAllCatList @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return subCatList;

	}

	 
	@RequestMapping(value = { "/getAllCatIdBySectionId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCategory> getAllCatIdBySectionId(@RequestParam("sectionId") int sectionId) {

		List<GetCategory> catList1 = null;

		try {

			catList1 = getGetCategoryRepo.getAllCatIdBySectionId(sectionId);

			System.out.println(catList1);
		} catch (Exception e) {
			System.err.println("Exce in getAllCatList @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return catList1;

	}

	@RequestMapping(value = { "/getAllSubCatByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSubCategory> getAllSubCatByCatId(@RequestParam("delStatus") int delStatus,
			@RequestParam("catId") int catId) {

		List<GetSubCategory> subCatList = null;
		try {

			subCatList = getGetSubCategoryRepo.getAllSubCatByCatId(delStatus, catId);
			
		} catch (Exception e) {
			System.err.println("Exce in getAllSubCatByCatId @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return subCatList;

	}

	@RequestMapping(value = { "/getSubCategoryBySubCatId" }, method = RequestMethod.POST)
	public @ResponseBody GetSubCategory getSubCategoryBySubCatId(@RequestParam("delStatus") int delStatus,@RequestParam("subCatId") int subCatId) {

		GetSubCategory subCat = new GetSubCategory();

		try {

			subCat = getGetSubCategoryRepo.getSubCategory(delStatus, subCatId);
			
		} catch (Exception e) {
			System.err.println("Exce in getSubCategoryBySubCatId @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return subCat;

	}

	
	
	//for getAllCatListByCatId
	
	@RequestMapping(value = { "/getCategoryByCatId" }, method = RequestMethod.POST)
	public @ResponseBody  GetCategory  getCategoryByCatId(@RequestParam("catId") int catId) {

		GetCategory gcetCategory = new GetCategory();

		try {

			gcetCategory = getGetCategoryRepo.getCatListByCatId(catId);
			List<CategoryDescription> CategoryDescriptionList=catDescRepo.findByCatId(gcetCategory.getCatId());
			gcetCategory.setCategoryDescriptionList(CategoryDescriptionList);
		} catch (Exception e) {
			System.err.println("Exce in getAllCatList @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return gcetCategory;

	}
	
//Category -1
	 @RequestMapping(value = { "/saveUpdateCategory" }, method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@RequestBody Category category) {

		Category catSaveResponse = new Category();
	 
		try {

			catSaveResponse = catRepo.saveAndFlush(category); 
			
			for(int i=0 ; i<category.getCategoryDescriptionList().size() ; i++) {
				
				category.getCategoryDescriptionList().get(i).setCatId(catSaveResponse.getCatId());
			}
			
			List<CategoryDescription> CategoryDescriptionList=catDescRepo.saveAll(category.getCategoryDescriptionList());
			catSaveResponse.setCategoryDescriptionList(CategoryDescriptionList);
			
			
			Page pageByPageId = new Page();
			
			if(category.getExInt2()!=0) {
				
				pageByPageId = pageRepo.findByPageId(category.getExInt2());
				pageByPageId.setPageName(category.getCatName());
				if(category.getParentId()==0) {
					pageByPageId.setTypeSecCate("cat");
				}else {
					pageByPageId.setTypeSecCate("subcat");
				}
				pageByPageId.setSecCateId(catSaveResponse.getCatId());
		 
			}else {
				 
				pageByPageId.setPageName(category.getCatName());
				if(category.getParentId()==0) {
					pageByPageId.setTypeSecCate("cat");
				}else {
					pageByPageId.setTypeSecCate("subcat");
				}
				pageByPageId.setSecCateId(catSaveResponse.getCatId());
				Page save = pageRepo.saveAndFlush(pageByPageId);
				category.setExInt2(save.getPageId());
			}
			
			String str = category.getSlugName()+category.getExInt2(); 
			int count = catRepo.updateSlugName(catSaveResponse.getCatId(),str,category.getExInt2());
			
			pageByPageId.setPageSlug(str);
			Page save = pageRepo.saveAndFlush(pageByPageId);
		} catch (Exception e) {

			 
			e.printStackTrace();
		}

		return catSaveResponse;

	} 
	//Category -2

	@RequestMapping(value = { "/getAllCategory" }, method = RequestMethod.POST)
	public @ResponseBody List<Category> getAllCategory(@RequestParam("delStatus") int delStatus) {

		List<Category> catList = null;

		try {

			catList = catRepo.findByDelStatus(delStatus);

		} catch (Exception e) {
			System.err.println("Exce in getAllCategory @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return catList;

	}
	//Category -3
	@RequestMapping(value = { "/deleteMultiCategory" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCategory(@RequestParam("delStatus") int delStatus,
			@RequestParam("catIdList") List<String> catIdList) {

		Info info = new Info();

		try {

			int deleteRes = catRepo.deleteCategory(catIdList, delStatus);

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
		@RequestMapping(value = { "/activeInactiveCategories" }, method = RequestMethod.POST)
		public @ResponseBody Info activeInactiveCategories(@RequestParam("isActive") int isActive,
				@RequestParam("catIdList") List<String> catIdList) {

			Info info = new Info();

			try {

				int deleteRes = catRepo.activeInactiveCategory(catIdList, isActive);

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
				System.err.println("Exce in activeInactiveCategories @Mastercontr " + e.getMessage());
				e.printStackTrace();
				
			}

			return info;

		}
		
		//SubCategory -1
		@RequestMapping(value = { "/saveUpdateSubCategory" }, method = RequestMethod.POST)
		public @ResponseBody SubCategory saveUpdateSubCategory(@RequestBody SubCategory subCategory) {

			SubCategory subCatSaveResponse = null;
			Info info = new Info();
			try {

				subCatSaveResponse = subCatRepo.saveAndFlush(subCategory);

				if (subCatSaveResponse != null) {

					info.setError(false);
					info.setMsg("success");

				} else {

					info.setError(true);
					info.setMsg("failed");
				}

				subCatSaveResponse.setInfo(info);

			} catch (Exception e) {

				info.setError(true);
				info.setMsg("exception");

				subCatSaveResponse = new SubCategory();

				subCatSaveResponse.setInfo(info);

				System.err.println("Exce in saveUpdateSubCategory @MasterController " + e.getMessage());
				e.printStackTrace();
			}

			return subCatSaveResponse;

		}
		
		//SubCategory -2
		
		@RequestMapping(value = { "/getSubCategoriesByCatIds" }, method = RequestMethod.POST)
		public @ResponseBody List<SubCategory> getSubCategoriesByCatIds(@RequestParam("delStatus") int delStatus,
				@RequestParam("catIdList") List<Integer> catIdList) {

			List<SubCategory> subCatList = null;

			try {

				subCatList = subCatRepo.findByCatIdInAndDelStatus(catIdList, delStatus);

			} catch (Exception e) {
				System.err.println("Exce in getSubCategoriesByCatIds @Mastercontr " + e.getMessage());
				e.printStackTrace();
			}

			return subCatList;

		}
		
		
		//SubCategory -3
		@RequestMapping(value = { "/getAllSubCategories" }, method = RequestMethod.POST)
		public @ResponseBody List<SubCategory> getAllSubCategories(@RequestParam("delStatus") int delStatus) {

			List<SubCategory> subCatList = null;

			try {

				subCatList = subCatRepo.findByDelStatus(delStatus);
			} catch (Exception e) {
				System.err.println("Exce in getSubCategoriesByCatIds @Mastercontr " + e.getMessage());
				e.printStackTrace();
			}

			return subCatList;

		}
		
		
	//SubCategory -4
	
	@RequestMapping(value = { "/deleteMultiSubCategory" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiSubCategory(@RequestParam("delStatus") int delStatus,
			@RequestParam("subCatIdList") List<String> subCatIdList) {

		Info info = new Info();

		try {

			int deleteRes = subCatRepo.deleteSubCategory(subCatIdList, delStatus);

			if (deleteRes > 0) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}

		} catch (Exception e) {
			
			System.err.println("Exce in deleteMultiSubCategory @Mastercontr " + e.getMessage());
			e.printStackTrace();
			
		}

		return info;

	}
	//SubCategory -5
	
	@RequestMapping(value = { "/activeInactiveSubCategories" }, method = RequestMethod.POST)
	public @ResponseBody Info activeInactiveSubCategories(@RequestParam("isActive") int isActive,
			@RequestParam("subCatIdList") List<String> subCatIdList) {

		Info info = new Info();

		try {

			int deleteRes = subCatRepo.activeInactiveSubCategory(subCatIdList, isActive);

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
			
			System.err.println("Exce in deleteMultiSubCategory @Mastercontr " + e.getMessage());
			e.printStackTrace();
			
		}

		return info;

	}

	
	//FreqAskQue -1
	@RequestMapping(value = { "/saveUpdateFreqAskQue" }, method = RequestMethod.POST)
	public @ResponseBody FreqAskQue saveUpdateFreqAskQue(@RequestBody FreqAskQue faq) {

		FreqAskQue faqSaveResponse = new FreqAskQue();
	 
		try {

			faqSaveResponse = freqAskQueRepo.saveAndFlush(faq);
 
			for(int i = 0 ; i<faq.getDescriptionList().size() ; i++) {
				
				faq.getDescriptionList().get(i).setFaqId(faqSaveResponse.getFaqId());
			}
			
			List<FreqAskQueDescription> list = freqAskQueDescriptionRepo.saveAll(faq.getDescriptionList());
			faqSaveResponse.setDescriptionList(list);
			

		} catch (Exception e) {

			 
			e.printStackTrace();
		}

		return faqSaveResponse;

	}
	
	@RequestMapping(value = { "/getFaqById" }, method = RequestMethod.POST)
	public @ResponseBody FreqAskQue getFaqById(@RequestParam("faqId") int faqId) {

		FreqAskQue faqSaveResponse = new FreqAskQue();
	 
		try {

			faqSaveResponse = freqAskQueRepo.findByFaqId(faqId); 
			List<FreqAskQueDescription> list = freqAskQueDescriptionRepo.findByFaqId(faqId);
			faqSaveResponse.setDescriptionList(list);
			

		} catch (Exception e) {

			 
			e.printStackTrace();
		}

		return faqSaveResponse;

	}
	/*//FreqAskQue -2
	@RequestMapping(value = { "/getAllFreqAskQue" }, method = RequestMethod.POST)
	public @ResponseBody List<FreqAskQue> getAllFreqAskQue(@RequestParam("delStatus") int delStatus) {

		List<FreqAskQue> faqList = null;
		
		try {
			faqList=freqAskQueRepo.findByDelStatus(delStatus);
			
		}catch (Exception e) {
			System.err.println("Exce in getAllFreqAskQue @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return faqList;
	}*/
	//FreqAskQue -3
	@RequestMapping(value = { "/getFreqAskQueByCatIdsAndSubCatIds" }, method = RequestMethod.POST)
	public @ResponseBody List<FreqAskQue> getFreqAskQueByCatIdsAndSubCatIds(@RequestParam("delStatus") int delStatus) {

		List<FreqAskQue> faqList = new ArrayList<FreqAskQue>();
		
		try {
			
			 
				
				faqList=freqAskQueRepo.findByDelStatus(delStatus);

			 
			
		}catch (Exception e) {
			 
			e.printStackTrace();
		}

		return faqList;
	}
	
	/*//FreqAskQue -4
	@RequestMapping(value = { "/getFreqAskQueBySubCatIds" }, method = RequestMethod.POST)
	public @ResponseBody List<FreqAskQue> getFreqAskQueBySubCatIds(
			@RequestParam("subCatIdList") List<String> subCatIdList,@RequestParam("delStatus") int delStatus) {

		List<FreqAskQue> faqList = null;
		
		try {
			
			faqList=freqAskQueRepo.findBySubCatIdInAndDelStatus(subCatIdList, delStatus);
			
		}catch (Exception e) {
			System.err.println("Exce in getFreqAskQueBySubCatIds @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return faqList;
	}
	
	//FreqAskQue -5
	@RequestMapping(value = { "/getFreqAskQueByCatIds" }, method = RequestMethod.POST)
	public @ResponseBody List<FreqAskQue> getFreqAskQueByCatIds(
			@RequestParam("catIdList") List<String> catIdList,@RequestParam("delStatus") int delStatus) {

		List<FreqAskQue> faqList = null;
		
		try {
			
			faqList=freqAskQueRepo.findByCatIdInAndDelStatus(catIdList, delStatus);
			
		}catch (Exception e) {
			System.err.println("Exce in getFreqAskQueByCatIds @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return faqList;
	}*/
}
