package com.yl.myproject.patterns.template.template1;

public  class CofeTemplate extends RefreshBeverage {

	@Override
	protected void brew() {
		System.out.println("开始冲咖啡");

	}
	@Override
	protected void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("添加牛奶");

	}

}
