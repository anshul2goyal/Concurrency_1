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
public class DataSourceLoader implements Runnable {

	@Override
	public void run() {
		
		System.out.printf("Beginning of DataSource Loading: %s\n", new Date());
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("Exception in loading Data source");
		}
		
		System.out.printf("DataSource Loading Finished: %s\n", new Date());
	}
}