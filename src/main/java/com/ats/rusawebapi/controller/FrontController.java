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

import com.ats.rusawebapi.Commons;
import com.ats.rusawebapi.EmailUtility;
import com.ats.rusawebapi.model.AppToken;
import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.CmsSearchData;
import com.ats.rusawebapi.model.ContactUs;
import com.ats.rusawebapi.model.EventDetail;
import com.ats.rusawebapi.model.EventDetails;
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
import com.ats.rusawebapi.model.Setting;
import com.ats.rusawebapi.model.SmsCode;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.User;
import com.ats.rusawebapi.repo.AppTokenRepository;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.CmsSearchDataRepository;
import com.ats.rusawebapi.repo.ContactUsRepo;
import com.ats.rusawebapi.repo.EventDetailRepo;
import com.ats.rusawebapi.repo.EventDetailRepository;
import com.ats.rusawebapi.repo.EventRegisterRepository;
import com.ats.rusawebapi.repo.EventViewRepository;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.NewsBlogRepository;
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
	
	@Autowired
	EventRegisterRepository eventRegRepo;	
	
	@Autowired
	EventDetailRepository eventDetailRegRepo;
	
	@Autowired
	EventViewRepository eventRepo;
	
	@Autowired
	EventDetailRepo eventDetailRepo;
	/*
	 * <dependency> <groupId>javax.mail</groupId> <artifactId>mail</artifactId>
	 * <version>1.4</version> </dependency>
	 */

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

			regResponse = registrationRepo.findByUserUuidAndDelStatusAndSmsVerified(uuid, 1,0);

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
			secSaveResponse = registrationRepo.findByRegIdAndDelStatus(regId,1);

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
		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			regResponse = registrationRepo.findByUserUuidAndDelStatusAndSmsVerified(uuid, 1, 0);

			if (regResponse != null) {

				Registration reg1 = registrationRepo.findByUserUuidAndDelStatus(uuid, 1);

				if (reg1 != null) {
					int randomPin = (int) (Math.random() * 9000) + 1000;
					String otp = String.valueOf(randomPin);
					System.out.println("You OTP is " + otp);

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

					Info info1 = EmailUtility.sendMsg(otp, reg1.getMobileNumber());

					int updateDate = registrationRepo.updateOtp(otp, uuid);
					System.out.println(" update ragistration table :"+updateDate);
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
	public @ResponseBody Registration loginFrontEnd(@RequestParam("userName") String userName,@RequestParam("password") String password) {

		Registration regResponse = new Registration();
		OtpResponse otpRespose = new OtpResponse();
		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			regResponse = registrationRepo.findByEmailsAndUserPasswordAndDelStatusAndEmailVerifiedAndIsActive(userName,password, 1, 1,1);

			if (regResponse != null) {
				regResponse.setError(false);
				regResponse.setMsg("Successful Login");	
				} 
			else
				{
				regResponse = registrationRepo.findByMobileNumberAndUserPasswordAndDelStatusAndEmailVerifiedAndIsActive(userName,password, 1,1,1);

					if (regResponse != null) {
						regResponse.setError(false);
						regResponse.setMsg("Successful Login");				
					}
					else
					{
						regResponse.setError(true);
						regResponse.setMsg("Invalid Credencials");
						
					}
				}
			

		} catch (Exception e) {
			otpRespose.setError(true);
			otpRespose.setMsg("exception");

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}
		return regResponse;

	}
	
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.POST)
	public @ResponseBody Registration forgetPassword(@RequestParam("email") String email,@RequestParam("mobileNumber") String mobileNumber) {

		// User user = new User();
		Registration regResponse = new Registration();
		OtpResponse otpRespose = new OtpResponse();
		Info info1=null;
		try {

			// user = userRepo.findByUserNameAndUserPassAndDelStatus(userName,password, 1);

			regResponse = registrationRepo.findByEmailsAndMobileNumberAndDelStatusAndEmailVerifiedAndIsActive(email,mobileNumber, 1, 1,1);

			if (regResponse != null) {

					Date date = new Date(); // your date
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					
					String password=Commons.getAlphaNumericString(5);
					
					regResponse.setUserPassword(password);
					regResponse.setEditDate(sf.format(date));
					registrationRepo.saveAndFlush(regResponse);
					System.out.println("save");
					  info1 = EmailUtility.sendEmail(senderEmail,senderPassword,email,mailsubject,regResponse.getName(),  password);
					  if(info1!=null) 
					  {
						  	int updateDate = registrationRepo.updatePassword(password,regResponse.getUserUuid());
						  	System.out.println(" update ragistration table :"+updateDate);
						  	regResponse.setError(false);
						  	regResponse.setMsg("Password Updated ");
					  }
			} else {

				regResponse.setError(true);
				regResponse.setMsg("Invalid Credencials");
			}

		} catch (Exception e) {
			regResponse.setError(true);
			regResponse.setMsg("exception");

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
		}
		return regResponse;

	}
	@RequestMapping(value = { "/changePassword" }, method = RequestMethod.POST)
	public @ResponseBody Info changePassword(@RequestParam("regId") String regId,@RequestParam("password") String password) {

		Date date = new Date(); // your date
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String f=sf.format(date);
		int isUpdate = registrationRepo.updatePasswordByRegId(regId,password);
		Info infoRes = new Info();

		if (isUpdate  >= 1) {

			
			
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
	
	@RequestMapping(value = { "/saveEventRegister" }, method = RequestMethod.POST)
	public @ResponseBody EventRegistration saveEventRegister(@RequestBody EventRegistration getEventList) {

		Info errorMessage = new Info();
		EventRegistration eventRegList = null;
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
	
	@RequestMapping(value = { "/getAllEventList" }, method = RequestMethod.GET)
	public @ResponseBody List<EventView> getAllEventList() {

		List<EventView> list = new ArrayList<>();

		try {
 				list = eventRepo.getAllEvents();
			 } catch (Exception e) {
		 
			e.printStackTrace();
		}

		return list;
	}  
	
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
	
	
	
	 
}
