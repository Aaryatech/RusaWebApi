package com.ats.rusawebapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusawebapi.EmailUtility;
import com.ats.rusawebapi.model.AppToken;
import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.CmsSearchData;
import com.ats.rusawebapi.model.ContactUs;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.HomeData;
import com.ats.rusawebapi.model.LoginResponse;
import com.ats.rusawebapi.model.OtpResponse;
import com.ats.rusawebapi.model.Registration;
import com.ats.rusawebapi.model.Setting;
import com.ats.rusawebapi.model.SmsCode;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.User;
import com.ats.rusawebapi.repo.AppTokenRepository;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.CmsSearchDataRepository;
import com.ats.rusawebapi.repo.ContactUsRepo;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.RegistrationRepo;
import com.ats.rusawebapi.repo.SettingRepo;
import com.ats.rusawebapi.repo.SmsCodeRepository;
import com.ats.rusawebapi.repo.TestImonialRepository;

@RestController
public class FrontController {

	@Autowired
	ContactUsRepo contactUsRepo;

	@Autowired
	GallaryDetailRepository gallaryDetailRepository;

	@Autowired
	CmsSearchDataRepository cmsPageDescRepository;

	@Autowired
	TestImonialRepository testImonialListRepo;

	@Autowired
	NewsDetailsRepository newsDetailRepo;

	@Autowired
	BannerImagesRepository bannerImagesRepo;

	@Autowired
	SettingRepo settingRepository;

	@Autowired
	RegistrationRepo registrationRepo;

	@Autowired
	SmsCodeRepository smsCodeRepo;

	@Autowired
	AppTokenRepository appTokenListRepo;

	/*
	 * <dependency> <groupId>javax.mail</groupId> <artifactId>mail</artifactId>
	 * <version>1.4</version> </dependency>
	 */

