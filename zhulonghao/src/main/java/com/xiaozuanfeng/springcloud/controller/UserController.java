package com.xiaozuanfeng.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xiaozuanfeng.springcloud.entity.UserInfo;
import com.xiaozuanfeng.springcloud.services.FansServices;
import com.xiaozuanfeng.springcloud.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServices uss;
	@Autowired
	private FansServices fss;
	@Value("${server.port}")
	private String serverPort;
	/**
	 * http://localhost:8030/getUser?uid=1
	 * @return
	 */
	@RequestMapping("/getUser")
	public UserInfo getUser(Integer uid) {
		return uss.getUser(uid);
	}

}
