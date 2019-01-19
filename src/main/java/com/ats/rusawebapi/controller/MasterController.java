package com.ats.rusawebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.model.mst.Category;
import com.ats.rusawebapi.model.mst.FreqAskQue;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.SubCategory;
import com.ats.rusawebapi.repo.mst.CategoryRepo;
import com.ats.rusawebapi.repo.mst.FreqAskQueRepo;
import com.ats.rusawebapi.repo.mst.SubCategoryRepo;

@RestController
public class MasterController {

	@Autowired
	CategoryRepo catRepo;
	@Autowired
	SubCategoryRepo subCatRepo;
	@Autowired
	FreqAskQueRepo freqAskQueRepo;
	
//Category -1
	@RequestMapping(value = { "/saveUpdateCategory" }, method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@RequestBody Category category) {

		Category catSaveResponse = null;
		Info info = new Info();
		try {

			catSaveResponse = catRepo.saveAndFlush(category);

			if (catSaveResponse != null) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}

			catSaveResponse.setInfo(info);

		} catch (Exception e) {

			info.setError(true);
			info.setMsg("exception");

			catSaveResponse = new Category();

			catSaveResponse.setInfo(info);

			System.err.println("Exce in saveUpdateCategory @MasterController " + e.getMessage());
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
				@RequestParam("catIdList") List<String> catIdList) {

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

		FreqAskQue faqSaveResponse = null;
		Info info = new Info();
		try {

			faqSaveResponse = freqAskQueRepo.saveAndFlush(faq);

			if (faqSaveResponse != null) {

				info.setError(false);
				info.setMsg("success");

			} else {

				info.setError(true);
				info.setMsg("failed");
			}

			faqSaveResponse.setInfo(info);

		} catch (Exception e) {

			info.setError(true);
			info.setMsg("exception");

			faqSaveResponse = new FreqAskQue();

			faqSaveResponse.setInfo(info);

			System.err.println("Exce in saveUpdateFreqAskQue @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return faqSaveResponse;

	}
	//FreqAskQue -2
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
	}
	//FreqAskQue -3
	@RequestMapping(value = { "/getFreqAskQueByCatIdsAndSubCatIds" }, method = RequestMethod.POST)
	public @ResponseBody List<FreqAskQue> getFreqAskQueByCatIdsAndSubCatIds(@RequestParam("catIdList") List<String> catIdList,
			@RequestParam("subCatIdList") List<String> subCatIdList,@RequestParam("delStatus") int delStatus) {

		List<FreqAskQue> faqList = null;
		
		try {
			
			faqList=freqAskQueRepo.findByCatIdInAndSubCatIdInAndDelStatus(catIdList, subCatIdList, delStatus);
			
		}catch (Exception e) {
			System.err.println("Exce in getFreqAskQueByCatIdsAndSubCatIds @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return faqList;
	}
}
