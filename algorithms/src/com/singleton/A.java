package com.singleton;

public class A implements Runnable{
	
	private Singleton singleton;
	
	public A() {
		singleton = Singleton.get();
	}

	@Override
	public void run() {
		System.out.println("from A: "+singleton);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("from A: "+singleton);
		
	}
	
	

}
