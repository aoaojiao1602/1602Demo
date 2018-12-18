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
	//选择课程所属类别(类别调用雍文正组)
	@HystrixCommand(fallbackMethod="getProviderFutureFallback")
	public List<String> getCategory() {
		return restTemplate.getForObject("http://zuul/ywz/category/getAll", List.class);
	}
	//上传课程图片
	@HystrixCommand(fallbackMethod="getProviderFutureFallback")
	public List<String> uploadPic() {
		return restTemplate.getForObject("http://zuul/ywz/file/upload", List.class);
	}
	public List<String> getProviderFutureFallback(){
		return Arrays.asList("Provider服务调用失败","我是Consumer服务降级");
	}

}
