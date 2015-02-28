/**
 * 
 */
package com.concurrency.threadgroups;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class SearchTask implements Runnable{
	
	private Result result;
	
	public SearchTask(Result result){
		this.result = result;
	}
	
	@Override
	public void run(){
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: Start\n", name);
		
		try{
			doTask(name);
			result.setName(name);
		}catch(InterruptedException exception){
			System.out.printf("Thread %s is interrupted : ", name);
		}
		
		System.out.printf("Thread %s has ended", name);
	}
	
	private void doTask(String name) throws InterruptedException{
		Random random = new Random(new Date().getTime());
		int value = (int) (random.nextDouble()*100);
		System.out.printf("Thread %s : %d\n", name,value);
		
		TimeUnit.SECONDS.sleep(value);
	}
}
