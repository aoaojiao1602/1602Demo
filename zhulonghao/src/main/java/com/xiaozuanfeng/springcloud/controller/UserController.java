package com.xiaozuanfeng.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaozuanfeng.springcloud.entity.Fans;
import com.xiaozuanfeng.springcloud.entity.UserInfo;
import com.xiaozuanfeng.springcloud.services.FansServices;
import com.xiaozuanfeng.springcloud.services.UserServices;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

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
	 * http://localhost:8030/user/userinfo?uid=1
	 * 
	 */
	@ApiOperation(value = "获取用户详细信息", notes = "根据url的uid来获取用户详细信息")
	@ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public UserInfo getUser(@PathVariable(value = "uid")Integer uid) {
		return uss.getUser(uid);
	}

	/**
	 * http://localhost:8030/user/getMyFans?uid=1
	 * 
	 */
	@RequestMapping(value ="/getMyFans", method = RequestMethod.GET)
	public List<UserInfo> getMyFans(Integer uid) {
		return fss.getMyFans(uid);
	}

	/**
	 * http://localhost:8030/user/getMyfocus?uid=1
	 * 
	 */

	@RequestMapping(value ="/getMyfocus", method = RequestMethod.GET)
	public List<UserInfo> getMyfocus(Integer uid) {
		return fss.getMyFans(uid);
	}

	/**
	 * http://localhost:8030/user/getMyFansCount?uid=1
	 * 
	 */
	@RequestMapping(value ="/getMyFansCount", method = RequestMethod.GET)
	public int getMyFansCount(Integer uid) {
		return fss.getMyFansCount(uid);
	}

	/**
	 * http://localhost:8030/user/getIsMyfocus?uid=1&fid=2
	 * 
	 */
	@RequestMapping(value ="/getIsMyfocus", method = RequestMethod.GET)
	public int getIsMyfocus(Integer uid, Integer fid) {
		return fss.getIsMyfocus(uid, fid);
	}

	/**
	 * http://localhost:8030/user/getMyfocusCount?uid=1
	 * 
	 */
	@RequestMapping(value ="/getMyfocusCount", method = RequestMethod.GET)
	public int getMyfocusCount(Integer uid) {
		return fss.getMyFansCount(uid);
	}

	/**
	 * http://localhost:8030/user/postMyfocus?uid=1&fid=9
	 * 
	 */
	@RequestMapping(value ="/postMyfocus", method = RequestMethod.POST)
	public int postMyfocus(Integer uid, Integer fid) {
		return fss.postMyfocus(uid, fid);
	}

	/**
	 * http://localhost:8030/user/deleteMyfocus?uid=1&fid=2
	 * 
	 */
	@RequestMapping(value ="/deleteMyfocus", method = RequestMethod.DELETE)
	public int deleteMyfocus(Integer uid, Integer fid) {
		return fss.deleteMyfocus(uid, fid);
	}

}
