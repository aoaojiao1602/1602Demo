package com.lhf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.service.ConsumerService;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;
	@RequestMapping(value="/querynavigation",method=RequestMethod.GET)
	public Object queryNavigation(String access_token) {
		return consumerService.queryNavigation(access_token);
	}

}
