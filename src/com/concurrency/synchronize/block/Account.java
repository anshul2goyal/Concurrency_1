package com.concurrency.synchronize.block;

/**
 * @author Anshul_Goyal
 *
 */
public class Account {
	
	private double balance;

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public synchronized void addBalance(double amount){
		
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp += amount;
		balance=tmp;
		
	}
	
	public synchronized void subtractAmount(double amount){
		double tmp = balance;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tmp -= amount;
		setBalance(tmp);
	}
}