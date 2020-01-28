package com.ats.rusawebapi.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;

import com.ats.rusawebapi.model.Registration;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.RegistrationRepo;

public class LastUpdatedSiteDate {

	/*@Autowired
	static
	RegistrationRepo registrationRepo;*/
	
	public static String updateDate() throws IOException {

		SimpleDateFormat sf = new SimpleDateFormat("dd MMM,yyyy | hh:mm:ss a z ", Locale.ENGLISH);
		sf.setTimeZone(TimeZone.getTimeZone("IST"));

		String date = sf.format(new Date());
		System.out.println(date);

		return date;
	}

	/*public static Info checkToken(String token,int regId) throws IOException {

		Info info = new Info();

		try {
			Registration res = registrationRepo.findByExVar2AndRegIdAndDelStatus(token, regId,1);
			
			if(res==null) {
				info.setError(true);
				info.setMsg("token not matched");
			}else {
				info.setError(false);
				info.setMsg("authorized user");
			}
			
		} catch (Exception e) {
			info.setError(true);
			info.setMsg("token not match");
		}
		return info;
	}*/
}
