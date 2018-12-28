package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.DepartmentMapper;
import com.ysd.boot.entity.Department;
import com.ysd.boot.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapper departmentMapper;
	
	
	/**
	 * 通过学校id查部门信息
	 * @param schoolid
	 * @return
	 */
	public List<Department> getDepartmentListBYschoolid(Integer schoolid){
		System.out.println("getDepartmentListBYschoolid====>"+schoolid);
		
		return departmentMapper.getDepartmentListBYschoolid(schoolid);
	}
	
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
	
	/***
	 * 通过老师id得到DepartmentId
	 * @param tid
	 * @return
	 */
	public int getDidBytid(Integer tid) {
		
		return departmentMapper.getDidBytid(tid);
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
	
	
	
	
	/**
	 * 分页查询部门信息
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<Department> queryDepartmentByPage(Integer page,Integer rows,String name){
		  Pageable pageable = new PageRequest(page-1, rows);
    	  return departmentMapper.findByDepartmentNameContaining(name, pageable);	
	}

	
	
	
	/***
	 *  通过学校id得到部门信息
	 * @param id
	 * @return
	 */
	/*public List<Department> getDepartmentListById(Integer schoolId){
		
		
	}*/

}
