package com.yl.myproject.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

/**
 * 
 * ClassName: DateUtil
 * 
 * @Description: 时间工具类
 * @author yue.li3
 * @date 2016年5月5日
 */
public class DateUtil {
	// hyphen 意思是 -
	// slash 意思 /

	/**
	 * 时间格式： yyyy-MM-dd HH:mm:ss
	 */
	public final static String PATTERN_HYPHEN_YYYYMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 时间格式： yyyy/MM/dd HH:mm:ss
	 */
	public final static String PATTERN_SLASH_YYYYMMddHHmmss = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 
	 * @Description: 获取系统当前时间
	 * @param @param
	 *            pattern 时间格式
	 * @param @return
	 *            系统当前时间（指定格式）
	 * @return String
	 * @throws @author
	 *             yueli
	 * @date 2016-2-4
	 */
	public static String getStringCurrentTime(String pattern) {

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();

		String stringFormatDate = sdf.format(calendar.getTime());

		return stringFormatDate;
	}

	/**
	 * 
	 * @Description: 获取系统当前时间
	 * @param @param
	 *            pattern 时间格式
	 * @param @return
	 *            系统当前时间-指定格式
	 * @return Date
	 * @throws @author
	 *             yueli
	 * @date 2016-2-4
	 */
	public static Date getDateCurrentTime(String pattern) {

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Calendar calendar = Calendar.getInstance();

		String stringFormatDate = sdf.format(calendar.getTime());

		Date DateFormatDate = null;
		try {
			DateFormatDate = sdf.parse(stringFormatDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return DateFormatDate;
	}

	/**
	 * 
	 * @Description: 将时间格式装换成String 格式
	 * @param @param
	 *            date
	 * @param @param
	 *            pattern 指定转换格式
	 * @param @return
	 * @return String
	 * @throws @author
	 *             yueli
	 * @date 2016-2-4
	 */
	public static String getDateToString(Date date, String pattern) {

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String stringFormatDate = sdf.format(date);

		return stringFormatDate;

	}

	/**
	 * 
	 * @Description: String---->date
	 * @param @param
	 *            stringDate string 时间类型
	 * @param @param
	 *            pattern 转换格式
	 * @param @return
	 * @return Date
	 * @throws @author
	 *             yue.li3
	 * @date 2016年2月29日
	 */
	public static Date getStringToDate(String stringDate, String pattern) {

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Date dateFormatDate = null;
		try {
			dateFormatDate = sdf.parse(stringDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateFormatDate;
	}

	/**
	 * 
	 * @Description: 获取当前小时
	 * @param @param
	 *            args
	 * @return void
	 * @throws @author
	 *             yue.li3
	 * @date 2016年2月29日
	 */
	public static String getStringCurrentHours() {

		Calendar calendar = Calendar.getInstance();

		int hours = calendar.get(Calendar.HOUR_OF_DAY);

		return String.valueOf(hours);

	}
	
	/**
	 * 
	 * @Description: 将时间戳转换成String 类型时间
	 * @param @param millis
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author yue.li3
	 * @date 2016年5月12日
	 */
	private static String getDateStr(long millis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_HYPHEN_YYYYMMddHHmmss);
		String stringFormatDate = sdf.format(cal.getTime());
		System.out.println(stringFormatDate);
		return stringFormatDate;
		
		}
	
	
	public static void main(String[] args) {
	/*	int b = 1462782473;
		Date dateOld = new Date(b); // 根据long类型的毫秒数生命一个date类型的时间
 		String sDateTime = getDateToString(dateOld, PATTERN_HYPHEN_YYYYMMddHHmmss); // 把date类型的时间转换为string
 		System.out.println(System.currentTimeMillis());*/
 		System.out.println(getDateStr(320532579400l));
/*// 		System.out.println(getDateStr(1463043719000l));
// 		System.out.println("12.12.12.12".lastIndexOf("."));
 * 
*/	
 		
 		System.out.println(-1L ^ (-1L << 5));
 		System.out.println((-1L << 5));
 		System.out.println((-1L << 2));
	}
}
