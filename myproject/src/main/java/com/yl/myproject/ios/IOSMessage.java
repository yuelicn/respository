package com.yl.myproject.ios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class IOSMessage {
	
	protected final  Logger logger = LoggerFactory.getLogger(this.getClass());
	final static  String deviceToken = "b9fc29d1 d182765a 0e1864b6 9075e78a 65fbc9fd 34242ed9 175791a7 3a40803d";

	public static  void sendIOSMessage(String deviceToken,String message) throws Exception {
		
		try {
			// 从客户端获取的deviceToken，在此为了测试简单，写固定的一个测试设备标识。
			//String deviceToken = "b9fc29d1 d182765a 0e1864b6 9075e78a 65fbc9fd 34242ed9 175791a7 3a40803d";
			//if(logger.isInfoEnabled())logger.info("Push Start deviceToken={},message={}",deviceToken,message);
			
			//String a = new String("Hello 123455".getBytes(), "UTF-8");
			// 定义消息模式
			PayLoad payLoad = new PayLoad();
			payLoad.addAlert(message);
			payLoad.addBadge(1);// 消息推送标记数，小红圈中显示的数字。
			payLoad.addSound("default");
			// 注册deviceToken
			PushNotificationManager pushManager = PushNotificationManager.getInstance();
			pushManager.addDevice("iPhone", deviceToken);
			// 连接APNS
			String host = "gateway.sandbox.push.apple.com";
			// String host = "gateway.push.apple.com";
			int port = 2195;
			String certificatePath =IOSConfig.getValue("p12");// 前面生成的用于JAVA后台连接APNS服务的*.p12文件位置
			String certificatePassword = IOSConfig.getDefaultValue("pswd","123456");// p12文件密码。
			System.out.println(certificatePath);
			pushManager.initializeConnection(host, port, certificatePath, certificatePassword,
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			// 发送推送
			Device client = pushManager.getDevice("iPhone");
			System.out.println("推送消息: " + client.getToken() + "\n" + payLoad.toString() + " ");
			pushManager.sendNotification(client, payLoad);
			// 停止连接APNS
			pushManager.stopConnection();
			// 删除deviceToken
			pushManager.removeDevice("iPhone");
			System.out.println("Push End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		sendIOSMessage(deviceToken,"111");
	}
}
