package com.concurrency.readwrite.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Anshul_Goyal
 *
 */
public class PricesInfo {
	
	private double price1;
	private double price2;
	private ReadWriteLock readWriteLock;
	
	public PricesInfo(){
		price1 = 1.0;
		price2 = 2.0;
		readWriteLock = new ReentrantReadWriteLock();
	}
	
	public double getPrice1(){
		readWriteLock.writeLock().lock();
		double value = price1;
		readWriteLock.writeLock().unlock();
		return value;
	}
	
	public double getPrice2(){
		readWriteLock.writeLock().lock();
		double value = price2;
		readWriteLock.writeLock().unlock();
		return value;
	}
	
	public void setPrices(double price1, double price2){
		
		readWriteLock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		readWriteLock.writeLock().unlock();
	}
}