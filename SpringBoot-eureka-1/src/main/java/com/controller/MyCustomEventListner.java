package com.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyCustomEventListner implements ApplicationListener<MyCustomRemoteEvent>{

	@Override
	public void onApplicationEvent(MyCustomRemoteEvent event) {
		System.out.println("received");
		
	}

}
