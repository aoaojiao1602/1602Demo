package com.lhf.controller;




import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Courses;
import com.lhf.service.CoursesService;
@RestController
@RequestMapping("/courses")
public class CoursesController {
	@Autowired
	private CoursesService cService;
	//添加
	@RequestMapping("/putCourses")
	public Object putCourses(Courses c) {
		int C=cService.putCourses(c);
		Map<String, Object> map = new HashMap<>();
		if(C>0) {
			map.put("success",true);
			map.put("message","添加成功");
		}else {
			map.put("success",false);
			map.put("message","添加失败");
		}
		return C;
	}
	//删除
	@RequestMapping("/deleteCourses")
	public Object deleteCoursesById(Integer Course_id) {
		int C=cService.deleteCoursesById(Course_id);
		Map<String, Object> map = new HashMap<>();
		if(C>0) {
			map.put("success",true);
			map.put("message","删除成功");
		}else {
			map.put("success",false);
			map.put("message","删除失败");
		}
		return C;
	}
	//修改
	@RequestMapping("/postCourses")
	public Object postCoursesById(Courses c) {
		int C=cService.postCoursesById(c);
		Map<String, Object> map = new HashMap<>();
		if(C>0) {
			map.put("success",true);
			map.put("message","删除成功");
		}else {
			map.put("success",false);
			map.put("message","删除失败");
		}
		return C;
	}

}