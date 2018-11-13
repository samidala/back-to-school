package com.singleton;

public class B implements Runnable{
	
	private Singleton singleton;
	
	public B() {
		singleton = Singleton.get();
	}

	@Override
	public void run() {
		System.out.println("from B: "+singleton);
		singleton = null;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("from B: "+singleton);
		singleton = Singleton.get();
		System.out.println("from B: "+singleton);
		
	}
	
	

}
