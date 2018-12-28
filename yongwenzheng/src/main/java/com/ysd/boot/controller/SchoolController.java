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
import com.ysd.boot.entity.Department;
import com.ysd.boot.entity.Professional;
import com.ysd.boot.entity.School;
import com.ysd.boot.service.ClazzService;
import com.ysd.boot.service.DepartmentService;
import com.ysd.boot.service.ProfessionalService;
import com.ysd.boot.service.RolesService;
import com.ysd.boot.service.SchoolService;
import com.ysd.boot.service.UsersService;
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
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private RolesService rolesService;
	
	/***
	 * 通过用户id得到用户角色信息
	 * @param uid
	 * @param access_token
	 * @return
	 */
	@ApiOperation(value="获取用户角色信息", notes=" 通过用户id得到用户角色信息")
	@GetMapping("/getRoleByUid")
	public Object getRoleByUid(@RequestParam Integer uid,@RequestParam String access_token) {
		//通过用户id得到角色id
		Integer rid=usersService.getRoleByUid(uid);
		//通过角色id得到角色信息
		return rolesService.getRoleByRid(rid);
	}
	
	
	/***
	 * 修改学生机构信息
	 * @param pid
	 * @param sid
	 * @return
	 */
	@ApiOperation(value="获取学校信息", notes=" 修改学生机构信息")
	@PostMapping("/updateJG")
	public Object updateJG(@RequestParam Integer pid,@RequestParam Integer sid,@RequestParam String access_token) {
		int cid=clazzService.getCidByPid(pid);
		Result result=new Result();
		if (clazzService.updatejigou(cid, sid)>0) {
			result.setState(1);
			result.setMsg("修改成功");
			
		} else {
			result.setState(0);
			result.setMsg("修改失败");
		}
		return result;
		
	}
	
	/***
	 * 通过tid获取老师院校信息
	 * @param tid
	 * @param access_token
	 * @return
	 */
	@ApiOperation(value="获取用户院校信息", notes="根据url的tid来获取老师院校信息")
	
	@GetMapping("/getSchoolBytId")
	public Object getSchoolBytId(@RequestParam Integer tid,@RequestParam String access_token) {
		Map<String, Object> map=new HashMap<String, Object>();
		//通过老师id得到部门id
		Integer did=departmentService.getDidBytid(tid);
		//通过部门id得到部门信息
		Department department=departmentService.getAllById(did);
		School school=schoolService.getAllById(department.getSchool().getSchoolId());		
		map.put("schoolName", school.getSchoolName());
		map.put("departmentName", department.getDepartmentName());
		return map;
		
	}
	/***
	 * 通过sid获取学生院校信息
	 * @param sid
	 * @param access_token
	 * @return
	 */
	@ApiOperation(value="获取用户院校信息", notes="根据url的sid来获取学生院校信息")
	
	@GetMapping("/getSchoolBysId")
	public Object getSchoolBysId(@RequestParam Integer sid,@RequestParam String access_token) {
		Map<String, Object> map=new HashMap<String, Object>();
		Integer cid=clazzService.getCidBysid(sid);
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
	private List<School> getAllSchool(@RequestParam String access_token) {
		
		return schoolService.getAllSchoolList();
	}
	
	 /**
	  	* 分页查询学校
	  	* @param name
	  	* @param pageable
	  	* @return
	  	*/
	@ApiOperation(value="获取学校信息", notes=" 分页查询学校")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "行数", required = true, dataType = "Integer", paramType = "query"),
		@ApiImplicitParam(name = "name", value = "学校名称", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@GetMapping("/querySchoolByPage") 
	public Object querySchoolByPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String name,@RequestParam String access_token){
		Page<School> pages=schoolService.querySchoolByPage(page, rows, name);
		Map<String, Object> map = new HashMap<>();
		map.put("total", pages.getTotalElements());
		map.put("rows",pages.getContent());
		return map;

	}
}
