package com.yl.myproject.patterns.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
	private static StrategyFactory factory = new StrategyFactory();
	
	private StrategyFactory(){
    }
	 private static Map strategyMap = new HashMap<>();
	 
	 
	 static{
		 
		 
		   strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategy());
	       strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiCountStrategy());
		   
	 }
	 
	 public Strategy creator(Integer type){
	       return (Strategy) strategyMap.get(type);
	 }
	 public static StrategyFactory getInstance(){
	       return factory;
	 }
	
	
}
