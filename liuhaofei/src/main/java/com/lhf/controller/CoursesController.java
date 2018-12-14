package com.lhf.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.service.CoursesService;
@RestController
@RequestMapping("/courses")
public class CoursesController {
	@Autowired
	private CoursesService cService;
	@RequestMapping("/putCourses")
	public Object putCourses(String Course_category,String course_name,String course_creator,String course_remark) {
		int c=cService.putCourses(Course_category, course_name, course_creator, course_remark);
		Map<String, Object> map = new HashMap<>();
		if(c>0) {
			map.put("success",true);
			map.put("message","添加成功");
		}else {
			map.put("success",false);
			map.put("message","添加失败");
		}
		return null;
	};

}
