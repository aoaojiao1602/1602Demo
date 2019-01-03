package com.hwg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.service.YwzService;

/**
 * @Description 分类控制器层
 * @author HJiong
 * @time 2018年12月15日 上午12:25:50
 */
@RestController
public class CategoryController {
	@Autowired
	private YwzService cService;
	
	/**
	 * 	查询出所有的分类
	 * @return
	 */
	@GetMapping("category")
	public Object getCategoryAll(String access_token) {
		return cService.getCategoryAll(access_token);
	}

	/**
	 * 查询课程列表 http://localhost:8010/getCourseDetails
	 * @return
	 */
	@GetMapping("getCourseDetails")
	@CrossOrigin
	public Object getCourseDetails() {
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("url", "http://localhost:8010/img/deal_" + i + ".jpg");
			map.put("name", "课程"+i);
			map.put("teacher", "教师"+i);
			map.put("desc", "课程简介"+i);
			map.put("member", i);
			map.put("going", i);			
			list.add(map);
		}
		return list;
	}
}
