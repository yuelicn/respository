package com.yl.myproject.encryption;

import static org.junit.Assert.*;

import org.junit.Test;

public class EncryptionTest {
	final String PASSWORD = "password";
	final String PASSWORD_MD5 = "5f4dcc3b5aa765d61d8327deb882cf99";
	final String PASSWORD_SHA1 = "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8";

	@Test
	public void testString2MD5() {

		String psasword = MD5.string2MD5(PASSWORD);

		assertEquals(PASSWORD_MD5, psasword);
		
	}
	@Test
	public void testSaEncode() {
		
		String a ="C20141114_E5Y3VK"+"B20141114_E5UDSK"+"36EE3D1BE055E9895B9C7888CCBD9FE986827F25DE9"+"1.1";
		System.out.println(SHA.shaEncode(a));
		
		String psasword = SHA.shaEncode(PASSWORD);

		assertEquals(PASSWORD_SHA1, psasword);
		
	}
}
