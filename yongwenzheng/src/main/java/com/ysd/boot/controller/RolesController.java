package com.ysd.boot.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.Roles;
import com.ysd.boot.service.ModuleService;
import com.ysd.boot.service.RolesService;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RolesController {
	
	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private ModuleService moduleService;
	
	
	/**
	 * 多条件分页查询
	 * http://localhost:8006/role/queryRolesPage?page=1&rows=10&name=&access_token=
	 * @param userQ
	 * @return
	 */
	@RequestMapping(value="/queryRolesPage",method=RequestMethod.GET)
	public Object queryRolesPage(Integer page,Integer rows,String name,String access_token) {
      Page<Roles> pages=rolesService.queryRolesPage(page, rows, name);
		Map<String, Object> map = new HashMap<>();
    	map.put("total", pages.getTotalElements());
    	map.put("rows",pages.getContent());
    	return map;
	}
	
	
	/**
	 * 添加角色 
	 * http://localhost:8006/role/insertRoles?rolesName=要记得那时候&rolesExplan=ejfiisnfoiafh
	 * @param rolesName
	 * @param rolesExplain
	 * @return
	 */
	@RequestMapping(value="/insertRoles",method=RequestMethod.PUT)
	public Object insertRoles(String rolesName,String rolesExplan,String access_token) {
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
	
	/**
	 * 单个删除
	 *  http://localhost:8006/role/deleteOneRoles?rolesId=5
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/deleteOneRoles",method=RequestMethod.DELETE)
	public Object deleteOneRoles(Integer rolesId,String access_token) {
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
	
	
	/**
	 * 修改角色 
	 * http://localhost:8006/role/updateRoles?rolesNames=admin&rolesExplan=1&rolesId=5
	 * @param roleName
	 * @param roleExplain
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/updateRoles",method=RequestMethod.POST)
	public Object updateRoles(String rolesNames,String rolesExplan,Integer rolesId,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String roleNames = rolesService.findRolesName(rolesNames);
			if (roleNames.equals(rolesNames)) {
				map.put("success", false);
				map.put("message", "修改的角色名称不能重复,修改失败");
			} 
		} catch (Exception e) {
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
	
	
	
	
	
	
	/**
	 * 显示role角色菜单模块
	 * 在给角色设置菜单上显示
	 *  http://localhost:8006/role/queryRoleSetModuleTree?roleIds=1
	 * @return
	 */
	@RequestMapping("/queryRoleSetModuleTree")
	public Object queryRoleSetModuleTree(Integer roleIds,String access_token) {
		
    
    	return moduleService.queryRoleSetModuleTree(roleIds);
	}
	
	
	
	
	
	
	/***
	 *通过角色id删除模块菜单
	 *http://localhost:8006/role/deleteRolesMoudelBy?rid=3
	 */	
	@RequestMapping("/deleteRolesMoudelBy")
	public Object deleteRolesMoudelBy(Integer rid,String access_token) {
		
    
    	return moduleService.deleteRolesMoudelBy(rid);
	}
	
	

	
	
	
	/***
	 *通过角色rid添加模块菜单
	 *http://localhost:8006/role/insertRolesMoudelBy?rid=3&moduleId=3
	 */	
	@RequestMapping("/insertRolesMoudelBy")
	public Object  insertRolesMoudelBy(Integer rid, String moduleId,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> list=new ArrayList<Integer>();
		String[] s=moduleId.split(",");	
		for (int i = 0; i < s.length; i++) {
			list.add(Integer.parseInt(s[i]));			
		}
		int k =moduleService.insertRolesMoudelBy(rid, list);
			 if(k>0){
				    map.put("success", true);
					map.put("message", "添加成功");
				}else {
					map.put("success", false);
					map.put("message", "添加失败");
				}			
			 
		return map;
		
    
    	 
	}
	
	
	


}
