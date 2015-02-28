/**
 * 
 */
package com.concurrency.daemon;

import java.util.Date;

/**
 * @author Anshul_Goyal
 *
 */
public class Event {
	
	private Date date;
	private String event;
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}
}