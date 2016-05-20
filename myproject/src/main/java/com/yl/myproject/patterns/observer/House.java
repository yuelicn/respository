package com.yl.myproject.patterns.observer;

import java.util.Observable;
/**
 * �۲���ģʽ��ϰ
 * �۲���ģʽʹ�ã����۲�����Ҫ�̳�observable 
 * ע�����㣺 �ڴ����������ñ仯���notity���й۲���
 * �۲��ߣ���Ҫʵ��observer�ӿ� �� 
 * �����Ҫ���۲���ע���۲���
 * ClassName: House 
 * @Description: TODO
 * @author yue.li3
 * @date 2016��3��17��
 */
public class House extends Observable{
	
	
	private double price;

	public double getPrice() {
		return price;
	}

	public House(double price) {
		super();
		this.price = price;
	}

	public void setPrice(double price) {
		//���ñ仯��
		this.setChanged();
		//֪ͨ���й۲���
		this.notifyObservers(price);
		this.price = price;
	}

	@Override
	public String toString() {
		return "House [price=" + price + "]";
	}

}
