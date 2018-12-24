package com.ysd.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.service.PermissionsService;
import com.ysd.boot.service.UsersService;


@RestController
@RequestMapping("/che")
public class CheckPermissionsController {
	
	@Autowired
	private PermissionsService permissionsService;
	
	@Autowired
	private UsersService usersService;
	
	
	/***
	 * 通过用户名查找用户
	 * @param username
	 * @return
	 */
	@RequestMapping("/queryUserByUserName")
	public Object queryUserByUserName(String username) {
		
		return usersService.queryUserByUserName(username);
		
	}
	
	/***
	 * 通过用户id查找用户角色id
	 * @param uid
	 * @return
	 */
	@RequestMapping("/queryRoleIdByUserId")
	public Object queryRoleIdByUserId(Integer uid){
		
		return usersService.queryRoleIdByUserId(uid);
		
	}
	
	/***
	 * 通过角色id得到权限id
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/queryPermissionIdByRoleId")
	public Object queryPermissionIdByRoleId(String rid){
		List<Integer> list = new ArrayList<Integer>();
		 String[] splitstr=rid.split(",");
		    for(String res : splitstr){
		      list.add(Integer.parseInt(res));
		    }
		return permissionsService.queryPermissionIdByRoleId(list);
		
	}
	
	/**
	 *通过权限id得到权限
	 * @param permissionId
	 * @return
	 */
	
	@RequestMapping("/queryPermissionByPermissionId")
	public Object queryPermissionByPermissionId(String permissionId){
		List<Integer> list = new ArrayList<Integer>();
		 String[] splitstr=permissionId.split(",");
		    for(String res : splitstr){
		      list.add(Integer.parseInt(res));
		    }
		return permissionsService.queryPermissionByPermissionId(list);
	}
	
	/***
	 * 得到所有权限
	 * @return
	 */
	@RequestMapping("/queryAllPermission")
	public Object queryAllPermission(){
		
		return permissionsService.queryAllPermission();
	}

}
