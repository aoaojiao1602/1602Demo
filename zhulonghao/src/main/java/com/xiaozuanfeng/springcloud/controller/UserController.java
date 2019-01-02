package com.xiaozuanfeng.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaozuanfeng.springcloud.entity.Fans;
import com.xiaozuanfeng.springcloud.entity.UserInfo;
import com.xiaozuanfeng.springcloud.services.FansServices;
import com.xiaozuanfeng.springcloud.services.UserServices;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServices uss;
	@Autowired
	private FansServices fss;	@Value("${server.port}")
	private String serverPort;

	/**
	 * http://localhost:8030/user/userinfo?uid=1
	 * 
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public UserInfo getUser(Integer uid) {
		return uss.getUser(uid);
	}

	/**
	 * http://localhost:8030/user/getMyFans?uid=1
	 * 
	 */
	@RequestMapping(value = "/getMyFans", method = RequestMethod.GET)
	public List<UserInfo> getMyFans(Integer uid) {
		return uss.getMyFans(fss.getMyFans(uid));
	}

	/**
	 * http://localhost:8030/user/getMyfocus?uid=1
	 * 
	 */

	@RequestMapping(value = "/getMyfocus", method = RequestMethod.GET)
	public List<UserInfo> getMyfocus(Integer uid) {
		return uss.getMyfocus(fss.getMyfocus(uid));
	}

	/**
	 * http://localhost:8030/user/getMyFansCount?uid=1
	 * 
	 */
	@RequestMapping(value = "/getMyFansCount", method = RequestMethod.GET)
	public Integer getMyFansCount(Integer uid) {
		return fss.getMyFansCount(uid);
	}

	/**
	 * http://localhost:8030/user/getIsMyfocus?uid=1&fid=2
	 * 
	 */
	@RequestMapping(value = "/getIsMyfocus", method = RequestMethod.GET)
	public Integer getIsMyfocus(Integer uid, Integer fid) {
		return fss.getIsMyfocus(uid, fid);
	}

	/**
	 * http://localhost:8030/user/getMyfocusCount?uid=1
	 * 
	 */
	@RequestMapping(value = "/getMyfocusCount", method = RequestMethod.GET)
	public Integer getMyfocusCount(Integer uid) {
		return fss.getMyfocusCount(uid);
	}

	/**
	 * http://localhost:8030/user/postMyfocus?uid=1&fid=9
	 * 
	 */
	@RequestMapping(value = "/putMyfocus", method = RequestMethod.PUT)
	public int putMyfocus(Integer uid, Integer fid) {
		return fss.postMyfocus(uid, fid);
	}

	/**
	 * http://localhost:8030/user/deleteMyfocus?uid=1&fid=2
	 * 
	 */
	@RequestMapping(value = "/deleteMyfocus", method = RequestMethod.DELETE)
	public int deleteMyfocus(Integer uid, Integer fid) {
		return fss.deleteMyfocus(uid, fid);
	}

	/**
	 * http://localhost:8030/user/updateById?=1
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	public int updateById(@RequestBody UserInfo uid) {
		System.out.println(uid);
		return uss.updateById(uid);
	}
	

}
