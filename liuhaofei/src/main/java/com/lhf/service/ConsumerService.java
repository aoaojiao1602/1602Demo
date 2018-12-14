package com.lhf.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {
	@Autowired
	private RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod="getProviderFutureFallback")
	public List<String> getProviderFuture() {
		return restTemplate.getForObject("http://zuul/ywz/category/getAll", List.class);
	}
	public List<String> getProviderFutureFallback(){
		return Arrays.asList("Provider服务调用失败","我是Consumer服务降级");
	}

}
