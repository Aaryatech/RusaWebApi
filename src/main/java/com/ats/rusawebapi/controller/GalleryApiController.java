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
import com.ats.rusawebapi.tx.model.GalleryDetail;
import com.ats.rusawebapi.tx.model.Galleryheader;
import com.ats.rusawebapi.tx.repo.GalleryDetailRepo;
import com.ats.rusawebapi.tx.repo.GalleryHeaderRepo;
import com.ats.rusawebapi.tx.repo.GetGalleryHeader;

@RestController
public class GalleryApiController {

	@Autowired
	GalleryHeaderRepo galleryHeaderRepo;

	@Autowired
	GalleryDetailRepo galleryDetailRepo;

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

	@RequestMapping(value = { "/getGalleryHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<Galleryheader> getDocHeaderList() {

		List<Galleryheader> docHeaderList = new ArrayList<Galleryheader>();

		try {

			docHeaderList = galleryHeaderRepo.findByDelStatus(1);

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
