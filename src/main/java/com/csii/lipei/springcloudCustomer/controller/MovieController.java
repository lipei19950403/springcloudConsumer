package com.csii.lipei.springcloudCustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.csii.lipei.springcloudCustomer.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	public RestTemplate template;
	
	//使用object发送，无参数
	@GetMapping("/customer/object")
	public User sendObject(){
		
		User user = this.template.getForObject("http://cloudprivade/SolrSearch", User.class);
		System.out.println(user.getName());
		 return user;
	}
	
	//使用entity发送，无参数
	@GetMapping("/customer/entity")
	public User sendEntity(){
		ResponseEntity<User> resp = this.template.getForEntity("http://cloudprivade/SolrSearch", User.class);
		System.out.println(resp.getHeaders());
		System.out.println(resp.getStatusCode());
		 return resp.getBody();
	}
	
	//使用entity发送，无参数
	@GetMapping("/customer/entityById/{id}")
	public User sendEntityById(@PathVariable(name = "id")String id){
		ResponseEntity<User> resp = this.template.getForEntity("http://cloudprivade/SolrSearchById/{id}", User.class,id);
		System.out.println(resp.getHeaders());
		System.out.println(resp.getStatusCode());
		 return resp.getBody();
	}
	
	//使用object发送，无参数
	@GetMapping("/customer/objectById/{id}")
	public User sendObjectById(@PathVariable(name = "id")String id){
		User user = this.template.getForObject("http://cloudprivade/SolrSearchById/{id}", User.class,id);
		 return user;
	}
		
		
	
	
	
	
	
	
	
}
