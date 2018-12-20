package com.hwg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 首页控制器层
 */
@RestController
@CrossOrigin
public class IndexController {
	/**
	 * 首页图片轮播
	 * 
	 * @return
	 */
	@GetMapping("carousel")

	public Object getImages() {
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("url", "http://localhost:8010/img/deal_0" + i + ".jpg");
			map.put("index", i);
			list.add(map);
		}
		System.out.println(list);
		return list;
	}
	
	/**
	 * 查询精彩讨论
	 * @return
	 */
	@GetMapping("getJctl")
	public Object getJctl() {
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < 11; i++) {
			list.add("ms第"+(i+1)+"论");
		}
		return list;
	}
}
