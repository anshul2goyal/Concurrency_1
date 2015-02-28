package com.concurrency.lock.fairness;

import com.concurrency.locks.PrintJob;
import com.concurrency.locks.PrintQueue;

public class PrintQueueTest {

	public static void main(String[] args) {
		
		PrintQueue printQueue = new PrintQueue();
		
		Thread[] threads = new Thread[10];
		
		for(int i=0;i<10;i++){
			threads[i] = new Thread(new PrintJob(printQueue), "Thread"+i);
		}
		
		for(int i=0;i<10;i++){
			threads[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}