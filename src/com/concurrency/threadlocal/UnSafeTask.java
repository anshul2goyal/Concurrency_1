/**
 * 
 */
package com.concurrency.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class UnSafeTask implements Runnable {
	
	private Date startDate;

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting the thread : %s : %s\n",Thread.currentThread().getId(),startDate);
		
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Thread Finished Execution :%s : %s\n", Thread.currentThread().getId(),startDate);
	}

}