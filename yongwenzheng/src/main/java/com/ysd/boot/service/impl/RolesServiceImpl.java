package com.ysd.boot.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.RolesMapper;
import com.ysd.boot.entity.Roles;
import com.ysd.boot.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService {
	
	@Autowired
     private RolesMapper rolesMapper;
	
	/***
	 * 通过角色id得到角色信息
	 * @param rid
	 * @return
	 */
	 public String getRoleByRid(Integer rid) {
		 
		 return rolesMapper.getRoleNameByRid(rid);
	 }
	
	
	/**
	 * 分页条件查询
	 */
	@Override
	public Page<Roles> findByrolesName(String rolesName, Integer page,Integer size) {
		Sort sort=new Sort(Sort.Direction.DESC,"rolesCreateTime","rolesLastUpdateTime");
		//Pageable pageable=PageRequest.of(page, size, sort);
		Pageable pageable=new PageRequest(page, size,sort);
		return rolesMapper.findByRolesNameLike("%"+rolesName+"%", pageable);
	}
	
	
	/**
	 * 添加角色
	 */
	@Override
	@Transactional
	public int insertRoles(String rolesName, String rolesExplan) {
		Date rolesCreateTime=new Date();
		return rolesMapper.insertRoles(rolesName, rolesExplan, rolesCreateTime);
	}

	
	/**
	 * 添加时判断角色名称是否重复
	 */
	@Override
	public String findRolesName(String rolesName) {
		return rolesMapper.findRolesName(rolesName);
	}
	
	

	/**
	 *  单个删除
	 */
	@Override
	public int deleteOneRoles(Integer rolesId) {
		return rolesMapper.deleteOneRoles(rolesId);
	}
	
	
	
	/**
	 * 角色修改
	 */
	@Override
	@Transactional
	public int updateRoles(String rolesName, String rolesExplan, Integer rolesId) {
		return rolesMapper.updateRoles(rolesName, rolesExplan, rolesId);
	}
}
