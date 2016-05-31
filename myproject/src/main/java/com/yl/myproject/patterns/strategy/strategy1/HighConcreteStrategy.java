package com.yl.myproject.patterns.strategy.strategy1;
/**
 * 
 * ClassName: HighConcreteStrategy 
 * @Description: 高级会员
 * @author yue.li3
 * @date 2016年5月31日
 */
public class HighConcreteStrategy implements Strategy {

	@Override
	public double getPrice(double price) {
		// TODO Auto-generated method stub
		return 0.6*price;
	}

}
