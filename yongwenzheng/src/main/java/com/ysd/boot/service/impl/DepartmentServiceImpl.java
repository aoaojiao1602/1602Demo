package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.DepartmentMapper;
import com.ysd.boot.entity.Department;
import com.ysd.boot.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 通过id得到部门信息
	 * @param id
	 * @return
	 */
	@Override
	public Department getAllById(Integer id) {
		// TODO Auto-generated method stub
		return departmentMapper.getOne(id);
	}	
	
	/**
	 * 添加部门信息
	 * @param departmentName
	 * @param school_id
	 * @return
	 */
	@Transactional
	public int addDepartment(String departmentName,Integer school_id) {
		
		return departmentMapper.addDepartment(departmentName, school_id);
	}
	
	/**
	 *通过id 删除部门信息
	 * @param departmentId
	 * @return
	 */
	@Transactional
	public int deleteDepartment(Integer departmentId) {
		
		return departmentMapper.deleteDepartment(departmentId);
	}
	
	/***
	 * 通过id修改部门信息
	 * @param departmentId
	 * @param departmentName
	 * @param school_id
	 * @return
	 */
	@Transactional
	public int updateDepartment(Integer departmentId,String departmentName,Integer school_id ) {
		
		return departmentMapper.updateDepartment(departmentId, departmentName, school_id);
	}
	
	/**
	 * 查询所有部门信息
	 * @return
	 */
	public List<Department>  getAllDepartmentLIst(){
		
		return departmentMapper.findAll();
	}
}
