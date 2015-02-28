package com.concurrency.exceptions;

public class ExceptionTest {

	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		//This unchecked exception will invoke the Exception Handler class created.
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}
