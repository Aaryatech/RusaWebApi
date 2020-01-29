package com.ats.rusawebapi.controller;

import java.io.IOException;
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

import com.ats.rusawebapi.EmailUtility;
import com.ats.rusawebapi.RandomString;
import com.ats.rusawebapi.model.AppToken;
import com.ats.rusawebapi.model.EventRegistration;
import com.ats.rusawebapi.model.EventRegistrationForApp;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.OtpResponse;
import com.ats.rusawebapi.model.Registration;
import com.ats.rusawebapi.model.RegistrationUserDetail;
import com.ats.rusawebapi.model.SmsCode;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.model.mst.InfoNew;
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
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.RegistrationRepo;
import com.ats.rusawebapi.repo.RegistrationUserDetailRepo;
import com.ats.rusawebapi.repo.SettingMrRepo;
import com.ats.rusawebapi.repo.SettingRepo;
import com.ats.rusawebapi.repo.SmsCodeRepository;
import com.ats.rusawebapi.repo.TestImonialRepository;


@RestController
public class FrontControllerForApp {

	
	
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
	
	
	
	@RequestMapping(value = { "/updateToken" }, method = RequestMethod.POST)
	public @ResponseBody InfoNew updateToken(@RequestParam("regId") String regId, @RequestParam("token") String token) {

		InfoNew errorMessage = new InfoNew();
		String a=null;
		try {
			Info info1 = checkToken(token, Integer.parseInt(regId));
			if (info1.isError() == false) {
				errorMessage.setRetmsg("Found");

				int update = registrationRepo.clearToken(regId,a);

				if (update >= 1) {
					errorMessage.setMsg("Token Updated");
					errorMessage.setError(false);
				} else {
					errorMessage.setMsg("failed to update");
					errorMessage.setError(true);
				}

			} else {

				errorMessage.setRetmsg("Unauthorized User");
				errorMessage.setError(true);
				errorMessage.setMsg("failed to update ");
			}

		} catch (

		Exception e) {

			e.printStackTrace();
			errorMessage.setRetmsg("Not Found");
			errorMessage.setError(true);
			errorMessage.setMsg("failed to update ");

		}
		return errorMessage;

	}
	
	
	@RequestMapping(value = { "/saveRegistrationForApp" }, method = RequestMethod.POST)
	public @ResponseBody Registration saveRegistrationForApp(@RequestBody Registration getContactList) {

		Registration registrationList = new Registration();
		try {

			registrationList = registrationRepo.save(getContactList);
			registrationList.setUserPassword("");
			registrationList.setSmsCode("");

		} catch (Exception e) {
			registrationList = new Registration();
			e.printStackTrace();
			registrationList.setError(true);
		}
		return registrationList;

	}

	
	@RequestMapping(value = { "/saveRegForApp" }, method = RequestMethod.POST)
	public @ResponseBody Registration saveRegForApp(@RequestBody Registration reg) {

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

			studResp.setUserPassword("");
			studResp.setSmsCode("");
			// Info info1 = EmailUtility.sendMsg(otp, studResp.getMobileNumber());

			// System.err.println("Info email sent response " + info1.toString());

		} catch (Exception e) {
			System.err.println("Exce in saving Librarian " + e.getMessage());
			e.printStackTrace();
		}

