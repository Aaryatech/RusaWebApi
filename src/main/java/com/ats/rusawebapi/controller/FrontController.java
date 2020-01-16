package com.ats.rusawebapi.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
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

import com.ats.rusawebapi.Commons;
import com.ats.rusawebapi.EmailUtility;
import com.ats.rusawebapi.RandomString;
import com.ats.rusawebapi.model.AppToken;
import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.CmsSearchData;
import com.ats.rusawebapi.model.ContactUs;
import com.ats.rusawebapi.model.EventCountDetails;
import com.ats.rusawebapi.model.EventDetail;
import com.ats.rusawebapi.model.EventDetails;
import com.ats.rusawebapi.model.EventReg;
import com.ats.rusawebapi.model.EventRegistration;
import com.ats.rusawebapi.model.EventView;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.GetPagesModule;
import com.ats.rusawebapi.model.HomeData;
import com.ats.rusawebapi.model.LoginResponse;
import com.ats.rusawebapi.model.NewsBlog;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.OtpResponse;
import com.ats.rusawebapi.model.Registration;
import com.ats.rusawebapi.model.RegistrationUserDetail;
import com.ats.rusawebapi.model.Setting;
import com.ats.rusawebapi.model.SettingMr;
import com.ats.rusawebapi.model.SmsCode;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.User;
import com.ats.rusawebapi.repo.AppTokenRepository;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.CmsSearchDataRepository;
import com.ats.rusawebapi.repo.ContactUsRepo;
import com.ats.rusawebapi.repo.EventCount;
import com.ats.rusawebapi.repo.EventDetailRepo;
import com.ats.rusawebapi.repo.EventDetailRepository;
import com.ats.rusawebapi.repo.EventRegRepo;
import com.ats.rusawebapi.repo.EventRegisterRepository;
import com.ats.rusawebapi.repo.EventViewRepository;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.NewsBlogRepository;
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.RegistrationRepo;
import com.ats.rusawebapi.repo.RegistrationUserDetailRepo;
import com.ats.rusawebapi.repo.SettingMrRepo;
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

	@Autowired
	EventRegisterRepository eventRegRepo;

	@Autowired
	EventDetailRepository eventDetailRegRepo;

	@Autowired
	EventViewRepository eventRepo;

	@Autowired
	EventDetailRepo eventDetailRepo;

	@Autowired
	EventRegRepo eventRegRepository;

	@Autowired
	EventCount eventCount;

	@Autowired
	RegistrationUserDetailRepo registrationUserDetailRepo;
	/*
	 * <dependency> <groupId>javax.mail</groupId> <artifactId>mail</artifactId>
	 * <version>1.4</version> </dependency>
	 */

	@Autowired
	SettingMrRepo settingMrRepo;

	static String senderEmail = "atsinfosoft@gmail.com";
	static String senderPassword = "atsinfosoft@123";
	static String mailsubject = " RUSA Login Credentials ";

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

			conList = contactUsRepo.findByDelStatusOrderByIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/getAllContactListDeleted" }, method = RequestMethod.GET)
	public @ResponseBody List<ContactUs> getAllContactListDeleted() {

		List<ContactUs> conList = new ArrayList<ContactUs>();

		try {

			conList = contactUsRepo.findByDelStatusOrderByIdDesc(0);

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

	@RequestMapping(value = { "/retriveContact" }, method = RequestMethod.POST)
	public @ResponseBody Info retriveContact(@RequestParam("id") int id) {

		int isDeleted = contactUsRepo.retriveContact(id);
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

	@RequestMapping(value = { "/deleteMultipleContact" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleContact(@RequestParam("id") List<Integer> id) {

		int isDeleted = contactUsRepo.deleteMultipleContact(id);
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

	@RequestMapping(value = { "/deleteMultipleUserReg" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultipleUserReg(@RequestParam("id") List<Integer> id) {

		int isDeleted = registrationRepo.deleteMultipleUserReg(id);
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

	@RequestMapping(value = { "/getLastFiveTestImonials" }, method = RequestMethod.POST)
	public @ResponseBody List<TestImonial> getLastFiveTestImonials(@RequestParam("langId") int langId) {
		List<TestImonial> secSaveResponse = new ArrayList<TestImonial>();

		try {
			secSaveResponse = testImonialListRepo.getLastFiveTestImonials(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllTestImonialsList" }, method = RequestMethod.POST)
	public @ResponseBody List<TestImonial> getAllTestImonialsList(@RequestParam("valueType") int valueType) {
		List<TestImonial> secSaveResponse = new ArrayList<TestImonial>();

		try {
			secSaveResponse = testImonialListRepo.getAllTestImonials(valueType);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getLastFiveTestImonialsVideo" }, method = RequestMethod.GET)
	public @ResponseBody List<TestImonial> getLastFiveTestImonialsVideo() {
		List<TestImonial> secSaveResponse = new ArrayList<TestImonial>();

		try {
			secSaveResponse = testImonialListRepo.getLastFiveTestImonialsVideo();

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

	@RequestMapping(value = { "/getLastSliderImagesByStatus" }, method = RequestMethod.POST)
	public @ResponseBody BannerImages getLastSliderImagesByStatus(@RequestParam("langId") int langId) {

		BannerImages secSaveResponse = new BannerImages();

		try {
			secSaveResponse = bannerImagesRepo.getLastSliderImagesByStatus(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllSettingList" }, method = RequestMethod.POST)
	public @ResponseBody List<SettingMr> getAllSettingList(@RequestParam("langId") int langId) {

		List<SettingMr> conList = new ArrayList<SettingMr>();

		try {
			if (langId == 2) {

				conList = settingMrRepo.findAllMrOrderByAsc();

			} else {

				conList = settingMrRepo.findAllOrderByAsc();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/getSettingRecordByKey" }, method = RequestMethod.POST)
	public @ResponseBody Setting getSettingRecordByKey(@RequestParam("key") String key) {

		Setting setting = new Setting();

		try {

			setting = settingRepository.findByKeyName(key);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return setting;

	}

	@RequestMapping(value = { "/updateCouunt" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSettingKeyValue(@RequestParam("key") String key) {

		Info info = new Info();

		try {

			Setting setting = settingRepository.findByKeyName(key);

			String value = String.valueOf(Integer.parseInt(setting.getKeyValues()) + 1);
			int update = settingRepository.updateSetting(value, key);

			info.setMsg(value);
			info.setError(false);

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("failed to update ");

		}
		return info;

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
		System.err.println("reg  " + reg.toString());
		Registration studResp = new Registration();
		RestTemplate restTemplate = new RestTemplate();
		try {

			int randomPin = (int) (Math.random() * 9000) + 1000;
			String otp = String.valueOf(randomPin);
			System.out.println("You OTP is " + otp);
			String msg = " Your verification OTP for Registration is " + otp
					+ ". Do not share OTP with anyone. RUSA Maharashtra";

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

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

			/*
			 * map.add("senderID", "RUSAMH"); map.add("user",
			 * "spdrusamah@gmail.com:Cyber@mva"); map.add("receipientno",
			 * studResp.getMobileNumber()); map.add("dcs", "0"); map.add("msgtxt", msg);
			 * map.add("state", "4");
			 * 
			 * String response = restTemplate.postForObject(
			 * "http://api.mVaayoo.com/mvaayooapi/MessageCompose", map, String.class);
			 */

			map = new LinkedMultiValueMap<String, Object>();
			map.add("username", "rusamah-wb");
			map.add("password", "Rus@@123456");
			map.add("senderid", "MHRUSA");
			map.add("mobileno", studResp.getMobileNumber());
			map.add("content", msg);
			map.add("smsservicetype", "singlemsg");
			String response = restTemplate.postForObject("https://msdgweb.mgov.gov.in/esms/sendsmsrequest", map,
					String.class);
			studResp.setError(false);
			studResp.setMsg("Otp Updated ");
			// Info info1 = EmailUtility.sendMsg(otp, studResp.getMobileNumber());

			// System.err.println("Info email sent response " + info1.toString());

		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return reg;

	}

	@RequestMapping(value = { "/saveEditReg" }, method = RequestMethod.POST)
	public @ResponseBody Registration saveEditReg(@RequestBody Registration reg) {

		Registration studResp = null;
		RestTemplate restTemplate = new RestTemplate();
		try {

			if (reg.getRegId() != 0) {
				int randomPin = (int) (Math.random() * 9000) + 1000;
				String otp = String.valueOf(randomPin);
				System.out.println("You OTP is " + otp);
				String msg = "Your verification OTP for Registration is " + otp
						+ ". Do not share OTP with anyone. RUSA Maharashtra";

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
				MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

				/*
				 * map.add("senderID", "RUSAMH"); map.add("user",
				 * "spdrusamah@gmail.com:Cyber@mva"); map.add("receipientno",
				 * studResp.getMobileNumber()); map.add("dcs", "0"); map.add("msgtxt", msg);
				 * map.add("state", "4");
				 * 
				 * String response = restTemplate.postForObject(
				 * "http://api.mVaayoo.com/mvaayooapi/MessageCompose", map, String.class);
				 */

				map = new LinkedMultiValueMap<String, Object>();
				map.add("username", "rusamah-wb");
				map.add("password", "Rus@@123456");
				map.add("senderid", "MHRUSA");
				map.add("mobileno", studResp.getMobileNumber());
				map.add("content", msg);
				map.add("smsservicetype", "singlemsg");
				String response = restTemplate.postForObject("https://msdgweb.mgov.gov.in/esms/sendsmsrequest", map,
						String.class);
				studResp.setError(false);
				studResp.setMsg("Otp Updated ");
				// Info info1 = EmailUtility.sendMsg(otp, studResp.getExVar2());

				// System.err.println("Info email sent response " + info1.toString());

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

			homeData.setBaner(getLastSliderImagesByStatus(1));
			homeData.setVideoList(getLastTenVideos());
			homeData.setPhotoList(getLastTenPhotos());
			homeData.setLogoData(new MasterApiControllerNew().getLogoListById(1));
			homeData.setNewsList(new MasterApiControllerNew().getLastFourNewsByLangId(langId));
			homeData.setTestimonialList(getLastFiveTestImonials(langId));
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

			regResponse = registrationRepo.findByUserUuidAndDelStatusAndSmsVerified(uuid, 1, 0);

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

			conList = registrationRepo.findByDelStatusAndSmsVerifiedOrderByRegIdDesc(1, 1);

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
			secSaveResponse = registrationRepo.findByUserUuidAndDelStatusAndSmsVerified(uuid, 1, 0);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/updateOtpByUuid" }, method = RequestMethod.POST)
	public @ResponseBody Info updateOtpByUuid(@RequestParam("uuid") String uuid, @RequestParam("otp") String otp) {

		int isDeleted = registrationRepo.updateOtpByUuid(uuid, otp);
		Info infoRes = new Info();

		if (isDeleted >= 1) {

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
			System.out.println(" save sms ");
			infoRes.setError(false);
			infoRes.setMsg("Updated OTP Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("OTP status Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/getRegUserbyRegId" }, method = RequestMethod.POST)
	public @ResponseBody Registration getRegUserbyRegId(@RequestParam("regId") int regId) {
		Registration secSaveResponse = new Registration();

		try {
			secSaveResponse = registrationRepo.findByRegIdAndDelStatus(regId, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getRegUserDetailbyRegId" }, method = RequestMethod.POST)
	public @ResponseBody RegistrationUserDetail getRegUserDetailbyRegId(@RequestParam("regId") int regId) {

		RegistrationUserDetail secSaveResponse = new RegistrationUserDetail();

		try {
			secSaveResponse = registrationUserDetailRepo.getRegUserDetailbyRegId(regId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/verifyResendOtpResponse" }, method = RequestMethod.POST)
	public @ResponseBody OtpResponse verifyResendOtpResponse(@RequestParam("uuid") String uuid) {

		// User user = new User();
		Registration regResponse = new Registration();
		OtpResponse otpRespose = new OtpResponse();
		RestTemplate restTemplate = new RestTemplate();
		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			regResponse = registrationRepo.findByUserUuidAndDelStatusAndSmsVerified(uuid, 1, 0);

			if (regResponse != null) {

				Registration reg1 = registrationRepo.findByUserUuidAndDelStatus(uuid, 1);

				if (reg1 != null) {
					int randomPin = (int) (Math.random() * 9000) + 1000;
					String otp = String.valueOf(randomPin);
					System.out.println("You OTP is " + otp);
					String msg = " Your verification OTP for Registration is " + otp
							+ ". Do not share OTP with anyone. RUSA Maharashtra";
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

					/*
					 * map.add("senderID", "RUSAMH"); map.add("user",
					 * "spdrusamah@gmail.com:Cyber@mva"); map.add("receipientno",
					 * reg1.getMobileNumber()); map.add("dcs", "0"); map.add("msgtxt", msg);
					 * map.add("state", "4");
					 * 
					 * String response = restTemplate.postForObject(
					 * "http://api.mVaayoo.com/mvaayooapi/MessageCompose", map, String.class);
					 */

					map = new LinkedMultiValueMap<String, Object>();
					map.add("username", "rusamah-wb");
					map.add("password", "Rus@@123456");
					map.add("senderid", "MHRUSA");
					map.add("mobileno", reg1.getMobileNumber());
					map.add("content", msg);
					map.add("smsservicetype", "singlemsg");
					String response = restTemplate.postForObject("https://msdgweb.mgov.gov.in/esms/sendsmsrequest", map,
							String.class);

					// Info info1 = EmailUtility.sendMsg(otp, reg1.getMobileNumber());

					int updateDate = registrationRepo.updateOtp(otp, uuid);
					System.out.println(" update ragistration table :" + updateDate);
					otpRespose.setError(false);
					otpRespose.setMsg("Otp Updated ");
					otpRespose.setReg(reg1);
				} else {
					// int updateDate = registrationRepo.updateSmsStatus(0,regResponse.getRegId());
					otpRespose.setError(true);
					otpRespose.setMsg("UUID Wrong");
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

	@RequestMapping(value = { "/verifyEditResendOtp" }, method = RequestMethod.POST)
	public @ResponseBody OtpResponse verifyEditResendOtp(@RequestParam("uuid") String uuid) {

		// User user = new User();
		Registration regResponse = new Registration();
		OtpResponse otpRespose = new OtpResponse();
		RestTemplate restTemplate = new RestTemplate();
		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			regResponse = registrationRepo.findByUserUuidAndDelStatusAndSmsVerified(uuid, 1, 0);

			if (regResponse != null) {

				Registration reg1 = registrationRepo.findByUserUuidAndDelStatus(uuid, 1);

				if (reg1 != null) {
					int randomPin = (int) (Math.random() * 9000) + 1000;
					String otp = String.valueOf(randomPin);
					System.out.println("You OTP is " + otp);
					String msg = " Your verification OTP for Registration is " + otp
							+ ". Do not share OTP with anyone. RUSA Maharashtra";
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

					/*
					 * map.add("senderID", "RUSAMH"); map.add("user",
					 * "spdrusamah@gmail.com:Cyber@mva"); map.add("receipientno",
					 * reg1.getMobileNumber()); map.add("dcs", "0"); map.add("msgtxt", msg);
					 * map.add("state", "4");
					 * 
					 * String response = restTemplate.postForObject(
					 * "http://api.mVaayoo.com/mvaayooapi/MessageCompose", map, String.class);
					 */

					map = new LinkedMultiValueMap<String, Object>();
					map.add("username", "rusamah-wb");
					map.add("password", "Rus@@123456");
					map.add("senderid", "MHRUSA");
					map.add("mobileno", reg1.getMobileNumber());
					map.add("content", msg);
					map.add("smsservicetype", "singlemsg");
					String response = restTemplate.postForObject("https://msdgweb.mgov.gov.in/esms/sendsmsrequest", map,
							String.class);

					// Info info1 = EmailUtility.sendMsg(otp, reg1.getMobileNumber());

					int updateDate = registrationRepo.updateOtp(otp, uuid);
					System.out.println(" update ragistration table :" + updateDate);
					otpRespose.setError(false);
					otpRespose.setMsg("Otp Updated ");
					otpRespose.setReg(reg1);
				} else {
					// int updateDate = registrationRepo.updateSmsStatus(0,regResponse.getRegId());
					otpRespose.setError(true);
					otpRespose.setMsg("UUID Wrong");
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

	@RequestMapping(value = { "/loginFrontEnd" }, method = RequestMethod.POST)
	public @ResponseBody Registration loginFrontEnd(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {

		Registration regResponse = new Registration();

		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			/*
			 * regResponse = registrationRepo.
			 * findByEmailsAndUserPasswordAndDelStatusAndEmailVerifiedAndIsActive(userName,
			 * password, 1, 1, 1);
			 * 
			 * if (regResponse != null) { regResponse.setError(false);
			 * regResponse.setMsg("Successful Login"); } else {
			 * 
			 * regResponse = registrationRepo.
			 * findByMobileNumberAndUserPasswordAndDelStatusAndEmailVerifiedAndIsActive(
			 * userName, password, 1, 1, 1);
			 * 
			 * if (regResponse != null) { regResponse.setError(false);
			 * regResponse.setMsg("Successful Login"); }
			 * 
			 * }
			 * 
			 * if (regResponse == null) { regResponse = new Registration();
			 * regResponse.setError(true); regResponse.setMsg("Invalid Credencials"); }
			 */

			regResponse = registrationRepo.loginProcess(userName, password);

			if (regResponse != null) {
				regResponse.setError(false);
				regResponse.setMsg("Successful Login");
			} else {
				regResponse = new Registration();
				regResponse.setError(true);
				regResponse.setMsg("Invalid Credencials");
			}

		} catch (Exception e) {

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
			regResponse = new Registration();
			regResponse.setError(true);
			regResponse.setMsg("Invalid Credencials");
		}
		return regResponse;

	}

	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.POST)
	public @ResponseBody Registration forgetPassword(@RequestParam("email") String email,
			@RequestParam("mobileNumber") String mobileNumber) {

		// User user = new User();
		Registration regResponse = new Registration();

		Info info1 = null;
		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			/*
			 * regResponse = registrationRepo.
			 * findByEmailsAndMobileNumberAndDelStatusAndEmailVerifiedAndIsActive(email,
			 * mobileNumber, 1, 1, 1);
			 * 
			 * if (regResponse != null) {
			 * 
			 * Date date = new Date(); // your date SimpleDateFormat sf = new
			 * SimpleDateFormat("yyyy-MM-dd"); Calendar cal = Calendar.getInstance();
			 * cal.setTime(date);
			 * 
			 * String password = Commons.getAlphaNumericString(5);
			 * 
			 * regResponse.setUserPassword(password);
			 * regResponse.setEditDate(sf.format(date));
			 * registrationRepo.saveAndFlush(regResponse); System.out.println("save"); info1
			 * = EmailUtility.sendEmail(senderEmail, senderPassword, email, mailsubject,
			 * regResponse.getName(), regResponse.getUserPassword()); if (info1 != null) {
			 * int updateDate = registrationRepo.updatePassword(password,
			 * regResponse.getUserUuid()); System.out.println(" update ragistration table :"
			 * + updateDate); regResponse.setError(false);
			 * regResponse.setMsg("Password Updated "); } }
			 * 
			 * if (regResponse == null) { regResponse = new Registration();
			 * regResponse.setError(true); regResponse.setMsg("Invalid Credencials"); }
			 */

			regResponse = registrationRepo.forgetPassword(email, mobileNumber);

			if (regResponse != null) {

				Date date = new Date(); // your date
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);

				RandomString randomString = new RandomString();
				String password = randomString.nextString();
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] messageDigest = md.digest(password.getBytes());
				BigInteger number = new BigInteger(1, messageDigest);
				String hashtext = number.toString(16);

				// String password = Commons.getAlphaNumericString(5);

				regResponse.setUserPassword(hashtext);
				regResponse.setEditDate(sf.format(date));
				registrationRepo.saveAndFlush(regResponse);
				System.out.println("save");
				info1 = EmailUtility.sendEmail(senderEmail, senderPassword, regResponse.getEmails(), mailsubject,
						regResponse.getEmails(), password);

				RestTemplate restTemplate = new RestTemplate();
				MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

				/*
				 * map.add("senderID", "RUSAMH"); map.add("user",
				 * "spdrusamah@gmail.com:Cyber@mva"); map.add("receipientno",
				 * regResponse.getMobileNumber()); map.add("dcs", "0"); map.add("msgtxt",
				 * "Your Username " + regResponse.getEmails() + "\n Password " +
				 * regResponse.getUserPassword() + "\n don't share with any one.");
				 * map.add("state", "4");
				 * 
				 * String response = restTemplate.postForObject(
				 * "http://api.mVaayoo.com/mvaayooapi/MessageCompose", map, String.class);
				 */

				map = new LinkedMultiValueMap<String, Object>();
				map.add("username", "rusamah-wb");
				map.add("password", "Rus@@123456");
				map.add("senderid", "MHRUSA");
				map.add("mobileno", regResponse.getMobileNumber());
				map.add("content", "\n Your Username :" + regResponse.getEmails() + "\n New Password :" + password
						+ "\n don't share with any one.");
				map.add("smsservicetype", "singlemsg");
				String response = restTemplate.postForObject("https://msdgweb.mgov.gov.in/esms/sendsmsrequest", map,
						String.class);

				if (info1 != null) {
					int updateDate = registrationRepo.updatePassword(hashtext, regResponse.getUserUuid());
					System.out.println(" update ragistration table :" + updateDate);
					regResponse.setError(false);
					regResponse.setMsg("Password Updated ");
				}
			} else {
				regResponse = new Registration();
				regResponse.setError(true);
				regResponse.setMsg("Invalid Credencials");
			}

		} catch (Exception e) {

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
			regResponse = new Registration();
			regResponse.setError(true);
			regResponse.setMsg("Invalid Credencials");

			e.printStackTrace();
		}
		return regResponse;

	}

	@RequestMapping(value = { "/changePassword" }, method = RequestMethod.POST)
	public @ResponseBody Info changePassword(@RequestParam("regId") String regId,
			@RequestParam("password") String password) {

		int isUpdate = registrationRepo.updatePasswordByRegId(regId, password);
		Info infoRes = new Info();

		if (isUpdate >= 1) {

			infoRes.setError(false);
			infoRes.setMsg("Updated Password Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Password Failed to update");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/getAllEventsList" }, method = RequestMethod.GET)
	public @ResponseBody List<Registration> getAllEventsList() {

		List<Registration> conList = new ArrayList<Registration>();

		try {

			conList = registrationRepo.findByDelStatusOrderByRegId(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;
	}

	@RequestMapping(value = { "/getAllEventsL" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllEventsL(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			secSaveResponse = newsDetailRepo.getAllEvents(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllEventsByLimit" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllEventsByLimit(@RequestParam("langId") int langId,
			@RequestParam("pageid") int pageid, @RequestParam("total") int total) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			pageid = pageid - 1;
			secSaveResponse = newsDetailRepo.getAllEventsByLimit(langId, pageid, total);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllPreviousEvents" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllPreviousEvents(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			secSaveResponse = newsDetailRepo.getAllPreviousEvents(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllPreviousE" }, method = RequestMethod.POST)
	public @ResponseBody List<EventReg> getAllPreviousE(@RequestParam("langId") int langId) {
		List<EventReg> secSaveResponse = new ArrayList<EventReg>();

		try {
			secSaveResponse = eventRegRepository.getAllPreviousEvents(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllUpcomingEvents" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllUpcomingEvents(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			secSaveResponse = newsDetailRepo.getAllUpcomingEvents(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllUpcomingEventsWithIsApply" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllUpcomingEventsWithIsApply(@RequestParam("langId") int langId,
			@RequestParam("userId") int userId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			secSaveResponse = newsDetailRepo.getAllUpcomingEventsWithIsApply(langId, userId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/newsListForHomePage" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> newsListForHomePage(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			Date newDate = new Date(today.getTime() - 604800000L);

			secSaveResponse = newsDetailRepo.newsListForHomePage(langId, sf.format(newDate));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/newsExpiredListForHomePage" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> newsExpiredListForHomePage(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			Date newDate = new Date(today.getTime() - 604800000L);
			secSaveResponse = newsDetailRepo.newsExpiredListForHomePage(langId, sf.format(newDate));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/saveEventRegister" }, method = RequestMethod.POST)
	public @ResponseBody EventRegistration saveEventRegister(@RequestBody EventRegistration getEventList) {

		Info errorMessage = new Info();
		EventRegistration eventRegList = new EventRegistration();
		try {
			eventRegList = eventRegRepo.save(getEventList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return eventRegList;
	}

	@RequestMapping(value = { "/getAllRegisteredEvents" }, method = RequestMethod.GET)
	public @ResponseBody List<EventRegistration> getAllRegisteredEvents() {
		List<EventRegistration> secSaveResponse = new ArrayList<EventRegistration>();

		try {
			secSaveResponse = eventRegRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/approveUserByEventId" }, method = RequestMethod.POST)
	public @ResponseBody Info approveUserByEventId(@RequestParam("eventId") int eventId) {

		int isApprove = eventRegRepo.updateApproveStatus(eventId);
		Info infoRes = new Info();

		if (isApprove >= 1) {
			infoRes.setError(false);
			infoRes.setMsg("User Approve Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg(" Failed to update Status");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/getUserInfoByUserId" }, method = RequestMethod.GET)
	public @ResponseBody List<EventDetails> getUserInfoByUserId() {
		List<EventDetails> secSaveResponse = new ArrayList<EventDetails>();

		try {
			secSaveResponse = eventDetailRegRepo.getAllEventRegisteredUser();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getUserEventByEventRegId" }, method = RequestMethod.POST)
	public @ResponseBody EventRegistration getUserEventByEventRegId(@RequestParam("eventRegId") int eventRegId) {
		EventRegistration secSaveResponse = new EventRegistration();

		try {
			secSaveResponse = eventRegRepo.findByEventRegIdAndDelStatus(eventRegId, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getFeedbackByUserIdAndNewsblogsId" }, method = RequestMethod.POST)
	public @ResponseBody EventRegistration getFeedbackByUserIdAndNewsblogsId(@RequestParam("userId") int userId,
			@RequestParam("newsblogsId") int newsblogsId) {
		EventRegistration secSaveResponse = new EventRegistration();

		try {
			secSaveResponse = eventRegRepo.findByUserIdAndNewsblogsIdAndDelStatus(userId, newsblogsId, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getEventListByNewsId" }, method = RequestMethod.POST)
	public @ResponseBody NewsDetails getEventListByNewsId(@RequestParam("newsblogsId") int newsblogsId,
			@RequestParam("langId") int langId) {

		NewsDetails list = new NewsDetails();

		try {
			list = newsDetailRepo.getEventListByNewblogsId(newsblogsId, langId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	/*
	 * @RequestMapping(value = { "/getEventListByNewsId" }, method =
	 * RequestMethod.POST) public @ResponseBody NewsDetails
	 * getEventListByNewsId(@RequestParam("langId") int
	 * langId,@RequestParam("pageId") int pageId,@RequestParam("newsblogsId") int
	 * newsblogsId) {
	 * 
	 * NewsDetails list = new NewsDetails();
	 * 
	 * try { list = newsDetailRepo.getEventListByNewblogsId(newsblogsId,langId,);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return list;
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = { "/getUserInfoByNewsblogsId" }, method =
	 * RequestMethod.POST) public @ResponseBody List<EventDetail>
	 * getUserInfoByNewsblogsId(@RequestParam("newsblogsId") int newsblogsId) {
	 * List<EventDetail> secSaveResponse = new ArrayList<>();
	 * 
	 * try { secSaveResponse = eventDetailRepo.getUserDetailList(newsblogsId);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return secSaveResponse; }
	 */
	@RequestMapping(value = { "/getEventDataByRegId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventDetail> getEventDataByRegId(@RequestParam("eventRegId") int eventRegId) {
		List<EventDetail> secSaveResponse = new ArrayList<>();

		try {
			secSaveResponse = eventDetailRepo.getEventDetailList(eventRegId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getCurrentMonthEvents" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getCurrentMonthEvents(@RequestParam("firstDate") String firstDate,
			@RequestParam("endDate") String endDate) {
		List<NewsDetails> secSaveResponse = new ArrayList<>();

		try {
			secSaveResponse = newsDetailRepo.getCurrentMonthE(firstDate, endDate);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	/*
	 * @RequestMapping(value = { "/getAppliedEvents" }, method = RequestMethod.POST)
	 * public @ResponseBody List<EventRegistration>
	 * getAppliedEvents(@RequestParam("newsblogsId") int newsblogsId,
	 * 
	 * @RequestParam("userId") int userId) { List<EventRegistration> secSaveResponse
	 * = new ArrayList<EventRegistration>();
	 * 
	 * try { secSaveResponse = eventRegRepo.findByNewsblogsIdAndUserId(newsblogsId,
	 * userId);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return secSaveResponse; }
	 */
	@RequestMapping(value = { "/getAppliedEvents" }, method = RequestMethod.POST)
	public @ResponseBody Info getAppliedEvents(@RequestParam("newsblogsId") int newsblogsId,
			@RequestParam("userId") int userId) {
		Info info = new Info();
		EventRegistration reg = new EventRegistration();
		try {
			reg = eventRegRepo.findByNewsblogsIdAndUserId(newsblogsId, userId);

			if (reg == null) {
				info.setError(true);
				info.setMsg("Record Not Found");
				System.out.print("asdcbvn");
			} else {
				info.setError(false);
				info.setMsg("Record Found");
				System.out.print("asdcbdfghjkvn");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getUserInfoByNewsblogsId" }, method = RequestMethod.POST)
	public @ResponseBody List<EventDetail> getUserInfoByNewsblogsId(@RequestParam("newsblogsId") int newsblogsId) {
		List<EventDetail> secSaveResponse = new ArrayList<>();

		try {
			secSaveResponse = eventDetailRepo.getUserDetailList(newsblogsId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllEventList" }, method = RequestMethod.POST)
	public @ResponseBody List<EventCountDetails> getAllEventList(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<EventCountDetails> list = new ArrayList<>();

		try {
			list = eventCount.getAllEvents(fromDate, toDate);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	@RequestMapping(value = { "/getNewsListByNewsId" }, method = RequestMethod.POST)
	public @ResponseBody NewsDetails getNewsListByNewsId(@RequestParam("newsblogsId") int newsblogsId,
			@RequestParam("langId") int langId) {

		NewsDetails list = new NewsDetails();

		try {
			list = newsDetailRepo.getNewsListByNewsId(newsblogsId, langId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getLastPassword" }, method = RequestMethod.POST)
	public @ResponseBody Info getLastPassword(@RequestParam("userId") int userId, @RequestParam("pass") String pass) {
		Info info = new Info();
		Registration reg = null;
		try {
			reg = registrationRepo.findByRegIdAndUserPassword(userId, pass);

			if (reg == null) {
				info.setError(true);
				info.setMsg("Password Incorrect");
			} else {

				/*
				 * reg = registrationRepo.findByRegIdAndUserPassword(userId, pass); if (reg !=
				 * null) { info.setError(true); info.setMsg("Password Already Updated  "); }
				 */

				info.setError(false);
				info.setMsg("Password Correct");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/checkPasswordByUserId" }, method = RequestMethod.POST)
	public @ResponseBody Info checkPasswordByUserId(@RequestParam("userId") int userId,
			@RequestParam("pass") String pass) {
		Info info = new Info();
		Registration reg = null;
		try {
			reg = registrationRepo.checkPasswordByUserId(userId, pass);

			if (reg == null) {
				info.setError(true);
				info.setMsg("Password Incorrect");
			} else {

				/*
				 * reg = registrationRepo.findByRegIdAndUserPassword(userId, pass); if (reg !=
				 * null) { info.setError(true); info.setMsg("Password Already Updated  "); }
				 */

				info.setError(false);
				info.setMsg("Password Correct");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	/*
	 * select n.*, nd.heading, nd.descriptions, nd.language_id, nd.page_meta_title,
	 * nd.page_meta_description, nd.page_meta_keyword e. from t_newsblogs n,
	 * t_newsblogs_description nd , event_registration e where
	 * DATE(n.event_date_from) < DATE(NOW()) and n.is_active=1 and n.del_status=1
	 * and n.newsblogs_id=nd.newsblogs_id and nd.language_id=2 and n.ex_int1=11 and
	 * e.user_id IN(5) and n.newsblogs_id=e.newsblogs_id order by n.newsblogs_id
	 * DESC
	 */
	@RequestMapping(value = { "/uploadEventDocument" }, method = RequestMethod.POST)
	public @ResponseBody Info uploadEventDocument(@RequestParam("regId") int regId,
			@RequestParam("newsblogsId") int newsblogsId, @RequestParam("pdfName") String pdfName) {

		Date date = new Date(); // your date
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String f = sf.format(date);
		int isUpdate = eventRegRepo.updateDocByRegId(regId, newsblogsId, pdfName);
		Info infoRes = new Info();

		if (isUpdate >= 1) {

			infoRes.setError(false);
			infoRes.setMsg("Upload Document Successfully");
		} else {
			infoRes.setError(true);
			infoRes.setMsg("Document Failed to update");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/checkUniqueField" }, method = RequestMethod.POST)
	public @ResponseBody Info checkUniqueField(@RequestParam String inputValue, @RequestParam int valueType,
			@RequestParam int primaryKey) {

		Info info = new Info();

		List<Registration> instList = new ArrayList<Registration>();

		if (valueType == 1) {
			System.err.println("Its Contact No check");

			System.err.println("Its New Record Insert ");
			instList = registrationRepo.findByMobileNumberAndDelStatusAndSmsVerified(inputValue.trim(), 1, 1);
			System.err.println("instList for mob" + instList.toString());

		} else if (valueType == 2) {
			System.err.println("Its Email check");

			System.err.println("Its New Record Insert ");
			instList = registrationRepo.findByEmailsAndDelStatusAndSmsVerified(inputValue.trim(), 1, 1);

			System.err.println("instList for email" + instList.toString());

		}
		if (instList.size() > 0) {
			info.setError(true);
			info.setMsg("duplicate");
		} else {
			info.setError(false);
			info.setMsg("unique");
		}

		System.err.println("info is " + info.toString());
		return info;
	}

	@RequestMapping(value = { "/updateEventFeedback" }, method = RequestMethod.POST)
	public @ResponseBody Info updateEventFeedback(@RequestParam("eventId") int eventId,
			@RequestParam("userId") int userId, @RequestParam("messge") String messge,
			@RequestParam("value") int value) {

		Info errorMessage = new Info();

		try {
			int update = eventRegRepo.updateEventFeedback(eventId, userId, messge, value);

			if (update > 0) {
				errorMessage.setError(false);
				errorMessage.setMsg("updated");
			} else {
				errorMessage.setError(true);
				errorMessage.setMsg("updated failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("updated failed");

		}
		return errorMessage;
	}

}
