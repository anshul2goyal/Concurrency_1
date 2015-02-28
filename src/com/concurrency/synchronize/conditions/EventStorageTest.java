package com.concurrency.synchronize.conditions;

public class EventStorageTest {

	public static void main(String[] args) {
		
		EventStorage eventStorage = new EventStorage();
		
		Producer producer = new Producer(eventStorage);
		Thread producerThread = new Thread(producer,"ProducerThread");
		
		Consumer consumer = new Consumer(eventStorage);
		Thread consumerThread = new Thread(consumer, "ConsumerThread");
		
		producerThread.start();
		consumerThread.start();
	}
}