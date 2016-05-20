package com.yl.myproject.patterns.strategy;

import java.lang.reflect.InvocationTargetException;

public class Context {
	private Strategy strategy;
	   
    public Double calRecharge(Double charge, Integer type) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
       strategy = StrategyFactory.getInstance().creator(type);
       System.out.println(RechargeTypeEnum.valueOf(type)+"000");
       return strategy.celRecharge(charge, RechargeTypeEnum.valueOf(type));
    }
 
    public Strategy getStrategy() {
       return strategy;
    }
 
    public void setStrategy(Strategy strategy) {
       this.strategy = strategy;
    }
}
