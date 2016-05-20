package com.yl.myproject.patterns.adapter.objectadapter;



public class Adapter implements Targetable {

	private Source source;
	
	
	Adapter(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method1() {
		System.out.println("this is the targetable method!"); 

	}

	@Override
	public void method2() {
		source.method1();

	}

}
