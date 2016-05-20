package com.yl.myproject.patterns.singleton;
/**
 * 
 * ClassName: Singleton1 
 * @Description: ˫���� 
 * @author yue.li3
 * @date 2016��4��12��
 */
public class Singleton1 {
	/**
	 * ˽�о�̬ʵ�� ����ֹ�����ã� ��ֵΪ�գ� Ϊ��ʵ���ӳټ���
	 */
	private static Singleton1 instance = null;
	/**
	 * 
	 * <p>˽�й��췽���� ��ֹ��ʵ�� </p>
	 */
	private Singleton1() {
	}
	
	public static Singleton1 getInstance(){
		if(instance == null){
			synchronized (instance) {
				if(instance ==null){
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}
	/**
	 * �˷����� ��JVM �Ƕ���˵�� �ڶ��߳������п��ܳ�������ģ�
	 *  JVM �� �������ʵ��͸�ֵ���Ƿ�Ϊ�����ģ� ��û���ض���˳��
	 *  instance = new Singleton1(); �Ƿ�Ϊ�����ġ�
	 *  �п����ڶ���ûʵ�������£��Ѿ���ֵ����instance �ˣ� 
	 * 
	 */
	

}
