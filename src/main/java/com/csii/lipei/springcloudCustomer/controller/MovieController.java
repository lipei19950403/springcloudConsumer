package com.csii.lipei.springcloudCustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
	
	@Autowired
	public RestTemplate template;
	
	@GetMapping("/customer/test")
	public String send(){
		return this.template.getForObject("http://cloudprivade/SolrSearch", String.class);
	}
	
}
