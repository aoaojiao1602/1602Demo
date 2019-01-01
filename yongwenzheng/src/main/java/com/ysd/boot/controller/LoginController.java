package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsersLogin usersLogin;
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * 登录
	 *http://localhost:8006/login/userLogin?usersname=admin&pwd=123456
	 * @return
	 */	
	@RequestMapping("/userLogin")
	public Object userLogin(String usersname,String pwd,String path){
		System.err.println(usersname);
		System.err.println(pwd);
		Map<String, Object> map=new HashMap<String, Object>();
		PasswordEncoder encoderMd5 = new PasswordEncoder(usersname, "MD5");
		String encodePass = encoderMd5.encode(pwd, 5);// 用户名做盐,哈希五次MD5加密
		Users users=usersService.queryUserByUserName(usersname);
		if( users == null ) {
			return new Result("用户名不存在",0);
		}
		
		if (!users.getUsersPassword().equals(encodePass)) {
			return new Result("密码错误",0);
		}
		if( users.getUsersIsLockout()==1) {
			
			return new Result("用户已被锁定,请联系管理员解锁.QQ : 1304792612 ",0);
		} 
	   Object object=usersLogin.userLogin(usersname,encodePass);
	  //Java中使用Jackson反序列时，将LinkedHashMap转成对象的方法（将任何Object类型转成实体）
	   ObjectMapper mapper = new ObjectMapper();
	   TokenUntil pojo = mapper.convertValue(object, TokenUntil.class);
	
		map.put("access_token",pojo.getAccess_token());	
		map.put("refresh_token",pojo.getRefresh_token());
		map.put("uid", users.getUsersId());
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
	/****
	 * 修改用户密码
	 * http://localhost:8006/login/updateUserPassById?oldPassword=123456&newPassword=123&usersId=6
	 * @param usersPassword
	 * @param usersId
	 * @return
	 */
	 @PostMapping("/updateUserPassById")
	 public Object updateUserPassById(String oldPassword,String newPassword, Integer usersId) {
		 Result result=new Result();
		 Users users=usersService.getUsersById(usersId);
		 PasswordEncoder encoderMd5 = new PasswordEncoder(users.getUsersName(), "MD5");
		 String encodePass = encoderMd5.encode(oldPassword, 5);// 用户名做盐,哈希五次MD5加密
		 System.err.println(users.getUsersPassword());
		 System.err.println(encodePass);
		 if (!users.getUsersPassword().equals(encodePass)) {
			    result.setState(0);
				result.setMsg("原密码输入错误");
			}
		 else {
			 if (usersService.updateUsers(encoderMd5.encode(newPassword, 5), usersId)>0) {
					result.setState(1);
					result.setMsg("修改成功");
					
			} else {
					result.setState(0);
					result.setMsg("修改失败");
			}
			 
		 }
		 
		
		 return result;
	 }
	
	

}
