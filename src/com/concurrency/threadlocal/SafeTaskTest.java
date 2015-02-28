/**
 * 
 */
package com.concurrency.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class SafeTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SafeTask safeTask = new SafeTask();
		
		for(int i=0;i<10;i++){
			Thread thread = new Thread(safeTask);
			thread.start();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
