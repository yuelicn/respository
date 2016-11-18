package com.yl.myproject.patten;

import java.util.regex.Pattern;

public class PattenTest {

	
	public static final Pattern phone =Pattern.compile("^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$"); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "15652312203";
		long starTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			
			if(phone.matcher(name).matches()){
				//System.out.println("ertyuio");
			};
		}
		
		System.out.println(System.currentTimeMillis()-starTime);
		
		String reg = "^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$";
		long starTime1 = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			if(name.matches(reg)){
				
			}
		}
		System.out.println(System.currentTimeMillis()-starTime1);
		
		
	}

}
