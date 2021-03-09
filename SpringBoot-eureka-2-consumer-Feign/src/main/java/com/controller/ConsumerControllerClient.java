package com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.model.Employee;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Controller
public class ConsumerControllerClient {
	

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(value="/employee")
	public ResponseEntity<Employee> getEmployee() throws RestClientException, IOException {

		//String baseUrl = "http://localhost:8080/employee";
		List<ServiceInstance> insList = discoveryClient.getInstances("PRODUCER");
		ServiceInstance instance = insList.get(0);
		String url = instance.getUri().toString();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response=null;
		try{
		response=restTemplate.exchange(url+"/employee",
				HttpMethod.GET, getHeaders(),Employee.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return response;
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}

