package com.lhf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	@Autowired
	private ConsumerService cService;
	@RequestMapping("/getProviderFuture")
	public List<String> getProviderFuture(){
		return cService.getCategory();
	}
	

}
