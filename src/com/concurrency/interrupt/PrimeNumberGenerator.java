/**
 * 
 */
package com.concurrency.interrupt;

/**
 * @author Anshul_Goyal
 *
 */
public class PrimeNumberGenerator extends Thread {
	
	public void run(){
		long number = 1L;
		while(isPrime(number)){
			System.out.printf("Number %d is Prime\n",number);
			if(isInterrupted()){
				System.out.printf("The Prime Number generator has been interrupted");
				return;
			}
			number++;
		}
	}
	
	private boolean isPrime(long number){
		
		if(number <= 2){
			return true;
		}
		
		for(long i=2; i<number ;i++){
			
			if((number % i) == 0){
				return false;
			}
		}
		
		return true;
	}
}