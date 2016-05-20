package com.yl.myproject.patterns.observer;

import org.junit.Test;

public class TestPatterns {
	
	
	
	@Test
	public void testObserver(){
		
		House house = new House(10000);
		HomeBuyers001 hop1 = new HomeBuyers001("������1��");
		HomeBuyers002 hop2 = new HomeBuyers002("������1��");
		
		house.addObserver(hop1);
		house.addObserver(hop2);
		
		System.out.println("���ӵļ۸�"+hop1.toString());
		
		house.setPrice(20000);
		System.out.println("���ӵļ۸�1��"+hop2.toString());
		
		
		      /*  Watched girl = new ConcreteWatched();
		        
		        Watcher watcher1 = new ConcreteWatcher();
		        Watcher watcher2 = new ConcreteWatcher();
		        Watcher watcher3 = new ConcreteWatcher();
		        
		        girl.addWatcher(watcher1);
		        girl.addWatcher(watcher2);
		        girl.addWatcher(watcher3);
		        
		        girl.notifyWatchers("����");*/
		
		
		
	}
	
	
	
	

}
