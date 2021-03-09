package com.controller;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyCustomRemoteEvent extends RemoteApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public MyCustomRemoteEvent(Object source, String origin, String message) {
		super(origin,message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public MyCustomRemoteEvent setMessage(String message) {
		this.message = message;
		return this;
	}
	
}
