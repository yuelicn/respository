package com.yl.myproject.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class SHA {
	/***
	 * SHA加密 生成位SHA码
	 * 
	 * @param 待加密字符串
	 * @return 返回SHA码
	 */
	public static String shaEncode(String inStr)  {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] md5Bytes = null;
		try {
			md5Bytes = sha.digest(inStr.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

}
