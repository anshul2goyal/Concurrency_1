/**
 * 
 */
package com.concurrency.interrupt;

import java.io.File;

/**
 * @author Anshul_Goyal
 *
 */
public class FileSearch implements Runnable {
	
	private String initPath;
	private String fileName;
	
	public FileSearch(String initPath, String fileName){
		this.initPath = initPath;
		this.fileName = fileName;
	}
	
	@Override
	public void run(){
		
		File file = new File(initPath);
		
		if(file.isDirectory()){
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s : Current thread is interrupted", Thread.currentThread().getName());
			}
		}
	}
	
	private void directoryProcess(File file) throws InterruptedException{
		File fileList[] = file.listFiles();
		
		for(File file2 : fileList){
			if(file2.isDirectory()){
				directoryProcess(file2);
			}else {
				fileProcess(file2);
			}
		}
		
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
	}
	
	private void fileProcess(File file) throws InterruptedException{
		if(file.getName().equals(fileName)){
			System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
	}
}