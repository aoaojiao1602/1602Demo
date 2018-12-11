package com.xiaozuanfeng.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${server.port}")
	private String serverPort;


	/**
	 * http://localhost:8030/getFuture
	 * @return
	 */
	@RequestMapping("/getFuture")
	public List<String> getFuture() {
		List<String> list = new ArrayList<>();
		list.add("出自端口号:"+serverPort);
		return list;
	}

}
