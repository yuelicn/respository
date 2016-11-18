package com.yl.myproject.httpclient.https;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;



public class HttpsClienUtil{

    public interface ResultListener {

        public void onConnectionPoolTimeoutError();

    }
	protected static final Logger logger = LoggerFactory.getLogger(HttpsClienUtil.class);


    //表示请求器是否已经做了初始化工作
    private static boolean hasInit = false;

    //连接超时时间，默认10秒
    private static int socketTimeout = 10000;

    //传输超时时间，默认30秒
    private static int connectTimeout = 30000;

    //请求器的配置
    private static RequestConfig requestConfig;

    //HTTP请求器
    private static CloseableHttpClient httpClient;

    public HttpsClienUtil() throws Exception {
        init();
    }

    private static void init() throws Exception {
   
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContent = SSLContext.getInstance("SSL", "SunJSSE");

		sslContent.init(null, tm, new SecureRandom());

		 SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				 sslContent,null,null,new X509HostnameVerifier() {
					
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
        httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

	/**
	 * 
	 * @Description: https 发送请求 
	 * @param @param url
	 * @param @param body
	 * @param @param headerParams
	 * @param @return
	 * @param @throws Exception
	 * @param @throws KeyStoreException
	 * @param @throws UnrecoverableKeyException
	 * @param @throws NoSuchAlgorithmException
	 * @param @throws KeyManagementException   
	 * @return String  
	 * @throws
	 * @author yue.li3
	 * @date 2016年6月6日
	 */
    public static String sendPost(String url, String body,List<NameValuePair> headerParams) throws Exception, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        if (!hasInit) {
            init();
        }

        String result = null;

       HttpPost httpPost = new HttpPost(url);

        String postData = body;

        StringEntity postEntity = new StringEntity(postData, "UTF-8");
    	if (headerParams != null) {
			for (NameValuePair param : headerParams) {
				if (param != null && param.getName() != null && param.getValue() != null) {
					httpPost.setHeader(param.getName(), param.getValue());
				}
			}
		}

        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
        
        httpPost.setEntity(postEntity);

        //设置请求器的配置
        httpPost.setConfig(requestConfig);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (ConnectionPoolTimeoutException e) {
          logger.error("http get throw ConnectionPoolTimeoutException(wait time out)");
        } catch (ConnectTimeoutException e) {
          logger.error("http get throw ConnectTimeoutException");

        } catch (SocketTimeoutException e) {
          logger.error("http get throw SocketTimeoutException");

        } catch (Exception e) {
         logger.error("http get throw Exception"+e);
        } finally {
            httpPost.abort();
        }
        return result;
    }
    
    
    /**
     * 
     * @Description: TODO
     * @param @param url
     * @param @param headerParams
     * @param @return
     * @param @throws Exception
     * @param @throws KeyStoreException
     * @param @throws UnrecoverableKeyException
     * @param @throws NoSuchAlgorithmException
     * @param @throws KeyManagementException   
     * @return String  
     * @throws
     * @author yue.li3
     * @date 2016年6月6日
     */
    public String sendGet(String url,List<NameValuePair> headerParams) throws Exception, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        if (!hasInit) {
            init();
        }

        String result = null;

        HttpGet httpGet = new HttpGet(url);
        

        httpGet.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
    
        //设置请求器的配置
        httpGet.setConfig(requestConfig);


        try {
        	
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (ConnectionPoolTimeoutException e) {
          logger.error("http get throw ConnectionPoolTimeoutException(wait time out)");

        } catch (ConnectTimeoutException e) {
          logger.error("http get throw ConnectTimeoutException");

        } catch (SocketTimeoutException e) {
          logger.error("http get throw SocketTimeoutException");

        } catch (Exception e) {
         logger.error("http get throw Exception"+e);
        } finally {
        	httpGet.abort();
        }

        return result;
    }
    
    
    
    

    /**
     * 设置连接超时时间
     *
     * @param socketTimeout 连接时长，默认10秒
     */
    @SuppressWarnings("static-access")
	public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        resetRequestConfig();
    }

    /**
     * 设置传输超时时间
     *
     * @param connectTimeout 传输时长，默认30秒
     */
    @SuppressWarnings("static-access")
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
    @SuppressWarnings("static-access")
	public void setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }
    
    @SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception, IOException {
    	HttpsClienUtil http = new HttpsClienUtil();
    	JSONObject json = new JSONObject();
    	json.put("sign", "234567890");
    	String retult =http.sendPost("https://recharge.service.azurenet.cn/notify/zhykNotice",json.toJSONString(),null);
	System.out.println(retult);
    
    
    }
}
