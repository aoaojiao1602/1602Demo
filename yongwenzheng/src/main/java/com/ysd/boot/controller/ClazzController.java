package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.List;
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

import com.ysd.boot.entity.Clazz;
import com.ysd.boot.service.ClazzService;
import com.ysd.boot.tool.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/clazz",name="班级模块")
public class ClazzController {
	
	@Autowired
	private ClazzService clazzService;
	
	/**
            * 添加班级信息
      * @param className
      * @param professional_id
      * @return
      */
	@ApiOperation(value="获取班级信息", notes="添加班级信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "className", value = "班级名称", required = true, dataType = "String", paramType = "query"),
	@ApiImplicitParam(name = "professional_id", value = "所属系id", required = true, dataType = "Integer", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@PutMapping(value="/addClazz",name="添加班级")
    public Object addClazz(@RequestParam String className,@RequestParam Integer professional_id,@RequestParam String access_token) {
		Result result=new Result();
		if (clazzService.addClazz(className, professional_id)>0) {
			result.setState(1);
			result.setMsg("添加成功");
			
		} else {
			result.setState(0);
			result.setMsg("添加失败");
		}
		return result;
    }

    /***
       * 通过id删除班级信息
       * @param classId
       * @return
       */
	@ApiOperation(value="获取班级信息", notes="通过id删除班级信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "classId", value = "班级id", required = true, dataType = "Integer", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
    })
	@DeleteMapping("/deleteClazz")
    public Object deleteClazz(@RequestParam Integer classId,@RequestParam String access_token) {
		Result result=new Result();
		if (clazzService.deleteClazz(classId)>0) {
			result.setState(1);
			result.setMsg("删除成功");
			
		} else {
			result.setState(0);
			result.setMsg("删除失败");
		}
		return result;
    	 
     }

      /**
                * 通过id修改班级信息
        * @return
        */
	@ApiOperation(value="获取班级信息", notes="通过id修改班级信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "classId", value = "班级id", required = true, dataType = "Integer", paramType = "query"),
     	@ApiImplicitParam(name = "className", value = "班级名称", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "professional_id", value = "所属系id", required = true, dataType = "Integer", paramType = "query"),
	    @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@PostMapping("/updateClazz")
    public Object updateClazz(@RequestParam Integer classId,@RequestParam String className,@RequestParam Integer professional_id,@RequestParam String access_token) {
		Result result=new Result();
		if (clazzService.updateClazz(classId, className, professional_id)>0) {
			result.setState(1);
			result.setMsg("修改成功");
			
		} else {
			result.setState(0);
			result.setMsg("修改失败");
		}
		return result;
		
	}

     /**
              * 得到所有班级信息
       * @return
       */
	 @ApiOperation(value="获取班级信息", notes=" 得到所有班级信息")
	 @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	 @GetMapping("/getAllClazzList")
     public Object getAllClazzList(@RequestParam String access_token){
		 
		 return clazzService.getAllClazzList();
	 }
	 
	 /**
              * 分页查询班级
       * @param name
       * @param pageable
       * @return
       */
	 @ApiOperation(value="获取班级信息", notes=" 分页查询班级")
	 @ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "行数", required = true, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "班級名称", required = false, dataType = "String", paramType = "query"),
		    @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
		})
	 @GetMapping("/queryClazzByPage") 
     public Object queryClazzByPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String name,@RequestParam String access_token){
    	  Page<Clazz> pages=clazzService.queryClazzByPage(page, rows, name);
		   Map<String, Object> map = new HashMap<>();
	    	map.put("total", pages.getTotalElements());
	    	map.put("rows",pages.getContent());
	    	return map;
    	 
     }
}
