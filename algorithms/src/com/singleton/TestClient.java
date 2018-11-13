package com.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClient {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(new A());
		executorService.submit(new B());
	}

}
