package com.concurrency.synchronize.conditions;

public class Consumer implements Runnable{
	
	private EventStorage eventStorage;
	
	public Consumer(EventStorage eventStorage){
		this.eventStorage = eventStorage;
	}
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			eventStorage.get();
		}
	}
}