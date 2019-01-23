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

import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.mst.GetGalleryHeaderRepo;
import com.ats.rusawebapi.tx.model.GalleryDetail;
import com.ats.rusawebapi.tx.model.Galleryheader;
import com.ats.rusawebapi.tx.model.GetGalleryHeaderByCatId;
import com.ats.rusawebapi.tx.repo.GalleryDetailRepo;
import com.ats.rusawebapi.tx.repo.GalleryHeaderRepo;
import com.ats.rusawebapi.tx.repo.GetGalleryHeader;

@RestController
public class GalleryApiController {

	@Autowired
	GalleryHeaderRepo galleryHeaderRepo;

	@Autowired
	GalleryDetailRepo galleryDetailRepo;
	
	@Autowired
	GetGalleryHeaderRepo  getgRepo;

	@RequestMapping(value = { "/saveGalleryHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody Galleryheader saveGalleryHeaderAndDetail(@RequestBody Galleryheader gallery) {

		Info errorMessage = new Info();
		Galleryheader gHeader = new Galleryheader();
		try {

			gHeader = galleryHeaderRepo.save(gallery);

			for (int i = 0; i < gallery.getDetailList().size(); i++) {

				gallery.getDetailList().get(i).setGalleryHeadId(gHeader.getGalleryHeaderId());

			}

			List<GalleryDetail> gDetailsList = galleryDetailRepo.saveAll(gallery.getDetailList());
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
	
	
	@RequestMapping(value = { "/saveGalleryHeader" }, method = RequestMethod.POST)
	public @ResponseBody Galleryheader saveGalleryHeader(@RequestBody Galleryheader gallery) {

		Info errorMessage = new Info();
		Galleryheader gHeader = new Galleryheader();
		try {

			gHeader = galleryHeaderRepo.save(gallery);


		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return gHeader;

	}
	
	@RequestMapping(value = { "/saveGalleryDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<GalleryDetail> saveGalleryDetail(@RequestBody List<GalleryDetail> galDetailList) {

		Info errorMessage = new Info();
		List<GalleryDetail> gDetailsList=null;
		try {

		 gDetailsList = galleryDetailRepo.saveAll(galDetailList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return gDetailsList;

	}

	@RequestMapping(value = { "/getGalleryHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetGalleryHeaderByCatId> getDocHeaderList() {

		List<GetGalleryHeaderByCatId> docHeaderList = new ArrayList<GetGalleryHeaderByCatId>();

		try {

			docHeaderList = getgRepo.getAllGalleryHeaderList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docHeaderList;

	}

	@RequestMapping(value = { "/getGalleryHeaderById" }, method = RequestMethod.POST)
	public @ResponseBody Galleryheader getDocHeaderByTermId(@RequestParam("galleryHeadId") int galleryHeadId) {

		Galleryheader gHeader = new Galleryheader();

		try {

			gHeader = galleryHeaderRepo.findByGalleryHeaderIdAndDelStatus(galleryHeadId, 1);
			List<GalleryDetail> detailList = galleryDetailRepo.findByGalleryHeadIdAndDelStatus(galleryHeadId, 1);
			gHeader.setDetailList(detailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return gHeader;

	}
	
	
	@RequestMapping(value = { "/getGalleryHeaderByCatIdAndSubCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGalleryHeaderByCatId> getGalleryHeaderByCatId(@RequestParam("catIdList") List<Integer> catIdList,@RequestParam("subCatIdList") List<Integer> subCatIdList) {

		List<GetGalleryHeaderByCatId> gHeaderList =null;

		try {
			
			if(catIdList.contains(0) && !subCatIdList.contains(0)) {
				gHeaderList = getgRepo.findBySubCatId(subCatIdList);
				
			}else if(!catIdList.contains(0) && subCatIdList.contains(0)) {

				gHeaderList = getgRepo.findByCatId(catIdList);
			}
			else if(!catIdList.contains(0) && !subCatIdList.contains(0)) {

			gHeaderList = getgRepo.findByCatId1(catIdList,subCatIdList);
			}
			else  {
				gHeaderList = getgRepo.find();
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		return gHeaderList;

	}

	
	
	@RequestMapping(value = { "/deleteGalleryHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteGalleryHeader(@RequestParam("galleryHeadId") int galleryHeadId) {

		Info info = new Info();

		try {
			int delete = galleryHeaderRepo.deleteGalleryHeader(galleryHeadId);

			if (delete == 1) {
				info.setError(false);
				info.setMsg("successfully Deleted");
			} else {
				info.setError(true);
				info.setMsg(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/deleteMultiGalleryHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiGalleryHeader(@RequestParam("galleryHeadIds") List<Integer> galleryHeadIds) {

		Info info = new Info();

		try {
			int delete = galleryHeaderRepo.deleteMultiGalleryHeader(galleryHeadIds);

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
			info.setMsg(" Deleted to Delete");

		}
		return info;

	}
	
	
	@RequestMapping(value = { "/activeInactiveGalleryHeaders" }, method = RequestMethod.POST)
	public @ResponseBody Info activeInactiveSections(@RequestParam("galleryHeadIds") List<String> galleryHeadIds,
			@RequestParam("isActive") int isActive) {

		Info info = new Info();

		try {

			int deleteRes = galleryHeaderRepo.activeInactiveGalleryHeaders(galleryHeadIds, isActive);

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
			System.err.println("Exce in activeInactiveGalleryHeaders @GalleryApicontr " + e.getMessage());
			e.printStackTrace();

		}

		return info;

	}
	
	
	@RequestMapping(value = { "/deleteGalleryDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteGalleryDetail(@RequestParam("galleryDetailId") int galleryDetailId) {

		Info info = new Info();

		try {
			int delete = galleryDetailRepo.deleteGalleryDetail(galleryDetailId);

			if (delete == 1) {
				info.setError(false);
				info.setMsg("successfully Deleted");
			} else {
				info.setError(true);
				info.setMsg(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg(" Deleted to Delete");

		}
		return info;

	}
	
	

	/*
	 * @RequestMapping(value = { "/getAllGalleryHeaderList" }, method =
	 * RequestMethod.GET) public @ResponseBody List<Galleryheader>
	 * getAllDocHeaderList() {
	 * 
	 * List<GetGalleryHeader> docHeaderList = new ArrayList<GetGalleryHeader>();
	 * 
	 * try {
	 * 
	 * docHeaderList = galleryHeaderRepo.getDocHeaderList();
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } return docHeaderList;
	 * 
	 * }
	 */
	
	
}
