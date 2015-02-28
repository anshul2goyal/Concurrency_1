package com.concurrency.synchronize.conditions;

public class Producer implements Runnable {
	
	private EventStorage eventStorage;
	
	public Producer(EventStorage eventStorage){
		this.eventStorage = eventStorage;
	}
	
	@Override
	public void run(){
		for(int i=0; i<10;i++){
			eventStorage.set();
		}
	}
}