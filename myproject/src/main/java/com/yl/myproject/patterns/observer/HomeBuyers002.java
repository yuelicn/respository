package com.yl.myproject.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class HomeBuyers002 implements Observer{

private String name;
	
	
	
	
	public HomeBuyers002(String name) {
		super();
		this.name = name;
	}


	@Override
	public String toString() {
		return "HomeBuyers001 [name=" + name + "]";
	}


	public void update(Observable o, Object arg) {
		
		System.out.println(o);
		
		if(arg instanceof Double){
			System.out.println(this.name + "�۲�ļ۸���Ϊ:"  
                    + ((Double) arg).floatValue()); 
		}
		
	}


}
