package com.concurrency.lock.fairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	//fairness parameter as true
	private Lock queueLock = new ReentrantLock(true);
	
	public void printJob(Object docuument){
		queueLock.lock();
		try {
			Long duration = (long) (Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue: Printing a Job during "+(duration/1000)+" seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			queueLock.unlock();
		}
		
		queueLock.lock();
		try {
			Long duration = (long) (Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue: Printing a Job during "+(duration/1000)+" seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			queueLock.unlock();
		}
	}
}
