package com.concurrency.interrupt;


public class ThreadInterupterTest {

	public static void main(String[] args) {
		
		Thread task = new PrimeNumberGenerator();
		task.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
	}

}
