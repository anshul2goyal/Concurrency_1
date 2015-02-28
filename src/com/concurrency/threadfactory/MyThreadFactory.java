package com.concurrency.threadfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @author Anshul_Goyal
 *
 */
public class MyThreadFactory implements ThreadFactory{
	
	private int counter;
	private String name;
	private List<String> stats;
	
	public MyThreadFactory(String name) {
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}
	
	@Override
	public Thread newThread(Runnable r) {
		
		Thread thread = new Thread(r, name+"-Thread_"+counter);
		counter++;
		stats.add(String.format("Created thread %d with the name %s on %s \n", thread.getId(),thread.getName(),new Date()));

		return thread;
	}
	
	public String getStats(){
		StringBuffer buffer = new StringBuffer();
		for(String stat : stats){
			buffer.append(stat);
			buffer.append("\n");
		}
		
		return buffer.toString();
	}

}
