package com.concurrency.readwrite.locks;

public class PricesInfoTest {

	public static void main(String[] args) {
		PricesInfo info = new PricesInfo();
		
		//Create five readers and five threads
		Reader[] readers = new Reader[5];
		Thread threadReaders[] = new Thread[5];
		
		for(int i=0; i<5 ;i++){
			readers[i] = new Reader(info);
			threadReaders[i] = new Thread(readers[i]);
		}
		
		Writer writer = new Writer(info);
		Thread threadWriter = new Thread(writer);
		
		for(int i=0; i<5 ;i++){
			threadReaders[i].start();
		}
		threadWriter.start();
	}

}
