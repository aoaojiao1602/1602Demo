package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.Discusscourse;
import com.ysd.boot.service.DiscusscourseService;
import com.ysd.boot.tool.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/discusscourse")
public class DiscusscourseController {
	
	@Autowired
	private DiscusscourseService discusscourseService;
	
	/***
	 * 添加精彩讨论推荐
	 * @param course
	 * @return
	 */
	@ApiOperation(value="获取精彩讨论推荐信息", notes="添加精彩讨论推荐")
	@PutMapping(value="/addDiscusscourse",name="添加精彩讨论推荐")
	public Object addDiscusscourse(@RequestParam Integer kechId,@RequestParam Integer teacherId,@RequestParam String access_token) {
		Result result=new Result();
		if (discusscourseService.addDiscusscourse(kechId, teacherId)>0) {
			result.setState(1);
			result.setMsg("添加成功");
			
		} else {
			result.setState(0);
			result.setMsg("添加失败");
		}
		return result;
	}
	
	/**
	 * 通过id进行删除精彩讨论推荐
	 * @param courseId
	 * @return
	 */
	@ApiOperation(value="获取精彩讨论推荐信息", notes="通过id进行删除精彩讨论推荐")
	@DeleteMapping("/deleteDiscusscourse")
	public Object deleteDiscusscourse(@RequestParam Integer discusscourseId,@RequestParam String access_token) {
		
		Result result=new Result();
		if (discusscourseService.deleteDiscusscourse(discusscourseId)>0) {
			result.setState(1);
			result.setMsg("删除成功");
			
		} else {
			result.setState(0);
			result.setMsg("删除失败");
		}
		return result;
    	 
	}
	
	/**
	 * 通过id进行修改精彩讨论推荐
	 * @param course
	 * @return
	 */
	@ApiOperation(value="获取精彩讨论推荐信息", notes="通过id进行修改精彩讨论推荐")
	@PostMapping("/updateDiscusscourse")
	public Object updateDiscusscourse(Discusscourse discusscourse,String access_token) {
		Result result=new Result();
		if (discusscourseService.updateDiscusscourse(discusscourse)>0) {
			result.setState(1);
			result.setMsg("修改成功");
			
		} else {
			result.setState(0);
			result.setMsg("修改失败");
		}
		return result;
		
		
	}
	
	/***
	  * 通过位置id进行分页查询
	 * @param position
	 * @param pageable
	 * @return
	 */ 
	@ApiOperation(value="获取精彩讨论推荐信息", notes=" 通过位置id进行分页查询")
	@GetMapping("/queryCourseByPage") 
	public Object queryDiscusscourseByPage(@RequestParam Integer page,@RequestParam Integer rows,Integer id,@RequestParam String access_token){
		 Page<Discusscourse> pages=discusscourseService.queryDiscusscourseByPage(page, rows, id);
		   Map<String, Object> map = new HashMap<>();
	    	map.put("total", pages.getTotalElements());
	    	map.put("rows",pages.getContent());
	    	return map;
		
		
	}
	
	
	/**
	 * 通过位置id得到精彩讨论推荐
	 * @param positionId
	 * @return
	 */
	@ApiOperation(value="获取精彩讨论推荐信息", notes=" 通过位置id得到精彩讨论推荐")
	@GetMapping("/getDiscusscourseByPositionId")
	public Object getDiscusscourseByPositionId(@RequestParam Integer positionId,@RequestParam String access_token) {
		
		return discusscourseService.getDiscusscourseByPositionId(positionId);
	}
	
	
	/****
	 * 得到全部精彩讨论推荐
	 * @return
	 */
	@ApiOperation(value="获取精彩讨论推荐信息", notes="得到全部精彩讨论推荐")
	 @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	 @GetMapping("/getAllDiscusscourseList")
	public Object getAllDiscusscourseList(@RequestParam String access_token) {
		
		 return discusscourseService.getAllDiscusscourseList();
	}

}
