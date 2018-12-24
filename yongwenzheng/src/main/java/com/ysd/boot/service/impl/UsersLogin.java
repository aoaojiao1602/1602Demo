package com.ysd.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersLogin {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Object userLogin(String username,String password) {
		return  restTemplate.getForObject("http://service-oauth2/oauth/token?grant_type=password&username="+username+"&password="+password+"&client_id=client_1&client_secret=123456&scope=all", Object.class);
	}
	//http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=d32fd869-34ae-4459-ad8d-49496087039f&client_id=client_1&client_secret=123456
	public Object userEndLogin(String refresh_token) {
		return  restTemplate.getForObject("http://service-oauth2/oauth/token?grant_type=refresh_token&refresh_token="+refresh_token+"&client_id=client_1&client_secret=123456", Object.class);
	}

}
