package com.concurrency.runnable;

/**
 * @author Anshul_Goyal
 *
 */
public class CalculatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		for(int i=1; i<=10 ; i++){
			
			//Runnable Calls
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			thread.start();
			
			//Thread Class Calls
			//CalculatorThread calculator = new CalculatorThread(i);
			//calculator.start();
		}
	}

}
