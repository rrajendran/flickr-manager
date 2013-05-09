package com.capella.flickr.api.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {
	private static final String DEFAULT_FORMAT = "YYYY-MM-dd";

	public static String format(DateTime dateTime, String format){
		DateTimeFormatter fmt = DateTimeFormat.forPattern(format == null? DEFAULT_FORMAT : format);
		String str = fmt.print(dateTime);
		System.out.println(str);
		return str;
	}

	public static DateTime toDate(String date, String format){
		DateTimeFormatter fmt = DateTimeFormat.forPattern(format == null? DEFAULT_FORMAT : format);
		return DateTime.parse(date, fmt);
	}


}
