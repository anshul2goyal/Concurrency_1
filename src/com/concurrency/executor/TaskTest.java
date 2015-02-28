/**
 * 
 */
package com.concurrency.executor;

/**
 * @author Anshul_Goyal
 *
 */
public class TaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new  Server();
		for(int i=0; i<100;i++){
			Task task = new Task("Task "+i);
			server.executeTask(task);
		}
		server.endServer();
	}
}