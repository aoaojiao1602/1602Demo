package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.service.RolesService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RolesController {
	@Autowired
	private RolesService rolesService;
	
	
	@ApiOperation(value="获取班级信息", notes="添加角色信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "rolesName", value = "角色名", required = true, dataType = "String", paramType = "query"),
	@ApiImplicitParam(name = "rolesExplan", value = "角色备注", required = true, dataType = "String", paramType = "query")
	})

	/**
	 * 添加角色 http://localhost:8006/roles/insertRoles?rolesName=要记得那时候&rolesExplan=ejfiisnfoiafh
	 * 
	 * @param rolesName
	 * @param rolesExplain
	 * @return
	 */
	@RequestMapping("/insertRoles")
	public Object insertRoles(@RequestParam String rolesName, @RequestParam String rolesExplan) {
		Map<String, Object> map = new HashMap<String, Object>();
		String rolesNames = rolesService.findRolesName(rolesName);
		if (rolesNames != null && !"".equals(rolesNames)) {
			map.put("success", false);
			map.put("message", "角色名称不能重复,添加失败");
		} else {
			int role = rolesService.insertRoles(rolesName, rolesExplan);
			if (role > 0) {
				map.put("success", true);
				map.put("message", "添加成功");
			} else {
				map.put("success", false);
				map.put("message", "添加失败");
			}

		}
		return map;
	}
	
	@ApiOperation(value="获取班级信息", notes="删除角色信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "rolesId", value = "角色ID", required = true, dataType = "Integer", paramType = "query"),
	})
	
	/**
	 * 单个删除 http://localhost:8080/role/deleteOneRole
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/deleteOneRoles")
	public Object deleteOneRoles(@RequestParam Integer rolesId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int delRole = rolesService.deleteOneRoles(rolesId);
			if (delRole > 0) {
				map.put("success", true);
				map.put("message", "删除成功");
			} else {
				map.put("success", false);
				map.put("message", "删除失败");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", "该角色与模块有关,删除失败");
		}

		return map;

	}
	

	@ApiOperation(value="获取班级信息", notes="修改角色信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "rolesNames", value = "角色名", required = true, dataType = "String", paramType = "query"),
	@ApiImplicitParam(name = "rolesExplan", value = "角色备注", required = true, dataType = "String", paramType = "query"),
	@ApiImplicitParam(name = "rolesId", value = "角色ID", required = true, dataType = "Integer", paramType = "query")
	})
	
	
	/**
	 * 修改角色 http://localhost:8080/role/updateRole
	 * 
	 * @param roleName
	 * @param roleExplain
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/updateRoles")
	public Object updateRoles(@RequestParam String rolesNames, @RequestParam String rolesExplan,@RequestParam Integer rolesId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String roleNames = rolesService.findRolesName(rolesNames);
		if (rolesNames != null && !"".equals(rolesNames)) {
			map.put("success", false);
			map.put("message", "修改的角色名称不能重复,修改失败");
		} else {
			int updateRoles = rolesService.updateRoles(rolesNames, rolesExplan, rolesId);
			if (updateRoles > 0) {
				map.put("success", true);
				map.put("message", "修改成功");
			} else {
				map.put("success", false);
				map.put("message", "修改失败");
			}
		}
		return map;
	}


}
