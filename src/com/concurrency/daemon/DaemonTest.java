package com.concurrency.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

public class DaemonTest {

	public static void main(String[] args) {
		Deque<Event> event = new ArrayDeque<Event>();
		WriterTask writerTask = new WriterTask(event);
		for(int i=0 ; i<3 ; i++){
			Thread task = new Thread(writerTask);
			task.start();
		}
		
		CleanerTask cleanerTask = new CleanerTask(event);
		cleanerTask.start();
	}
}