package com.yl.myproject.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class HomeBuyers001 implements Observer{

	private String name;
	
	
	
	
	public HomeBuyers001(String name) {
		super();
		this.name = name;
	}


	@Override
	public String toString() {
		return "HomeBuyers001 [name=" + name + "]";
	}


	public void update(Observable o, Object arg) {
		if(arg instanceof Double){
			System.out.println(this.name + "�۲�ļ۸���Ϊ:"  
                    + ((Double) arg).floatValue()); 
		}
		
	}

}
