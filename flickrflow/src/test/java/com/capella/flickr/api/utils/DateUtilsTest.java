package com.capella.flickr.api.utils;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void testFormat() {
		String format = "YYYY-MM-dd";
		DateTime dateTime = DateTime.now();
		String format2 = DateUtils.format(dateTime, format);
		System.out.println(format2);
	}

}
