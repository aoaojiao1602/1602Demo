package com.ysd.boot.service;

import java.util.Date;
import java.util.List;

import com.ysd.boot.entity.Module;


public interface ModuleService {
	
	/***
	 * 查 询树结构
	 * @param moduleName
	 * @return
	 */
	public List<Module> queryTreeGrid(String moduleName);
	
	
	/**
	 * RoleSetModuleTree
	 * 通过角色id
	 * 查询模块  RoleSetModuleTree 树形数据
	 * 
	 */
	public List<Module> queryRoleSetModuleTree(Integer roleId);

	
	/***
	 *通过角色id删除rolemodule的模块
	 */	
	public int deleteRolesMoudelBy(Integer id);

	
     /***
	 *通过角色id添加模块
	 */
	public int insertRolesMoudelBy(Integer roleId,List<Integer> moduleId);
	
	
	
	
	
	/***
	 * 添加模块
	 * @param mName
	 * @param mUrl
	 * @param mWeight
	 * @param pid
	 * @return
	 */
	public int insertMoudle(String mName,String mUrl,Integer mWeight,Integer pid);
	
	
	/***
	 * 通过模块名称查询模块
	 * @param mName
	 * @return
	 */
	public String getMoudleByName(String mName);
	
	
	/***
	 * 修改模块
	 * @param mid
	 * @param mName
	 * @param mUrl
	 * @param mWeight
	 * @param pid
	 * @param upDate
	 * @return
	 */
	public int updateMoudle(Integer mid,String mName,String mUrl,Integer mWeight,Date upDate);
	
	
	/***
	 * 通过id删除模块
	 * @param mid
	 * @return
	 */
	public int deleteMoudle(Integer mid);
	
	
	/***
	 * 通过角色拥有的模块id
	 * 查询角色拥有的子菜单
	 * @param name
	 * @return
	 */
	public List<Module> queryRolesTreeById(Integer rid);
}
