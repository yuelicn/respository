package com.yl.myproject.date;

import java.util.Date;

import junit.framework.TestCase;

public class DateUtilTest extends TestCase {
		
		//hyphen 意思是 -
		//slash  意思 /
		
		
		/**
		 * 时间格式： yyyy-MM-dd HH:mm:ss
		 */
		public final static String PATTERN_HYPHEN_YYYYMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
		/**
		 * 时间格式： yyyy/MM/dd HH:mm:ss
		 */
		public final static String PATTERN_SLASH_YYYYMMddHHmmss = "yyyy/MM/dd HH:mm:ss";
		
	
	
	
	public void testGetStringCurrentTime() {
		
		String StringFromatDate =DateUtil.getStringCurrentTime(PATTERN_HYPHEN_YYYYMMddHHmmss);
		
		String StringFromatDate1 =DateUtil.getStringCurrentTime(PATTERN_SLASH_YYYYMMddHHmmss);

		System.out.println("返回String格式当前时间yyyy-mm-dd HH:mm:ss--->"+StringFromatDate);
		System.out.println("返回String格式当前时间yyyy/mm/dd HH:mm:ss--->"+StringFromatDate1);

	}

	public void testGetDateCurrentTime() {
		
		Date DateFromatDate =DateUtil.getDateCurrentTime(DateUtil.PATTERN_HYPHEN_YYYYMMddHHmmss);

		System.out.println("返回Date格式当前时间yyyy-mm-dd HH:mm:ss--->"+DateFromatDate);

	}

	public void testGetDateToString() {
		
		String dateToString =DateUtil.getDateToString(new Date(),DateUtil.PATTERN_HYPHEN_YYYYMMddHHmmss);
		
		System.out.println("DateToString："+dateToString);
		
	}

	public void testGetStringToDate() {
		
		Date StringToDate =DateUtil.getStringToDate("2016-05-05 12:37:33",DateUtil.PATTERN_HYPHEN_YYYYMMddHHmmss);
		
		System.out.println("StringToDate："+StringToDate);
		
	}

	public void testGetStringCurrentHours() {
		
		String hours = DateUtil.getStringCurrentHours();
		
		System.out.println("getStringCurrentHours:"+hours);

	}

}