	@RequestMapping(value = { "/saveContactUs" }, method = RequestMethod.POST)
	public @ResponseBody ContactUs saveContactUs(@RequestBody ContactUs getContactList) {

		Info errorMessage = new Info();
		ContactUs ContactUsList = null;
		try {

			ContactUsList = contactUsRepo.save(getContactList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return ContactUsList;

	}

	@RequestMapping(value = { "/getContactById" }, method = RequestMethod.POST)
	public @ResponseBody ContactUs getContactById(@RequestParam("id") int id) {
		ContactUs secSaveResponse = new ContactUs();

		try {
			secSaveResponse = contactUsRepo.findByIdAndDelStatus(id, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllContactList" }, method = RequestMethod.GET)
	public @ResponseBody List<ContactUs> getAllContactList() {

		List<ContactUs> conList = new ArrayList<ContactUs>();

		try {

			conList = contactUsRepo.findByDelStatusOrderById(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/deleteContact" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteContact(@RequestParam("id") int id) {

		int isDeleted = contactUsRepo.deleteContactId(id);
		Info infoRes = new Info();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Contact Deleted Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Contact Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/getLastTenVideos" }, method = RequestMethod.GET)
	public @ResponseBody List<GallaryDetail> getLastTenVideos() {
		List<GallaryDetail> secSaveResponse = new ArrayList<GallaryDetail>();

		try {
			secSaveResponse = gallaryDetailRepository.getLastTenVedios();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getLastTenPhotos" }, method = RequestMethod.GET)
	public @ResponseBody List<GallaryDetail> getLastTenPhotos() {
		List<GallaryDetail> secSaveResponse = new ArrayList<GallaryDetail>();

		try {
			secSaveResponse = gallaryDetailRepository.getLastTenPhotos();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getCMSDescByExInt1" }, method = RequestMethod.POST)
	public @ResponseBody List<CmsSearchData> getCMSDescByExInt1(@RequestParam("langId") int langId) {
		List<CmsSearchData> secSaveResponse = new ArrayList<CmsSearchData>();

		try {
			secSaveResponse = cmsPageDescRepository.getCMSDescByExInt1(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getLastFiveTestImonials" }, method = RequestMethod.GET)
	public @ResponseBody List<TestImonial> getLastFiveTestImonials() {
		List<TestImonial> secSaveResponse = new ArrayList<TestImonial>();

		try {
			secSaveResponse = testImonialListRepo.getLastFiveTestImonials();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getTeamDetail" }, method = RequestMethod.GET)
	public @ResponseBody List<TestImonial> getLastTenTeam() {
		List<TestImonial> secSaveResponse = new ArrayList<TestImonial>();

		try {
			secSaveResponse = testImonialListRepo.getTeamDetail();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getSuccessStory" }, method = RequestMethod.GET)
	public @ResponseBody List<TestImonial> getLastTenSuccessStory() {
		List<TestImonial> secSaveResponse = new ArrayList<TestImonial>();

		try {
			secSaveResponse = testImonialListRepo.getSuccessStory();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getLastSliderImagesByStatus" }, method = RequestMethod.GET)
	public @ResponseBody BannerImages getLastSliderImagesByStatus() {

		BannerImages secSaveResponse = new BannerImages();

		try {
			secSaveResponse = bannerImagesRepo.getLastSliderImagesByStatus(1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllSettingList" }, method = RequestMethod.GET)
	public @ResponseBody List<Setting> getAllSettingList() {

		List<Setting> conList = new ArrayList<Setting>();

		try {

			conList = settingRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/getAllWebSiteCount" }, method = RequestMethod.GET)
	public @ResponseBody Setting getAllWebSiteCount() {

		Setting conList = new Setting();

		try {

			conList = settingRepository.getWebSiteCount();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;
	}

	@RequestMapping(value = { "/saveRegistration" }, method = RequestMethod.POST)
	public @ResponseBody Registration saveRegistration(@RequestBody Registration getContactList) {

		Info errorMessage = new Info();
		Registration registrationList = null;
		try {

			registrationList = registrationRepo.save(getContactList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return registrationList;

	}

	@RequestMapping(value = { "/getUserByUUIDAndType" }, method = RequestMethod.POST)
	public @ResponseBody Registration getUserByUUIDAndType(@RequestParam("suuid") int suuid,
			@RequestParam("type") int type) {

		Registration secSaveResponse = new Registration();

		try {
			secSaveResponse = registrationRepo.findByUserUuidAndUserTypeAndDelStatus(suuid, type, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/saveReg" }, method = RequestMethod.POST)
	public @ResponseBody Registration saveReg(@RequestBody Registration reg) {

		Registration studResp = null;

		try {

			if (reg.getRegId() == 0) {
				int randomPin = (int) (Math.random() * 9000) + 1000;
				String otp = String.valueOf(randomPin);
				System.out.println("You OTP is " + otp);

				reg.setSmsCode(otp);
				reg.setSmsVerified(0);
				studResp = registrationRepo.saveAndFlush(reg);

				Date date = new Date(); // your date
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);

				SmsCode sms = new SmsCode();

				sms.setSmsCode(otp);
				sms.setUserUuid(studResp.getUserUuid());
				sms.setSmsType(1);
				sms.setDateSent(sf.format(date));

				smsCodeRepo.saveAndFlush(sms);

				Info info1 = EmailUtility.sendMsg(otp, studResp.getMobileNumber());

				System.err.println("Info email sent response   " + info1.toString());

			}
		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return reg;

	}

	@RequestMapping(value = { "/saveAppTokens" }, method = RequestMethod.POST)
	public @ResponseBody AppToken saveAppTokens(@RequestBody AppToken getContactList) {

		Info errorMessage = new Info();
		AppToken appTokenList = null;
		try {

			appTokenList = appTokenListRepo.save(getContactList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return appTokenList;
	}

	@RequestMapping(value = { "/getAllHomeData" }, method = RequestMethod.POST)
	public @ResponseBody HomeData getAllHomeData(@RequestParam("langId") int langId) {

		HomeData homeData = new HomeData();
		try {

			homeData.setBaner(getLastSliderImagesByStatus());
			homeData.setVideoList(getLastTenVideos());
			homeData.setPhotoList(getLastTenPhotos());
			homeData.setLogoData(new MasterApiControllerNew().getLogoListById(1));
			homeData.setNewsList(new MasterApiControllerNew().getLastFourNewsByLangId(langId));
			homeData.setTestimonialList(getLastFiveTestImonials());
			homeData.setSocialList(new MasterApiControllerNew().getAllSocialList());
			homeData.setCmsList(getCMSDescByExInt1(langId));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return homeData;
	}

	@RequestMapping(value = { "/verifyOtpResponse" }, method = RequestMethod.POST)
	public @ResponseBody OtpResponse verifyOtpResponse(@RequestParam("userOtp") String userOtp,
			@RequestParam("uuid") String uuid) {

		// User user = new User();
		Registration regResponse = new Registration();
		OtpResponse otpRespose = new OtpResponse();
		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			regResponse = registrationRepo.findByUserUuidAndDelStatusAndIsActiveAndSmsVerified(uuid, 1, 1, 0);

			if (regResponse != null) {

				Registration reg1 = registrationRepo.findBySmsCodeAndUserUuidAndDelStatus(userOtp, uuid, 1);

				if (reg1 != null) {
					int updateDate = registrationRepo.updateSmsStatus(1, regResponse.getRegId());
					otpRespose.setError(false);
					otpRespose.setMsg("Login Sucess ");
					otpRespose.setReg(reg1);
				} else {
					// int updateDate = registrationRepo.updateSmsStatus(0,regResponse.getRegId());
					otpRespose.setError(true);
					otpRespose.setMsg("password Wrong");
				}

			} else {

				otpRespose.setError(true);
				otpRespose.setMsg("Invalid Credencials");
			}

		} catch (Exception e) {
			otpRespose.setError(true);
			otpRespose.setMsg("exception");

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}
		return otpRespose;

	}

	@RequestMapping(value = { "/getAllRegUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<Registration> getAllRegUserList() {

		List<Registration> conList = new ArrayList<Registration>();

		try {

			conList = registrationRepo.findByDelStatusOrderByRegId(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;
	}

	@RequestMapping(value = { "/updateUserByRegId" }, method = RequestMethod.POST)
	public @ResponseBody Info updateUserByRegId(@RequestParam("regId") int regId) {

		int isDeleted = registrationRepo.updateEmailStatus(regId);
		Info infoRes = new Info();

		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Updated Email status Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Email status Failed");
		}
		return infoRes;
	}
	
	@RequestMapping(value = { "/getMobileNumberByUuidId" }, method = RequestMethod.POST)
	public @ResponseBody Registration getMobileNumberByUuidId(@RequestParam("uuid") String uuid) {

		Registration secSaveResponse = new Registration();
		 
		try {
			secSaveResponse = registrationRepo.findByUserUuidAndDelStatusAndSmsVerified(uuid, 1 ,0); 
		
			 

		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return secSaveResponse;
	}
	
	@RequestMapping(value = { "/updateOtpByUuid" }, method = RequestMethod.POST)
	public @ResponseBody Info updateOtpByUuid(@RequestParam("uuid") String uuid,@RequestParam("otp") String otp) {

		int isDeleted = registrationRepo.updateOtpByUuid(uuid,otp);
		Info infoRes = new Info();

		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("Updated OTP Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("OTP status Failed");
		}
		return infoRes;
	}
	

}
