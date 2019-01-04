package com.ysd.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	 *通过permission_name=''查询跟菜单
	 */
	@Query(value = "SELECT * FROM  permissiontb  WHERE permission_name LIKE '%管理'" , nativeQuery = true)
	public List<Permissions> queryPermissionsRoot();
	
	
	/****
	 * 通过permissionsModule和permission_name查询子菜单
	 * @param permissionsModule
	 * @return
	 */
	@Query(value = "SELECT * FROM  permissiontb  WHERE permission_module=?1 AND  LEFT(permissiontb.permission_name, 1)='Y'" , nativeQuery = true)
	public List<Permissions> queryPermissionsChild(String permissionsModule);
	
	/**
	 * 通过角色添加权限
	 * @param roleId
	 * @param moduleId
	 * @return
	 */
	@Query(value = "INSERT INTO permissions_roles (roles_permissions_id, permissions_roles_id) VALUES(?1,?2)" , nativeQuery = true)
	@Modifying
	public int insertRolesPermissionsByRoleId(Integer roleId,Integer permissionsId);
	
	
	/***
	 *通过角色id删除权限菜单
	 */
	@Query(value = "DELETE FROM permissions_roles WHERE roles_permissions_id = ?1" , nativeQuery = true)
	@Modifying
	public int deleteRolesPermissionsByRoleId(Integer id);
	
	
}
