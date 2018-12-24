package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysd.boot.entity.Users;
import com.ysd.boot.service.UsersService;
import com.ysd.boot.service.impl.UsersLogin;
import com.ysd.boot.tool.PasswordEncoder;
import com.ysd.boot.tool.Result;
import com.ysd.boot.tool.TokenUntil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsersLogin usersLogin;
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * 登录
	 * http://localhost:8006/login/userLogin?username=admin&password=123456
	 * @return
	 */	
	
	@RequestMapping("/userLogin")
	public Object userLogin(String username,String password,String path){
		Map<String, Object> map=new HashMap<String, Object>();
		PasswordEncoder encoderMd5 = new PasswordEncoder(username, "MD5");
		String encodePass = encoderMd5.encode(password, 5);// 用户名做盐,哈希五次MD5加密
		Users users=usersService.queryUserByUserName(username);
		if( users == null ) {
			return new Result("用户名不存在",0);
		}
		
		if (!users.getUsersPassword().equals(encodePass)) {
			return new Result("密码错误",0);
		}
		if( users.getUsersIsLockout()==1) {
			
			return new Result("用户已被锁定,请联系管理员解锁.QQ : 1304792612 ",0);
		} 
	   Object object=usersLogin.userLogin(username,encodePass);
	  //Java中使用Jackson反序列时，将LinkedHashMap转成对象的方法（将任何Object类型转成实体）
	   ObjectMapper mapper = new ObjectMapper();
	   TokenUntil pojo = mapper.convertValue(object, TokenUntil.class);
	
		map.put("access_token",pojo.getAccess_token());	
		map.put("refresh_token",pojo.getRefresh_token());	
		map.put("path", path);
		return new Result(map);
	}
	
	/***
	 * 注销
	 * http://localhost:8006/login/userEndLogin?refresh_token=eb86d7c8-577d-4c3f-9f22-d4865ed422d1
	 * @param refresh_token
	 * @return
	 */
	@RequestMapping("/userEndLogin")
	public Object userEndLogin(String refresh_token) {
		Map<String, Object> map=new HashMap<String, Object>();
	    Object object=usersLogin.userEndLogin(refresh_token);
	    
		  //Java中使用Jackson反序列时，将LinkedHashMap转成对象的方法（将任何Object类型转成实体）
		ObjectMapper mapper = new ObjectMapper();
		TokenUntil pojo = mapper.convertValue(object, TokenUntil.class);
		
		map.put("access_token",pojo.getAccess_token());	
		map.put("refresh_token",pojo.getRefresh_token());	
			
		return map;
		
	}
	
	

}
