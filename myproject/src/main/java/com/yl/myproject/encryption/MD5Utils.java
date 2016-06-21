package com.yl.myproject.encryption;

import java.security.MessageDigest;

import org.apache.commons.lang.StringUtils;

/**
 * MD5 加密工具类
 * 
 * @author yue.li3
 * @date 2016年6月21日 上午10:15:26
 */
public class MD5Utils {

	private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
			, 'A', 'B', 'C', 'D', 'E', 'F' };
	
	/**
	 * 默认utf-8 加密
	 * 
	 * @param strData
	 * @return String
	 * @author yue.li3 create to 2016年6月21日 上午10:15:52
	 */
	public final static String MD5(String strData) {
		return MD5(strData, "UTF-8");
	}

	/**
	 * 指定格式加密方法
	 * 
	 * @param strData
	 *            要加密的字符串
	 * @param charset
	 *            加密格式
	 * @return String
	 * @author yue.li3 create to 2016年6月21日 上午10:16:42
	 */
	public final static String MD5(String strData, String charset) {
		try {
			byte[] btData = StringUtils.isNotBlank(charset) ? strData.getBytes(charset) : strData.getBytes();
			return MD5(btData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * md5 加密方法
	 * 
	 * @param btData
	 * @return String
	 * @author yue.li3 create to 2016年6月21日 上午10:19:44
	 */
	private final static String MD5(byte[] btData) {
		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btData);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
