package com.yl.myproject.patterns.adapter.interadapter;

public class SourceSubTest {
	public static void main(String[] args) {
		Sourceable sub1 = new SourceSub1();
		Sourceable sub2 = new SourceSub2();
		sub1.method1();
		sub1.method2();
		sub2.method1();
		sub2.method2();
		
	}
}
