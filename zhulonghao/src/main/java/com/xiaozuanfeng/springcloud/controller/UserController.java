package com.xiaozuanfeng.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaozuanfeng.springcloud.entity.Fans;
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
	 * http://localhost:8030/user/getUser?uid=1
	 * 
	 */
	@RequestMapping("/getUser")
	public UserInfo getUser(Integer uid) {
		return uss.getUser(uid);
	}

	/**
	 * http://localhost:8030/user/getMyFans?uid=1
	 * 
	 */
	@RequestMapping("/getMyFans")
	public List<Fans> getMyFans(Integer uid) {
		return fss.getMyFans(uid);
	}

	/**
	 * http://localhost:8030/user/getMyfocus?uid=1
	 * 
	 */

	@RequestMapping("/getMyfocus")
	public List<Fans> getMyfocus(Integer uid) {
		return fss.getMyFans(uid);
	}

	/**
	 * http://localhost:8030/user/getMyFansCount?uid=1
	 * 
	 */
	@RequestMapping("/getMyFansCount")
	public List<Fans> getMyFansCount(Integer uid) {
		return fss.getMyFans(uid);
	}

	/**
	 * http://localhost:8030/user/getIsMyfocus?uid=1&fid=2
	 * 
	 */
	@RequestMapping("/getIsMyfocus")
	public int getIsMyfocus(Integer uid, Integer fid) {
		return fss.getIsMyfocus(uid, fid);
	}

	/**
	 * http://localhost:8030/user/getMyfocusCount?uid=1
	 * 
	 */
	@RequestMapping("/getMyfocusCount")
	public List<Fans> getMyfocusCount(Integer uid) {
		return fss.getMyFans(uid);
	}

	/**
	 * http://localhost:8030/user/postMyfocus?uid=1&fid=9
	 * 
	 */
	@RequestMapping("/postMyfocus")
	public int postMyfocus(Integer uid, Integer fid) {
		return fss.postMyfocus(uid, fid);
	}

	/**
	 * http://localhost:8030/user/deleteMyfocus?uid=1&fid=2
	 * 
	 */
	@RequestMapping("/deleteMyfocus")
	public int deleteMyfocus(Integer uid, Integer fid) {
		return fss.deleteMyfocus(uid, fid);
	}

}
