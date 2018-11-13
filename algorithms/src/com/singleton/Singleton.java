package com.singleton;

public class Singleton {
	
	private Singleton() {
		
	}
	private static Singleton singleton;
	private static final Object lock = new Object();
	public static Singleton get() {
		if(singleton == null) {
			synchronized (lock) {
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

}