		return reg;

	}

	

	public Info checkToken(String token, int regId) throws IOException {

		Info info = new Info();

		try {
			Registration res = registrationRepo.findByExVar2AndRegIdAndDelStatus(token, regId, 1);

			if (res == null) {
				info.setError(true);
				info.setMsg("token not matched");
			} else {
				info.setError(false);
				info.setMsg("authorized user");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("token not match");
		}
		return info;
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
	
	
	@RequestMapping(value = { "/verifyOtpResponseForApp" }, method = RequestMethod.POST)
	public @ResponseBody OtpResponse verifyOtpResponseForApp(@RequestParam("userOtp") String userOtp,
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
					
					// otpRespose.setReg(reg1);
				} else {
					// int updateDate = registrationRepo.updateSmsStatus(0,regResponse.getRegId());
					otpRespose.setError(true);
					otpRespose.setMsg("password Wrong");
				}
				regResponse.setUserPassword("");
				regResponse.setSmsCode("");
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

	@RequestMapping(value = { "/verifyResendOtpResponseForApp" }, method = RequestMethod.POST)
	public @ResponseBody OtpResponse verifyResendOtpResponseForApp(@RequestParam("uuid") String uuid) {

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
					// otpRespose.setReg(reg1);
					
					reg1.setUserPassword("");
					reg1.setSmsCode("");
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
	
	
	@RequestMapping(value = { "/getRegUserDetailbyRegIdForApp" }, method = RequestMethod.POST)
	public @ResponseBody RegistrationUserDetail getRegUserDetailbyRegIdForApp(@RequestParam("regId") int regId,
			@RequestParam("token") String token) {

		RegistrationUserDetail secSaveResponse = new RegistrationUserDetail();

		try {

			Info info = checkToken(token, regId);
			if (info.isError() == false) {
				secSaveResponse.setMsg("Found");
				secSaveResponse = registrationUserDetailRepo.getRegUserDetailbyRegId(regId);
				secSaveResponse.setUserPassword("");
				secSaveResponse.setSmsCode("");
				secSaveResponse.setError(false);

			} else {
				secSaveResponse.setError(true);
			}

		} catch (Exception e) {

			e.printStackTrace();
			secSaveResponse.setError(true);
			secSaveResponse.setMsg("Unauthorized User");
		}
		return secSaveResponse;
	}
	
	
	@RequestMapping(value = { "/loginFrontEndForApp" }, method = RequestMethod.POST)
	public @ResponseBody Registration loginFrontEndForApp(@RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("token") String token) {

		Registration regResponse = new Registration();

		try {

			regResponse = registrationRepo.loginProcess(userName, password);

			if (regResponse != null) {

				int updateToken = registrationRepo.updateToken(token, regResponse.getRegId());
				regResponse.setError(false);
				regResponse.setMsg("Successful Login");
 				
			} else {
				regResponse = new Registration();
				regResponse.setError(true);
				regResponse.setMsg("Invalid Credencials");
			}
			regResponse.setUserPassword("");
			regResponse.setSmsCode("");
		} catch (Exception e) {

			System.err.println("Exce in getSection @MasterController " + e.getMessage());
			e.printStackTrace();
			regResponse = new Registration();
			regResponse.setError(true);
			regResponse.setMsg("Invalid Credencials");
		}
		return regResponse;

	}

	
	
	@RequestMapping(value = { "/changePasswordForApp" }, method = RequestMethod.POST)
	public @ResponseBody InfoNew changePasswordForApp(@RequestParam("regId") String regId,
			@RequestParam("password") String password, @RequestParam("token") String token) {
		InfoNew errorMessage = new InfoNew();
		try {
			Info info = checkToken(token, Integer.parseInt(regId));
			if (info.isError() == false) {
				errorMessage.setRetmsg("Found");
				int isUpdate = registrationRepo.updatePasswordByRegId(regId, password);

				if (isUpdate >= 1) {

					errorMessage.setError(false);
					errorMessage.setMsg("Updated Password Successfully");
				} else {
					errorMessage.setError(true);
					errorMessage.setMsg("Password Failed to update");
				}

			} else {

				errorMessage.setRetmsg("Unauthorized User");
				errorMessage.setError(true);
				errorMessage.setMsg("Password Failed to update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setRetmsg("Not Found");
			errorMessage.setError(true);
			errorMessage.setMsg("Password Failed to update");

		}

		return errorMessage;
	}

	
	
	@RequestMapping(value = { "/getFeedbackByUserIdAndNewsblogsIdForApp" }, method = RequestMethod.POST)
	public @ResponseBody EventRegistrationForApp getFeedbackByUserIdAndNewsblogsIdForApp(
			@RequestParam("userId") int userId, @RequestParam("newsblogsId") int newsblogsId,
			@RequestParam("token") String token) {
		EventRegistration secSaveResponse = new EventRegistration();
		EventRegistrationForApp secSaveResponseApp = new EventRegistrationForApp();
		try {
			Info info = checkToken(token, userId);
			if (info.isError() == false) {

				secSaveResponse = eventRegRepo.findByUserIdAndNewsblogsIdAndDelStatus(userId, newsblogsId, 1);

				secSaveResponseApp.setError(true);
				secSaveResponseApp.setMessage("Found");
				try {
					secSaveResponseApp.setApprovalDate(secSaveResponse.getApprovalDate());

				} catch (Exception e) {
					secSaveResponseApp.setApprovalDate("");
				}

				try {
					secSaveResponseApp.setApproveBy(secSaveResponse.getApproveBy());
				} catch (Exception e) {

				}
				try {
					secSaveResponseApp.setDelStatus(secSaveResponse.getDelStatus());
				} catch (Exception e) {
					secSaveResponseApp.setDelStatus(1);
				}
				try {
					secSaveResponseApp.setDoc1(secSaveResponse.getDoc1());
				} catch (Exception e) {

				}
				try {
					secSaveResponseApp.setDoc2(secSaveResponse.getDoc2());
				} catch (Exception e) {

				}
				try {
					secSaveResponseApp.setExInt1(secSaveResponse.getExInt1());
				} catch (Exception e) {
					secSaveResponseApp.setExInt1(0);
				}
				try {
					secSaveResponseApp.setExInt2(secSaveResponse.getExInt2());
				} catch (Exception e) {
					secSaveResponseApp.setExInt2(0);
				}
				try {
					secSaveResponseApp.setExVar1(secSaveResponse.getExVar1());
				} catch (Exception e) {
					secSaveResponseApp.setExVar1("NA");
				}
				try {
					secSaveResponseApp.setExVar2(secSaveResponse.getExVar2());
				} catch (Exception e) {
					secSaveResponseApp.setExVar2("NA");
				}
				try {
					secSaveResponseApp.setIsActive(secSaveResponse.getIsActive());
				} catch (Exception e) {
					secSaveResponseApp.setIsActive(1);
				}

				try {
					secSaveResponseApp.setStatusApproval(secSaveResponse.getStatusApproval());
				} catch (Exception e) {
					secSaveResponseApp.setIsActive(0);
				}

				secSaveResponseApp.setEventRegId(secSaveResponse.getEventRegId());
				secSaveResponseApp.setNewsblogsId(newsblogsId);
				secSaveResponseApp.setRegDate(secSaveResponse.getRegDate());
				secSaveResponseApp.setUserId(userId);

			} else {
				secSaveResponseApp.setError(true);
				secSaveResponseApp.setMessage("Unauthorized User");
			}
		} catch (Exception e) {
			secSaveResponseApp = new EventRegistrationForApp();
			secSaveResponseApp.setError(true);
			secSaveResponseApp.setMessage("Not Found");
			e.printStackTrace();
		}
		return secSaveResponseApp;
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
	
	
	@RequestMapping(value = { "/getAppliedEventsForApp" }, method = RequestMethod.POST)
	public @ResponseBody InfoNew getAppliedEventsForApp(@RequestParam("newsblogsId") int newsblogsId,
			@RequestParam("userId") int userId, @RequestParam("token") String token) {
		InfoNew info = new InfoNew();

		try {
			Info info1 = checkToken(token, userId);
			if (info1.isError() == false) {
				info.setRetmsg("Found");

				EventRegistration reg = new EventRegistration();

				reg = eventRegRepo.findByNewsblogsIdAndUserId(newsblogsId, userId);

				if (reg == null) {
					info.setError(true);
					info.setMsg("Record Not Found");

				} else {
					info.setError(false);
					info.setMsg("Record Found");

				}
			} else {
				info.setRetmsg("Unauthorized User");
				info.setError(true);
				info.setMsg("Record Not Found");
			}
		} catch (Exception e) {

			e.printStackTrace();
			info.setRetmsg("Not Found");
			info.setError(true);
			info.setMsg("Record Not Found");
		}

		return info;

	}
	
	
	@RequestMapping(value = { "/checkPasswordByUserIdForApp" }, method = RequestMethod.POST)
	public @ResponseBody InfoNew checkPasswordByUserIdForApp(@RequestParam("userId") int userId,
			@RequestParam("pass") String pass, @RequestParam("token") String token) {
		InfoNew errorMessage = new InfoNew();
		Registration reg = new Registration();
		try {

			Info info1 = checkToken(token, userId);
			if (info1.isError() == false) {
				errorMessage.setRetmsg("Found");
				reg = registrationRepo.checkPasswordByUserId(userId, pass);

				if (reg == null) {
					errorMessage.setError(true);
					errorMessage.setMsg("Password Incorrect");
				} else {

					errorMessage.setError(false);
					errorMessage.setMsg("Password Correct");

				}
			} else {
				errorMessage.setRetmsg("Unauthorized User");
				errorMessage.setError(true);
				errorMessage.setMsg("Password Correct");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setRetmsg("Not Found");
			errorMessage.setError(true);
			errorMessage.setMsg("Password Correct");

		}

		return errorMessage;

	}
	
	

	@RequestMapping(value = { "/updateEventFeedbackForApp" }, method = RequestMethod.POST)
	public @ResponseBody InfoNew updateEventFeedbackForApp(@RequestParam("eventId") int eventId,
			@RequestParam("userId") int userId, @RequestParam("messge") String messge, @RequestParam("value") int value,
			@RequestParam("token") String token) {

		InfoNew errorMessage = new InfoNew();

		try {
			Info info = checkToken(token, userId);
			if (info.isError() == false) {
				errorMessage.setRetmsg("Found");
				int update = eventRegRepo.updateEventFeedback(eventId, userId, messge, value);

				if (update > 0) {
					errorMessage.setError(false);
					errorMessage.setMsg("updated");

				} else {
					errorMessage.setError(true);
					errorMessage.setMsg("updated failed");
				}
			} else {
				errorMessage.setRetmsg("Unauthorized User");
				errorMessage.setError(true);
				errorMessage.setMsg("updated failed");

			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setRetmsg("Not Found");
			errorMessage.setError(true);
			errorMessage.setMsg("updated failed");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/forgetPasswordForApp" }, method = RequestMethod.POST)
	public @ResponseBody Registration forgetPasswordForApp(@RequestParam("email") String email,
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
			
			regResponse.setUserPassword("");
			regResponse.setSmsCode("");

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

}
