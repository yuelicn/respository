package com.yl.myproject.https;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.yl.myproject.https.MyX509TrustManager;


public class HttpsRequest{

    public interface ResultListener {

        public void onConnectionPoolTimeoutError();

    }


    //表示请求器是否已经做了初始化工作
    private boolean hasInit = false;

    //连接超时时间，默认10秒
    private int socketTimeout = 10000;

    //传输超时时间，默认30秒
    private int connectTimeout = 30000;

    //请求器的配置
    private RequestConfig requestConfig;

    //HTTP请求器
    private CloseableHttpClient httpClient;

    public HttpsRequest() throws Exception {
        init();
    }

    private void init() throws Exception {
    
    	//指定读取证书格式为PKCS12
        KeyStore keyStore = KeyStore.getInstance("JKS");
        //指定读取证书格式为PKCS12
        FileInputStream instream = new FileInputStream(new File("F:/Work/vianer/server.keystore"));//加载本地的证书进行https加密传输
        try {
        	//指定PKCS12的密码(商户ID)
            keyStore.load(instream, "shdx123456".toCharArray());//设置证书密码
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
      
	//	SSLContext sslContent = SSLContext.getInstance("SSL", "SunJSSE");
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContent = SSLContext.getInstance("SSL", "SunJSSE");

        // SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, "shdx123456".toCharArray())
       //         .build();
        // Allow TLSv1 protocol only（指定TLS的版本号）
		sslContent.init(null, tm, new SecureRandom());

		//SSLSocketFactory sslsf = sslContent.getSocketFactory();
		 SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				 sslContent,
                null,
                null,new X509HostnameVerifier() {
					
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
				}
              );
        
       //设置httpclient的SSLSocketFactory
        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();

        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

    /**
     * 通过Https往API post xml数据
     *
     * @param url    API地址
     * @param xmlObj 要提交的XML数据对象
     * @return API回包的实际数据
     * @throws IOException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */

    public String sendPost(String url, Object xmlObj) throws Exception, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        if (!hasInit) {
            init();
        }

        String result = null;

       // HttpPost httpPost = new HttpPost(url);
        HttpGet httpPost = new HttpGet(url);
        
        //解决XStream对出现双下划线的bug
     //   XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));

        //将要提交给API的数据对象转换成XML格式数据Post给API
        String postDataXML = "hello";


        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
    //    httpPost.addHeader("Content-Type", "text/xml");
    //    httpPost.setEntity(postEntity);

        //设置请求器的配置
        httpPost.setConfig(requestConfig);

    //    Util.log("executing request" + httpPost.getRequestLine());

        try {
        	//DefaultHttpClient httpClient1 = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (ConnectionPoolTimeoutException e) {
           System.out.print("http get throw ConnectionPoolTimeoutException(wait time out)");

        } catch (ConnectTimeoutException e) {
           System.out.print("http get throw ConnectTimeoutException");

        } catch (SocketTimeoutException e) {
           System.out.print("http get throw SocketTimeoutException");

        } catch (Exception e) {
          System.out.print("http get throw Exception"+e);
        } finally {
            httpPost.abort();
        }

        return result;
    }

    /**
     * 设置连接超时时间
     *
     * @param socketTimeout 连接时长，默认10秒
     */
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        resetRequestConfig();
    }

    /**
     * 设置传输超时时间
     *
     * @param connectTimeout 传输时长，默认30秒
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        resetRequestConfig();
    }

    private void resetRequestConfig(){
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
    }

    /**
     * 允许商户自己做更高级更复杂的请求器配置
     *
     * @param requestConfig 设置HttpsRequest的请求器配置
     */
    public void setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }   
    
    public static void main(String[] args) throws Exception, IOException {
    	HttpsRequest http = new HttpsRequest();
    	String retult =http.sendPost("https://222.68.185.223:7800/openit/class_7?ServiceName=ComplexOrderORQueryFlow&ServiceVer=1.0&Consumer=shijihulian",new Object());
	System.out.println(retult);
    
    
    }
}
