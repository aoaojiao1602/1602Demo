package com.ysd.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.service.DepartmentService;
import com.ysd.boot.tool.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/***
	  * 添加部门信息
	 * @param departmentName
	 * @param school_id
	 * @return
	 */
	@ApiOperation(value="获取部门信息", notes="添加部门信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "departmentName", value = "部门名称", required = true, dataType = "String", paramType = "query"),
	@ApiImplicitParam(name = "school_id", value = "所属学校id", required = true, dataType = "Integer", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@PutMapping("/addDepartment")
    public Object addDepartment(@RequestParam String departmentName,@RequestParam Integer school_id,@RequestParam String access_token) {
		Result result=new Result();
		if (departmentService.addDepartment(departmentName, school_id)>0) {
			result.setState(1);
			result.setMsg("添加成功");
			
		} else {
			result.setState(0);
			result.setMsg("添加失败");
		}
		return result;
    	
    }
    
	/***
	  * 通过id删除部门信息
	 * @param departmentId
	 * @return
	 */
	@ApiOperation(value="获取部门信息", notes="通过id删除部门信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "departmentId", value = "部门id", required = true, dataType = "Integer", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@DeleteMapping("/deleteDepartment")
	public Object deleteDepartment(@RequestParam Integer departmentId,@RequestParam String access_token) {
		Result result=new Result();
		if (departmentService.deleteDepartment(departmentId)>0) {
			result.setState(1);
			result.setMsg("删除成功");
			
		} else {
			result.setState(0);
			result.setMsg("删除失败");
		}
		return result;
    	
    }
    
    /**
          * 修改部门信息
     * @param departmentId
     * @param departmentName
     * @param school_id
     * @return
     */
	@ApiOperation(value="获取部门信息", notes="修改部门信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "departmentId", value = "部门id", required = true, dataType = "Integer", paramType = "query"),
	    @ApiImplicitParam(name = "departmentName", value = "部门名称", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "school_id", value = "所属学校id", required = true, dataType = "Integer", paramType = "query"),
	    @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@PostMapping("/updateDepartment")
    public Object updateDepartment(Integer departmentId,String departmentName,Integer school_id,@RequestParam String access_token) {
		Result result=new Result();
		if (departmentService.updateDepartment(departmentId, departmentName, school_id)>0) {
			result.setState(1);
			result.setMsg("修改成功");
			
		} else {
			result.setState(0);
			result.setMsg("修改失败");
		}
		return result;
    	
    }
    
    /**
          * 查询所有部门信息
     * @return
     */
	@ApiOperation(value="获取部门信息", notes="查询所有部门信息")
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	@GetMapping("/getAllDepartmentLIst")
    public Object getAllDepartmentLIst(@RequestParam String access_token){
    	
    	return departmentService.getAllDepartmentLIst();
    }

}
