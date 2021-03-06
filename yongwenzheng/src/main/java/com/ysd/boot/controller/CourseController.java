package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.Course;
import com.ysd.boot.service.CourseService;
import com.ysd.boot.service.HJCourseService;
import com.ysd.boot.tool.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private HJCourseService hjCourseService;
	
	/***
	 * 添加课程推荐
	 * @param course
	 * @return
	 */
	@ApiOperation(value="获取课程推荐信息", notes="添加课程推荐")
	@PutMapping(value="/addCourse",name="添加课程推荐")
	public Object addCourse(String access_token) {
		//添加课程推荐信息，查询黄炯给我的一个月内课程的报名人数和课程id
		//我的设计是每月定时对我的数据库进行更新，一个月更新一次
		//我通过修改推荐状态，权重，位置进行推荐
		//为了测试方便前台添加按钮进行我功能测试
		Result result=new Result();
		int a=0;
		List<Map<String, Object>> list=hjCourseService.getLearnrecordByUpdateTime();
		 for (Map<String, Object> map : list) {
				
				System.err.println(map.get("number"));
				
				Integer kid=Integer.parseInt((String) map.get("learn_course_id"));
				System.err.println(kid);
				a+=courseService.addCourse(kid, 0,map.get("number")+"人");
				
			}
		
			result.setState(1);
			result.setMsg("成功添加 "+a+" 条数据");
			
		
		return result;
	}
	
	/**
	 * 通过id进行删除课程推荐
	 * @param courseId
	 * @return
	 */
	@ApiOperation(value="获取课程推荐信息", notes="通过id进行删除课程推荐")
	@DeleteMapping("/deleteCourse")
	public Object deleteCourse(@RequestParam Integer courseId,@RequestParam String access_token) {
		Result result=new Result();
		if (courseService.deleteCourse(courseId)>0) {
			result.setState(1);
			result.setMsg("删除成功");
			
		} else {
			result.setState(0);
			result.setMsg("删除失败");
		}
		return result;
    	 
		
		
	}
	
	/**
	 * 通过id进行修改课程推荐
	 * @param course
	 * @return
	 */
	@ApiOperation(value="获取课程推荐信息", notes="通过id进行修改课程推荐")
	@PostMapping("/updateCourse")
	public Object updateCourse(Course course,String access_token) {
		Result result=new Result();
		if (courseService.updateCourse(course)>0) {
			result.setState(1);
			result.setMsg("修改成功");
			
		} else {
			result.setState(0);
			result.setMsg("修改失败");
		}
		return result;
		
	}
	
	
	
	
	
	/**
	 * 通过位置id分页查询班级
	 * http://localhost:8006/course/queryCourseByPage?page=1&rows=10&id=&access_token=
	 * @param page
	 * @param rows
	 * @param id
	 * @param access_token
	 * @return
	 */
	@ApiOperation(value="获取课程推荐信息", notes="通过位置id分页查询班级")
	@GetMapping("/queryCourseByPage") 
    public Object queryCourseByPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam Integer id,@RequestParam String access_token){ 
		if (id==null||id.equals("")) {
			id=0;
		} 
		Page<Course> pages=courseService.queryCourseByPage(page, rows, id);
		   Map<String, Object> map = new HashMap<>();
	    	map.put("total", pages.getTotalElements());
	    	map.put("rows",pages.getContent());
	    	return map;
    	 
     }
	 
	 
	   /***
		    * 得到全部的课程推荐
		  * @return
		  */
	@ApiOperation(value="获取课程推荐信息", notes="得到全部的课程推荐")
    @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getAllCourseList")
	public Object getAllCourseList(@RequestParam String access_token) {
		
		return courseService.getAllCourseList();
	}
		
	/**
	    * 通过位置id得到课程推荐
	  * @param positionId
	  * @return
	  */
	@ApiOperation(value="获取课程推荐信息", notes="通过位置id得到课程推荐")
	@GetMapping("/getCourseByPositionId")
	public Object getCourseByPositionId(@RequestParam Integer positionId,@RequestParam String access_token) {
		
		return courseService.getCourseByPositionId(positionId);
	}
	 

}
