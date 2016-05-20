package com.yl.myproject.patterns.strategy;

import java.lang.reflect.InvocationTargetException;

public class Client {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 
	       Context context = new Context();
	       // �����ֵ100 ��Ҫ������
	       Double money = context.calRecharge(100D,
	              RechargeTypeEnum.E_BANK.value());
	       
	       System.out.println(RechargeTypeEnum.E_BANK.value()+"====");
	       System.out.println(money);
	 
	       // �̻��˻���ֵ100 ��Ҫ������
	       Double money2 = context.calRecharge(100D,
	              RechargeTypeEnum.BUSI_ACCOUNTS.value());
	       System.out.println(money2);
	 
	    }
}
