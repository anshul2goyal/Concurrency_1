package com.concurrency.join;

import java.util.Date;

/**
 * @author Anshul_Goyal
 *
 */
public class ResourceLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DataSourceLoader dataSourceLoader = new DataSourceLoader();
		
		Thread thread = new  Thread(dataSourceLoader, "DataSourceLoaderThread");
		
		NetworkResourceLoader networkResourceLoader = new NetworkResourceLoader();
		Thread thread2 = new Thread(networkResourceLoader,"NetworkLoaderThread");
		
		thread.start();
		thread2.start();
		
		try {
			thread.join();
			thread2.join(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main : System configuration has been loaded: %s\n", new Date());	
	}
}