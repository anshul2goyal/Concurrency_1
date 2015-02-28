/**
 * 
 */
package com.concurrency.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class FileSearchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread thread = new Thread(new FileSearch("C:\\_workspaces\\", "thread.txt"));
		
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Interrupt the thread
		thread.interrupt();
	}

}
