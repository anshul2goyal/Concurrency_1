package com.concurrency.locks;

public class PrintJob implements Runnable {
	
	private PrintQueue printQueue;
	
	public PrintJob(PrintQueue printQueue){
		this.printQueue  = printQueue;
	}
	
	public void run(){
		System.out.printf("%s : Going to print a document \n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s : Document is printed \n", Thread.currentThread().getName());
	}
}