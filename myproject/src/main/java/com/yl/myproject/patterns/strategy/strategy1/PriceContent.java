package com.yl.myproject.patterns.strategy.strategy1;

public class PriceContent {

	private Strategy strategy;

	public PriceContent(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public double getPrice(double price) {

		return this.strategy.getPrice(price);

	}

}
