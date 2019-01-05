package com.ysd.boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.service.HJCourseService;

@RestController
public class HJCourseController {

	
	@Autowired
	private HJCourseService hjCourseService;
	
	@RequestMapping("/name")
	public Object getHJCourseList() {
		
		List<Map<String, Object>> list=hjCourseService.getLearnrecordByUpdateTime();
		 for (Map<String, Object> map : list) {
		
			System.err.println(	map.get("number"));
			System.err.println(	map.get("learn_course_id"));
			
		}
		return list;
	}
}
