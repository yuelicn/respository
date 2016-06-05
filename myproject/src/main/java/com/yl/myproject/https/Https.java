package com.yl.myproject.https;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Https {
public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
	// 创建URL对象
	URL myURL = new URL("https://222.68.185.223:7800/openit/class_7");

	// 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
	HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
	//httpsConn.setHostnameVerifier(v);
	HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());
	// 取得该连接的输入流，以读取响应内容
	InputStreamReader insr = new InputStreamReader(httpsConn
	.getInputStream());

	// 读取服务器的响应内容并显示
	int respInt = insr.read();
	while (respInt != -1) {
	System.out.print((char) respInt);
	respInt = insr.read();
	}
}
}