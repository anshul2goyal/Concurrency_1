/**
 * 
 */
package com.concurrency.synchronize.conditions;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Anshul_Goyal
 *
 */
public class EventStorage {
	
	private int maxSize;
	private List<Date> storage; 
	
	public EventStorage(){
		maxSize = 2;
		storage = new LinkedList<Date>();
	}
	
	public synchronized void set(){
		
		while(storage.size() == maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			((LinkedList<Date>)storage).offer(new Date());
			System.out.printf("Storage set :%d ", storage.size());
			notifyAll();
		}
	}
	
	public synchronized void get(){
		
		while(storage.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get :%d: %s", storage.size(), ((LinkedList<Date>)storage).poll());
		notifyAll();
	}
	
}
