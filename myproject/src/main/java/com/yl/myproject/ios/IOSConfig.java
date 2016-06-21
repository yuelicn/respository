package com.yl.myproject.ios;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
/**
 * 
 * ClassName: IOSConfig 
 * @Description: 
 * @author yue.li3
 * @date 2016年5月12日
 */
public class IOSConfig {
	static String url =IOSConfig.class.getResource("/").getPath();
	private final static String IOS_PATH = url+"META-INF/iso/ProUrl.properties";

	private static Properties isoConfig = null;

	static {
		if (isoConfig == null) {
			loadIsoConfig();
		}
	}

	private static void loadIsoConfig() {
		InputStream inStream = null;
		try {
			inStream = new BufferedInputStream(new FileInputStream(new File(IOS_PATH)));
			isoConfig = new Properties();
			isoConfig.load(inStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getValue(String key) {
		return url + (isoConfig.getProperty(key) == null ? "" : isoConfig.getProperty(key).trim());
	}
	
	public static String getDefaultValue(String key,String defaultValue){
		
		String retrunKey = isoConfig.getProperty(key) == null ? "" : isoConfig.getProperty(key).trim();
		
		return StringUtils.isEmpty(retrunKey)?defaultValue:retrunKey;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(getValue("p12"));
	}
	
	
	
}
