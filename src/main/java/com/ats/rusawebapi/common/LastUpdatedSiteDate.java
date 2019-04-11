package com.ats.rusawebapi.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LastUpdatedSiteDate {
	
	
	public static String updateDate() throws IOException {
	
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);

		return date;
	}
}
