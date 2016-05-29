package com.yl.myproject.patterns.template.template1;

public abstract class RefreshBeverage {

	/**
	 * 制备饮料的模板方法
	 * 定义模板方法的算法骨架
	 * 封装了所有子类遵循的算法骨架
	 */
	public final void prepareBeverage(){
		/**
		 * 步骤1：将水煮沸
		 */
		boilWater();
		/**
		 * 步骤2：炮制饮料
		 */
		brew();
		/**
		 * 步骤3：将饮料倒入杯中
		 */
		pourInCup();
		/**
		 * 步骤4：添加调料
		 */
		
		if(isCustemWantCondiments()){
			
			addCondiments();
		}
		
		
	}
	
	/**
	 * 添加钩子算法， 让子类实现
	 * @return
	 */
	protected boolean isCustemWantCondiments() {
		// TODO Auto-generated method stub
		return true;
	}


	private void boilWater() {
		// TODO Auto-generated method stub
		System.out.println("将水煮沸");
		
	}

	private void pourInCup() {
		// TODO Auto-generated method stub
		System.out.println("将饮料倒入杯中");
		
	}
	
	protected abstract void brew();
	
	protected abstract void addCondiments();
}
