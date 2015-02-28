/**
 * 
 */
package com.concurrency.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class NetworkResourceLoader implements Runnable {
	
	@Override
	public void run(){
		
		System.out.printf("Beginning of the Network Resource Loader: %s\n", new Date());
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			System.out.println("Excrption while loading Network Resource Loader");
		}
		
		System.out.printf("Network Resource Loader finished: %s\n", new Date());
	}
}