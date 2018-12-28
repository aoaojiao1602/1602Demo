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
	
	// 分页条件查询
		public Page<Roles> findByrolesName(String rolesName, Integer page, Integer size);
	
	// 添加角色
		public int insertRoles(String rolesName, String rolesExplan);
		
		// 添加时判断角色名称是否重复
		public String findRolesName(String rolesName);
		
		
		// 单个删除
		public int deleteOneRoles(Integer rolesId);

		
		// 角色修改
		public int updateRoles(String rolesName, String rolesExplan, Integer rolesId);
}
