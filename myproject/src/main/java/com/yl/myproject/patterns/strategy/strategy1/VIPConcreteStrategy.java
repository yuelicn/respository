package com.yl.myproject.patterns.strategy.strategy1;
/**
 * 
 * ClassName: VIPConcreteStrategy 
 * @Description: VIP
 * @author yue.li3
 * @date 2016年5月31日
 */
public class VIPConcreteStrategy implements Strategy {

	@Override
	public double getPrice(double price) {
		// TODO Auto-generated method stub
		return 0.5*price;
	}

}
