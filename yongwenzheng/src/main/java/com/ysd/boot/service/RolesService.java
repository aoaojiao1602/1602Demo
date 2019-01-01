package com.ysd.boot.service;

import org.springframework.data.domain.Page;

import com.ysd.boot.entity.Roles;



public interface RolesService {
	
	/***
	 * 通过角色id得到角色信息
	 * @param rid
	 * @return
	 */
	 public String getRoleByRid(Integer rid);
	
	
	 // 添加角色
	 public int insertRoles(String rolesName, String rolesExplan);
		
	 // 添加时判断角色名称是否重复
	 public String findRolesName(String rolesName);
		
		
	 // 单个删除
	 public int deleteOneRoles(Integer rolesId);

		
	 // 角色修改
	 public int updateRoles(String rolesName, String rolesExplan, Integer rolesId);

     
	 /***
		 * 带条件分页查询角色
		 * @param page
		 * @param rows
		 * @param name
		 * @return
		 */
    public Page<Roles> queryRolesPage(Integer page,Integer rows,String name);

}
