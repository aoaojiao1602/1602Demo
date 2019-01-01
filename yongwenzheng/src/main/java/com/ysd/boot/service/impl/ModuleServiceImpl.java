package com.ysd.boot.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.ModuleMapper;
import com.ysd.boot.entity.Module;
import com.ysd.boot.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService{
	
	@Autowired
	private ModuleMapper moduleMapper;
	
	
	/***
	 * 查询 树结构
	 * @param moduleName
	 * @return
	 */
	public List<Module> queryTreeGrid(String moduleName){
		if (moduleName==null) {
			moduleName="";
		}
		
		//查询所有根菜单
		List<Module> rootList=moduleMapper.queryChildrenById(0, "");
		//递归设置子菜单
		this.setChrild(rootList, moduleName);
		
		return rootList;
		
		
	};
	
	@SuppressWarnings("unused")
	private void setChrild(List<Module> parentList,String name) {
		for (Module module : parentList) {
			//查询子菜单
			List<Module> chrildModule=moduleMapper.queryChildrenById(module.getModuleId(), name);
			if (chrildModule !=null && !chrildModule.isEmpty()) {//不为空，有子菜单
				//设置子菜单
				module.setChildren(chrildModule);
				//如果有子菜单则继续递归设置子菜单
				this.setChrild(chrildModule,name);
				
			}
			
		}
		
	}
	
	

	
	
	/**
	 * RoleSetModuleTree
	 * 查询角色所有菜单并在角色已有的模块上呈现选中状态  RoleSetModuleTree 树形数据
	 * 
	 */
	@Override
	public List<Module> queryRoleSetModuleTree(Integer roleId) {
		    //查询角色所拥有的菜单模块moduleId
				List<Integer> moduleId=moduleMapper.queryByRolesIdGetSModuleId(roleId);
				
				System.out.println("moduleId=====>"+moduleId);
				//查询角色所拥有的菜单模块的根菜单
				List<Module> rootList=moduleMapper.queryChildrenById(0, "");				
				this.SetRoleModuleChildrens(rootList, moduleId);
				
				// TODO Auto-generated method stub
				return rootList;
	}
	
	
	/** 
	 * RoleSetModuleTree
	 * 给菜单模块 设置孩子
	 * @param rootList
	 */	
	@SuppressWarnings("unused")
	private void SetRoleModuleChildrens(List<Module> parentList,List<Integer> moduleId) {
		for (Module module : parentList) {
			//查询子菜单
			List<Module> chrildModule=moduleMapper.queryChildrenById(module.getModuleId(), "");
			if (chrildModule !=null && !chrildModule.isEmpty()) {//不为空，有子菜单
				//设置子菜单
				module.setChildren(chrildModule);
				//如果有子菜单则继续递归设置子菜单
				this.SetRoleModuleChildrens(chrildModule,moduleId);
				
			}else {
				if (moduleId.contains(module.getModuleId())) {
					module.setChecked(true);
				
				}
			}
			
			
			
		}
		
	}
	
	
	
	/***
	 *通过角色id删除rolemodule的模块
	 */	
	@Transactional
	public int deleteRolesMoudelBy(Integer id) {
		
		return moduleMapper.deleteRolesMoudelBy(id);
		
		
	};

	
     /***
	 *通过角色id添加模块
	 */
	@Transactional
	public int insertRolesMoudelBy(Integer roleId,List<Integer> moduleId) {
		int a;
		if (moduleId.size()>0) {
			for (Integer integer : moduleId) {
				moduleMapper.insertRolesMoudelBy(roleId, integer);
			}
			a=1;
		}else {
			a=0;
		}
		
		return a;
	};
	
	
	
	
	/***
	 * 添加模块
	 * @param mName
	 * @param mUrl
	 * @param mWeight
	 * @param pid
	 * @return
	 */
	@Transactional
	public int insertMoudle(String mName,String mUrl,Integer mWeight,Integer pid) {
		
		return moduleMapper.insertMoudle(mName, mUrl, mWeight, pid);
	}
	
	
	/***
	 * 通过模块名称查询模块
	 * @param mName
	 * @return
	 */
	public String getMoudleByName(String mName) {
		
		return moduleMapper.getMoudleByName(mName);
	}
	
	
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
	@Transactional
	public int updateMoudle(Integer mid,String mName,String mUrl,Integer mWeight,Date upDate) {
		
		return moduleMapper.updateMoudle(mid, mName, mUrl, mWeight, upDate);
	}
	
	
	/***
	 * 通过id删除模块
	 * @param mid
	 * @return
	 */
	@Transactional
	public int deleteMoudle(Integer mid) {
		
		return moduleMapper.deleteMoudle(mid);
	}
}
