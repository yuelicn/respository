package com.yl.myproject.patterns.singleton;
/**
 * 
 * ClassName: Singleton 
 * @Description: ����ģʽ
 * @author yue.li3
 * @date 2016��4��12��
 */
public class Singleton {
	/**
	 * 
	 * <p>˽�л����췽������ֹ�ⲿʵ�� </p>
	 */
	private  Singleton() {
	}
	/**
	 * 
	 * ClassName: SingletonFactory 
	 * @Description: ʹ���ڲ�����ά������ JVM ����ع�����̻߳����
	 * @author yue.li3
	 * @date 2016��4��12��
	 */
	private static class SingletonFactory{
		private static Singleton instance = new Singleton();
		
	}
	/**
	 * 
	 * @Description: ��ȡʵ��
	 * @param @return   
	 * @return Singleton  
	 * @throws
	 * @author yue.li3
	 * @date 2016��4��12��
	 */
	public static Singleton getInstance(){
		
		return SingletonFactory.instance;
	}
	
}
