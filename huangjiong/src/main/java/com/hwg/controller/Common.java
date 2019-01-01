package com.hwg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.utils.Get7dayUtil;


/**
 * @Description 公告controller
 * @author HJiong
 * @time 2018年12月31日 下午8:18:14
 */
@RequestMapping("/common")
@RestController
public class Common {
	@Autowired
	private Get7dayUtil getDate;
	
	/**
	 * 获取指定日期
	 * @param day
	 * @return
	 */
	@RequestMapping("/getDate")
	public String getDate(Integer day) {
		return getDate.getPastDate(day);
	}
}
