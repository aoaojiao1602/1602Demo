package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

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
			
	/***
	 * 得到权限树
	 */
	public List<Permissions> queryPermissionTree(Integer roleId);
	
	 /***
		 *给角色id添加权限
	 */
	public int insertRolesPermissionsByRoleId(Integer roleId,List<Integer> permissionsId);
	
	/***
	 *通过角色id删除权限菜单
	 */
	public int deleteRolesPermissionsByRoleId(Integer id);
	
}
