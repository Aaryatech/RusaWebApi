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
import com.ats.rusawebapi.model.mst.Section;
import com.ats.rusawebapi.model.mst.User;
import com.ats.rusawebapi.repo.mst.SectionRepo;
import com.ats.rusawebapi.repo.mst.UserRepo;

@RestController
public class MasterApiController {

	@Autowired
	SectionRepo secRepo;
	
	@Autowired
	UserRepo userRepo;
	
	

	// --------------------------------------Section-------------------------

	@RequestMapping(value = { "/saveSection" }, method = RequestMethod.POST)
	public @ResponseBody Info saveSection(@RequestBody Section section) {

		Section secSaveResponse = null;
		Info info = new Info();
		try {

			secSaveResponse = secRepo.saveAndFlush(section);

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
			secSaveResponse = new Section();
			secSaveResponse.setInfo(info);

			System.err.println("Exce in saveUpdateSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getSectionBySectionId" }, method = RequestMethod.POST)
	public @ResponseBody Info getContractorById(@RequestParam("sectionId") int sectionId) {

		Section secSaveResponse = null;
		Info info = new Info();
		try {
			secSaveResponse = secRepo.findBySectionIdAndDelStatus(sectionId, 1);

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
			secSaveResponse = new Section();
			secSaveResponse.setInfo(info);

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = { "/getAllSectionList" }, method = RequestMethod.GET)
	public @ResponseBody List<Section> getAllSectionList() {

		List<Section> conList = new ArrayList<Section>();

		try {

			conList = secRepo.findByDelStatusOrderBySectionIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/deleteSection" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSection(@RequestParam("sectionId") int sectionId) {

		int isDeleted = secRepo.deleteSection(sectionId);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Section Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Section Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/deleteMultiSection" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiSection(@RequestParam("sectionIds") List<Integer> sectionIds) {

		Info info = new Info();

		try {
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
	public @ResponseBody Info saveUser(@RequestBody User usr) {

		User secSaveResponse = null;
		Info info = new Info();
		try {

			secSaveResponse = userRepo.saveAndFlush(usr);

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

			System.err.println("Exce in saveUser @MasterController " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}
	
	
	@RequestMapping(value = { "/getUserByUserId" }, method = RequestMethod.POST)
	public @ResponseBody Info getUserByUserId(@RequestParam("userId") int userId) {

		User secSaveResponse = null;
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
	
	
	
	@RequestMapping(value = { "/getAllUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUserList() {

		List<User> conList = new ArrayList<User>();

		try {

			conList = userRepo.findByDelStatusOrderByUserIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteUser(@RequestParam("userId") int userId) {

		int isDeleted = userRepo.deleteUser(userId);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("User Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("User Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/deleteMultiUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiUser(@RequestParam("userIds") List<Integer> userIds) {

		Info info = new Info();

		try {
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
