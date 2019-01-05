package com.hwg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.service.YwzService;

/**
 * @Description 精彩讨论controller
 * @author HJiong
 * @time 2019年1月5日 上午12:33:00
 */
@RequestMapping("jctl")
@RestController
public class JctlController {
	@Autowired
	private YwzService ywz;
	
	/**
	 * 查询出精彩讨论
	 * @return
	 */
	@GetMapping
	public Object getJctl() {
		//得到所有精彩讨论
		List<Map<String, Object>> jctl=(List<Map<String, Object>>) ywz.getjctl(1, "");
		
		//循环精彩讨论
		for (Map<String, Object> map : jctl) {
			//map.get("teacherId") 老师id
			//map.get("kechId") 讨论id
		}
		
		return jctl;
	}
	
	
}
