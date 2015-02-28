package com.concurrency.threadfactory;

/**
 * @author Anshul_Goyal
 *
 */
public class ThreadFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		Thread thread;
		for(int i=0;i<10;i++){
			thread = myThreadFactory.newThread(task);
			thread.start();
		}
		System.out.printf("Factory stats : %s\n",myThreadFactory.getStats());
	}
}