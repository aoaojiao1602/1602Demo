package com.ysd.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.service.PermissionsService;
import com.ysd.boot.tool.Result;
@CrossOrigin
@RestController
@RequestMapping(value="/permissions",name="权限管理")
public class PermissionsController {
	
	@Autowired
	private PermissionsService permissionsService;
	
	@GetMapping(value="/updateAllPermissions",name="更新所有权限")
	public Object updateAllPermissions() {
		Integer k=permissionsService.updatePermissionsCount();
		Result result=new Result();		
			result.setState(1);
			result.setMsg("成功更新 "+k+" 条权限");		
		return result;		
	}
	
	/**
	 * 通过角色id得到权限树
	 * 角色已有的权限呈选中状态
	 * http://localhost:8006/permissions/queryPermissionTree?roleId=1
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/queryPermissionTree")
	public Object queryPermissionTree(Integer roleId,String access_token) {
		
		return permissionsService.queryPermissionTree(roleId);
	}
	
	/***
	 * 给角色添加权限
	 */
	
	/***
	 *通过角色rid添加模块菜单
	 * http://localhost:8006/permissions/insertRolesPermissions?rid=1&permissionsId=1,2
	 */	
	@RequestMapping("/insertRolesPermissions")
	public Object  insertRolesPermissions(Integer rid, String permissionsId,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> list=new ArrayList<Integer>();
		String[] s=permissionsId.split(",");	
		for (int i = 0; i < s.length; i++) {
			list.add(Integer.parseInt(s[i]));			
		}
		int k =permissionsService.insertRolesPermissionsByRoleId(rid, list);
			 if(k>0){
				    map.put("success", true);
					map.put("message", "添加成功");
				}else {
					map.put("success", false);
					map.put("message", "添加失败");
				}			
			 
		return map;
		
    
    	 
	}
	

	/***
	 *通过角色id删除权限菜单
	 *http://localhost:8006/permissions/deleteRolesPermissionsByRoleId?rid=1
	 */	
	@RequestMapping("/deleteRolesPermissionsByRoleId")
	public Object deleteRolesPermissionsByRoleId(Integer rid,String access_token) {
		
    
    	return permissionsService.deleteRolesPermissionsByRoleId(rid);
	}
	
	
	

}
