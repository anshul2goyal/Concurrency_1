package com.concurrency.sleep;

import java.util.concurrent.TimeUnit;

public class FileClockTest {

	public static void main(String[] args) {
		FileClock fileClock = new FileClock();
		Thread thread = new Thread(fileClock);
		thread.start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
	}

}
