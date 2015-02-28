/**
 * 
 */
package com.concurrency.readwrite.locks;

/**
 * @author Anshul_Goyal
 *
 */
public class Writer implements Runnable{
	
	private PricesInfo pricesInfo;
	
	public Writer(PricesInfo pricesInfo){
		this.pricesInfo = pricesInfo;
	}
	
	@Override
	public void run(){
		for(int i=0;i<3;i++){
			System.out.printf("Writer : Attemp to modify the prices. \n");
			pricesInfo.setPrices(Math.random()*8, Math.random()*10);
			System.out.printf("Writer : Prices have been modified. \n");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}