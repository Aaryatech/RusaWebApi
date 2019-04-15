package com.ats.rusawebapi.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class LastUpdatedSiteDate {
	
	
	public static String updateDate() throws IOException {
	 
		SimpleDateFormat sf = new SimpleDateFormat("dd MMM,yyyy | hh:mm:ss a z ", Locale.ENGLISH);
		sf.setTimeZone(TimeZone.getTimeZone("IST"));
		
		String date = sf.format(new Date());
		System.out.println(date);

		return date;
	}
}
