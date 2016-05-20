package com.yl.myproject.patterns.strategy;

public class EBankStrategy implements Strategy {
	@FactoryMethod
	public Double celRecharge(Double charge, RechargeTypeEnum type) {
		// TODO Auto-generated method stub
		return charge*0.85;
	}

}
