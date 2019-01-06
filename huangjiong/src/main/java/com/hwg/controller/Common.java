package com.hwg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.service.UserService;
import com.hwg.utils.Get7dayUtil;


/**
 * @Description 公用controller
 * @author HJiong
 * @time 2018年12月31日 下午8:18:14
 */
@RequestMapping("/common")
@RestController
public class Common {
	@Autowired
	private Get7dayUtil getDate;
	
	@Autowired
	private UserService uService;
	
	
	/**
	 * 获取指定日期
	 * @param day
	 * @return
	 */
	@RequestMapping("/getDate")
	public String getDate(Integer day) {
		return getDate.getPastDate(day);
	}
	
	/**
	 *   根据id查询用户信息
	 * @param uid
	 * @return
	 */
	@GetMapping("/queryUser")
	public Object queryUser(Integer uid) {
		System.err.println(uService.queryUser(uid));
		return uService.queryUser(uid);
	}
}
