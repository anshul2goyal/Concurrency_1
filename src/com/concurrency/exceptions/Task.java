/**
 * 
 */
package com.concurrency.exceptions;

/**
 * @author Anshul_Goyal
 *
 */
public class Task implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Integer.parseInt("ABC");
	}

}
