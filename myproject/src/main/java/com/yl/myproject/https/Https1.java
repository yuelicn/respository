package com.yl.myproject.https;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;



public class Https1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
		// TODO Auto-generated method stub
		DefaultHttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(ClientPNames.COOKIE_POLICY,CookiePolicy.BROWSER_COMPATIBILITY);
		client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "	Mozilla/5.0 (Windows NT 6.2; rv:18.0) Gecko/20100101 Firefox/18.0");
		String PostFir = "https://222.68.185.223:7800/openit/class_7?ServiceName=ComplexOrderORQueryFlow&ServiceVer=1.0&Consumer=shijihulian";
		//获得密匙库
		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		FileInputStream instream = new FileInputStream(new File("F:/Work/vianer/server.keystore"));
		//密匙库的密码
		trustStore.load(instream, "shdx123456".toCharArray());
		//注册密匙库
		SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);
		//不校验域名
		socketFactory.setHostnameVerifier(new X509HostnameVerifier() {
			
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void verify(String arg0, X509Certificate arg1) throws SSLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void verify(String arg0, SSLSocket arg1) throws IOException {
				// TODO Auto-generated method stub
				
			}
		});
		Scheme sch = new Scheme("https", 443, socketFactory);
		client.getConnectionManager().getSchemeRegistry().register(sch);
		HttpPost httppost1 = new HttpPost(PostFir);
		HttpResponse response1 = client.execute(httppost1);
		HttpEntity resEntity1 = response1.getEntity();
		System.out.println(EntityUtils.toString(resEntity1,"gbk"));
		}
	}

