package com.hwg.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.service.TlService;
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
	
	@Autowired
	private TlService tl;
	@Autowired
	private Common cm;
	
	/**
	 * 查询出精彩讨论
	 * @return
	 */
	@GetMapping
	public Object getJctl() {
		//得到所有精彩讨论
		List<Map<String, Object>> jctl=(List<Map<String, Object>>) ywz.getjctl(1, "");
		
		List<Map<String, Object>> restList=new ArrayList<>();
		//循环精彩讨论
		for (Map<String, Object> map : jctl) {
			Map<String, Object> restMap=new HashMap<>();
			restMap.putAll((Map<String, Object>) tl.getJctl(Integer.parseInt(map.get("kechId").toString())));
			Map<String, Object> user=(Map<String, Object>) cm.queryUser(Integer.parseInt(map.get("teacherId").toString()));
			restMap.put("userName",user.get("ui_truename"));
			restMap.put("url",user.get("ui_headportrait"));
			restList.add(restMap);
		}
		
		return restList;
	}
	
	
}
