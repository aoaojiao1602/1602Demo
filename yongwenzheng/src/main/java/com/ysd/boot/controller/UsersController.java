package com.ysd.boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users",name="用户管理")
public class UsersController {
	

	@PostMapping(value="/addUsers",name="添加用户")
	public Object addUsers(String username,String access_token) {
		//每一个方法都需要加形参String access_token
		return username;
	}
	
	
	

}
