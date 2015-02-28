/**
 * 
 */
package com.concurrency.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class WriterTask implements Runnable {
	
	private Deque<Event> deque;
	
	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}

	@Override
	public void run() {
		for(int i=0 ; i <100 ; i++){
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("This thread %s has generated an event", Thread.currentThread().getId()));
			deque.addFirst(event);
			System.out.println("Event is "+i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}