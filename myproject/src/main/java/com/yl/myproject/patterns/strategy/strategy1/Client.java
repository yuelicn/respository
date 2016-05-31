package com.yl.myproject.patterns.strategy.strategy1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HighConcreteStrategy h = new HighConcreteStrategy();
		PriceContent p = new PriceContent(h);
		double price =p.getPrice(100);
		System.out.println(price);
	}
}
