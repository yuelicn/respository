package com.yl.myproject.patterns.strategy;

public class BusiCountStrategy implements Strategy {

	public Double celRecharge(Double charge, RechargeTypeEnum type) {
		// TODO Auto-generated method stub
		return charge*0.9;
	}

}
