package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudController {

	
	private ApplicationContext applicationContext;
	
	@Autowired
	public CloudController(ApplicationContext applicationContext) {
		this.applicationContext=applicationContext;
	}
	
	@RequestMapping(value="/publish",method = RequestMethod.PUT)
	public String publish() {
		final String uid = applicationContext.getId();
		MyCustomRemoteEvent customRemoteEvent= new MyCustomRemoteEvent(this, uid, "hello");
		applicationContext.publishEvent(customRemoteEvent);
		return "success";
	}
}
