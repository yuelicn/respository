package com.yl.myproject.patterns.template.template1;

public class TeaTemplate extends RefreshBeverage {

	@Override
	protected void brew() {
		// TODO Auto-generated method stub
		System.out.println("添加茶叶");

	}

	@Override
	protected void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("加入柠檬");
	}

	@Override
	protected boolean isCustemWantCondiments() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
