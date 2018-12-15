package com.lhf.controller;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Courses;
import com.lhf.service.CoursesService;
@RestController
@RequestMapping("/courses")
public class CoursesController {
	@Autowired
	private CoursesService cService;
	//查询
	@RequestMapping("/query")
	public Object queryNameLikeAllPage(String name,Integer page,Integer size) {
		if (name==null||name==""||name.isEmpty()||name.equals("")) {
			name="%";
		}
		Page<Courses> page1 = null;
		page1 = cService.queryNameLikeAllPage(name,page==0?1:page-1,1);
    	List<Courses> list = page1.getContent();
		Long total = page1.getTotalElements();
    	Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}
	
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
	public Object deleteCoursesById(Integer courseId) {
		int C=cService.deleteCoursesById(courseId);
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
