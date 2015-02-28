/**
 * 
 */
package com.concurrency.sleep;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class FileClock implements Runnable {
	
	@Override
	public void run(){
		for(int i=0; i<10 ; i++){
			System.out.printf("%s \n", new Date());
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("Thr file clock has been interrupted");
			}
		}
	}

}