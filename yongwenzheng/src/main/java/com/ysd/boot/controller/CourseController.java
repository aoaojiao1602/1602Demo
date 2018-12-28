package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.ysd.boot.tool.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/***
	 * 添加课程推荐
	 * @param course
	 * @return
	 */
	@ApiOperation(value="获取课程推荐信息", notes="添加课程推荐")
	@PutMapping(value="/addCourse",name="添加课程推荐")
	public Object addCourse(@RequestParam Integer kechId,@RequestParam Integer navigationId,@RequestParam String access_token) {
		Result result=new Result();
		if (courseService.addCourse(kechId, navigationId)>0) {
			result.setState(1);
			result.setMsg("添加成功");
			
		} else {
			result.setState(0);
			result.setMsg("添加失败");
		}
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
	 * @param page
	 * @param rows
	 * @param id
	 * @param access_token
	 * @return
	 */
	@ApiOperation(value="获取课程推荐信息", notes="通过位置id分页查询班级")
	@GetMapping("/queryCourseByPage") 
    public Object queryCourseByPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam Integer id,@RequestParam String access_token){ 
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
