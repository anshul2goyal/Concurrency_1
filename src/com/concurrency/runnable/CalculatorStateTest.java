package com.concurrency.runnable;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class CalculatorStateTest implements Closeable{

	public static void main(String[] args) {
		
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		
		// Create 10 threads with different names and set priority of 5 threads as Maximum and 5 as Minimum
		for(int i=0;i<10;i++){
			
			threads[i] = new Thread(new Calculator(i));
			
			if((i%2)==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread"+i);
		}
		
		// Create the file writer object
		try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\_workspaces\\logs\\thread.txt"))) {
			
			//Write the status of threads onto the file
			for(int i=0;i<10;i++){
				writer.println("Main : Status of thread "+ i +":" + threads[i].getState());
				status[i] = threads[i].getState();
			}
			
			// Start Executing the threads
			for(int i=0;i<10;i++){
				threads[i].start();
			}
			
			//Check the status of the thread
			boolean finish = false;
			while(!finish){
				for(int i=0;i<10;i++){
					if(threads[i].getState() != status[i]){
						writeThreadInfo(writer, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}	
				finish = true;
				writer.flush();
				for(int i=0;i<10;i++){
					finish=finish && threads[i].getState() == State.TERMINATED;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
		pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
		pw.printf("Main : Priority: %d\n",thread.getPriority());
		pw.printf("Main : Old State: %s\n",state);
		pw.printf("Main : New State: %s\n",thread.getState());
		pw.printf("Main : ************************************\n");
	}

	@Override
	public void close() throws IOException {
		System.out.println("Closed the printwriter");
	}

}
