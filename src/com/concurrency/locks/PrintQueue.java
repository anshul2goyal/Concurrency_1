/**
 * 
 */
package com.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Anshul_Goyal
 *
 */
public class PrintQueue {
	
	private final Lock queueLock = new ReentrantLock(true);
	
	public void printJob(Object document){
		queueLock.lock();
		try {
			long duration = (long)(Math.random()*10000);
			System.out.printf(Thread.currentThread().getName() + ": Printing a job in :"+(duration/1000) +" seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			queueLock.unlock();
		}
		
	}

}
