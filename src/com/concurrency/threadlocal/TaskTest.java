package com.concurrency.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class TaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UnSafeTask unSafeTask = new UnSafeTask();
		
		for(int i=0;i<10;i++){
			Thread thread = new Thread(unSafeTask);
			thread.start();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}

}
