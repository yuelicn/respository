package com.yl.myproject.patterns.strategy.strategy1;
/**
 * 
 * ClassName: JuniorConcreteStrategy 
 * @Description: 初级会员
 * @author yue.li3
 * @date 2016年5月31日
 */
public class JuniorConcreteStrategy implements Strategy {
	
	@Override
	public double getPrice(double price) {
		return 0.8*price;
	}

}
