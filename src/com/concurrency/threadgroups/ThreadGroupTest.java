package com.concurrency.threadgroups;

import java.util.concurrent.TimeUnit;

/**
 * @author Anshul_Goyal
 *
 */
public class ThreadGroupTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("Searchers");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);

		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(group, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Number of threads :%d\n", group.activeCount());
			System.out.printf("Information about thread group \n");
			group.list();

			// Find how many Thread objects are associated with Thread group
			Thread[] threads = new Thread[group.activeCount()];
			group.enumerate(threads);
			/*for (int j = 0; j < group.activeCount(); j++) {
				System.out.printf("Threads %s: %s", threads[i].getName(),
						threads[i].getState());
			}*/
			waitFinish(group);
			group.interrupt();

		}
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}