package com.yl.myproject.patterns.template.template1;

public class RefreshBeverageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RefreshBeverage ref = new CofeTemplate();
		System.out.println("开始炮制cofe");
		ref.prepareBeverage();
		System.out.println("OK　可以品尝了　");
		
		
		System.out.println("\n ************************");
		
		RefreshBeverage ref1 = new TeaTemplate();
		System.out.println("开始炮制绿茶");
		ref1.prepareBeverage();
		System.out.println("ＯＫ　可以品尝");
	}

}
