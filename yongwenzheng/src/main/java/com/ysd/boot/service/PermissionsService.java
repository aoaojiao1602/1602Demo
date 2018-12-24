package com.ysd.boot.service;

import java.util.List;

import com.ysd.boot.entity.Permissions;






public interface PermissionsService {

	//通过角色id得到权限id
	public List<Integer> queryPermissionIdByRoleId(List<Integer> roleId);
	//通过权限id得到权限
	public List<Permissions> queryPermissionByPermissionId(List<Integer> permissionId);
	//得到所有权限
	public List<Permissions> queryAllPermission();
	
	//更新权限
	public int updatePermissionsCount();
	
}
