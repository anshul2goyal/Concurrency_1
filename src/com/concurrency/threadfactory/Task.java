package com.concurrency.threadfactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class Task implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}