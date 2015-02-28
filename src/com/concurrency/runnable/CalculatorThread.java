/**
 * 
 */
package com.concurrency.runnable;

/**
 * @author Anshul_Goyal
 *
 */
public class CalculatorThread extends Thread {
	
	private int number;
	
	public CalculatorThread(int nmbr){
		number = nmbr;
	}
	
	@Override
	public void run(){
		
		for(int i=1;i<=10;i++){
			System.out.format("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
		}
	}

}
