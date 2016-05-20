package com.yl.myproject.patterns.adapter.objectadapter;


public class AdapterTest {
public static void main(String[] args) {
	Source source = new Source();
	Targetable tar = new Adapter(source);
	tar.method1();
	tar.method2();
	
}
}
