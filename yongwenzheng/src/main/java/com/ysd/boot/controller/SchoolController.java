package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.Clazz;
import com.ysd.boot.entity.Department;
import com.ysd.boot.entity.Professional;
import com.ysd.boot.entity.School;
import com.ysd.boot.service.ClazzService;
import com.ysd.boot.service.DepartmentService;
import com.ysd.boot.service.ProfessionalService;
import com.ysd.boot.service.SchoolService;
import com.ysd.boot.tool.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ProfessionalService professionalService;
	
	@Autowired
	private ClazzService clazzService;
	
	
	/***
	 * 通过tid获取老师院校信息
	 * @param tid
	 * @param access_token
	 * @return
	 */
	@ApiOperation(value="获取用户院校信息", notes="根据url的tid来获取老师院校信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "tid", value = "老师TID", required = true, paramType = "query",dataType = "Integer"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@GetMapping("/getSchoolBytId")
	public Object getSchoolBytId(@RequestParam Integer tid,@RequestParam String access_token) {
		Map<String, Object> map=new HashMap<String, Object>();
		Integer pid=professionalService.getIdByuId(tid);
		
		Professional professional=professionalService.getAllById(pid);
		Department department=departmentService.getAllById(professional.getDepartment().getDepartmentId());
		School school=schoolService.getAllById(department.getSchool().getSchoolId());
		
		map.put("schoolName", school.getSchoolName());
		map.put("departmentName", department.getDepartmentName());
		map.put("professionalName", professional.getProfessionalName());
		return map;
		
	}
	/***
	 * 通过sid获取学生院校信息
	 * @param sid
	 * @param access_token
	 * @return
	 */
	@ApiOperation(value="获取用户院校信息", notes="根据url的sid来获取学生院校信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "sid", value = "学生SID", required = true, dataType = "Integer", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@GetMapping("/getSchoolBysId")
	public Object getSchoolBysId(@RequestParam Integer sid,@RequestParam String access_token) {
		Map<String, Object> map=new HashMap<String, Object>();
		Integer cid=clazzService.getClazzIdBytId(sid);
		Clazz clazz=clazzService.getAllById(cid);	
		Professional professional=professionalService.getAllById(clazz.getProfessional().getProfessionalId());
		Department department=departmentService.getAllById(professional.getDepartment().getDepartmentId());
		School school=schoolService.getAllById(department.getSchool().getSchoolId());
		
		map.put("schoolName", school.getSchoolName());
		map.put("departmentName", department.getDepartmentName());
		map.put("professionalName", professional.getProfessionalName());
		map.put("clazzName", clazz.getClassName());
		return map;
		
	}
	
	
	
	/***
	 * 添加学校
	 * @param school
	 * @return
	 */
	@ApiOperation(value="获取学校信息", notes="添加学校")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "schoolName", value = "学校名", required = true, dataType = "String", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@PutMapping("/addSchool")
	public Object addSchool(@RequestParam String schoolName,@RequestParam String access_token) {
		Result result=new Result();
		if (schoolService.addSchool(schoolName)>0) {
			result.setState(1);
			result.setMsg("添加成功");
			
		} else {
			result.setState(0);
			result.setMsg("添加失败");
		}
		return result;
	}
	
	/**
	 *  通过id删除学校
	 * @param id
	 * @return
	 */
	@ApiOperation(value="获取学校信息", notes="通过id删除学校")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "id", value = "学校id", required = true, dataType = "Integer", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@DeleteMapping("/deletechool")
	public Object deletechool(@RequestParam Integer id,@RequestParam String access_token) {
		Result result=new Result();
		if (schoolService.deleteSchool(id)>0) {
			result.setState(1);
			result.setMsg("删除成功");
			
		} else {
			result.setState(0);
			result.setMsg("删除失败");
		}
		return result;
	}
	
	
	/***
	 * 修改学校
	 * @param school
	 * @return
	 */
	@ApiOperation(value="获取学校信息", notes="添加学校")
	@ApiImplicitParams({
	   @ApiImplicitParam(name = "schoolName", value = "学校名", required = true, dataType = "String", paramType = "query"),
	   @ApiImplicitParam(name = "schoolId", value = "学校id", required = true, dataType = "Integer", paramType = "query"),
	   @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@PostMapping("/updateSchool")
	public Object updateSchool(@RequestParam String schoolName,@RequestParam Integer schoolId,@RequestParam String access_token) {
		Result result=new Result();
		if (schoolService.updateSchool(schoolName, schoolId)>0) {
			result.setState(1);
			result.setMsg("修改成功");
			
		} else {
			result.setState(0);
			result.setMsg("修改失败");
		}
		return result;
	}
	
	/***
	 *  查询全部的学校
	 * @return
	 */
	@ApiOperation(value="获取学校信息", notes=" 查询全部的学校")
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	@GetMapping("/getAllSchool")
	private Object getAllSchool(@RequestParam String access_token) {
		
		return schoolService.getAllSchoolList();
	}
}
