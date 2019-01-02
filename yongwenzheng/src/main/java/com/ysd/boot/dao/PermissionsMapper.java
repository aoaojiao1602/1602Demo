package com.ysd.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.boot.entity.Module;
import com.ysd.boot.entity.Permissions;




public interface PermissionsMapper extends JpaRepository<Permissions, Integer>{

	//通过角色id得到权限id
	@Query(value = "SELECT permissions_roles_id FROM permissions_roles WHERE roles_permissions_id IN (?1)" , nativeQuery = true)
	public List<Integer> queryPermissionIdByRoleId(List<Integer> roleId);
	
	//通过权限id得到权限
	@Query(value = "SELECT * FROM permissiontb WHERE permission_id IN (?1)" , nativeQuery = true)
	public List<Permissions> queryPermissionByPermissionId(List<Integer> permissionId);
	
	
	
	/***
	 *查询角色拥有的权限id
	 */
	@Query(value = "SELECT permissions_roles_id FROM permissions_roles WHERE roles_permissions_id = ?1" , nativeQuery = true)
	public List<Integer> queryByRolesIdGetPermissionsId(Integer roleIds);
	
	
	/***
	 *通过permissionsModule进行分组
	 */
	@Query(value = "SELECT * FROM permissiontb GROUP BY permission_module" , nativeQuery = true)
	public List<Permissions> queryPermissionsGroupBy();
	
	
	/****
	 * 通过permissionsModule查询权限
	 * @param permissionsModule
	 * @return
	 */
	@Query(value = "SELECT * FROM permissiontb GROUP BY permission_module" , nativeQuery = true)
	public List<Permissions> queryPermissionsByPermissionsModule(String permissionsModule);
	
	
}
