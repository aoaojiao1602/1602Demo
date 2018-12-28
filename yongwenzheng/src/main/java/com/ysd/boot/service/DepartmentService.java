package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.ysd.boot.entity.Department;

public interface DepartmentService {
	
	
	
	
	/**
	 * 通过学校id查部门信息
	 * @param schoolid
	 * @return
	 */
	public List<Department> getDepartmentListBYschoolid(Integer schoolid);
	
	
	/**
	 * 通过id得到部门信息
	 * @param id
	 * @return
	 */
	public Department getAllById(Integer id);
	
	/***
	 * 通过老师id得到DepartmentId
	 * @param tid
	 * @return
	 */
	public int getDidBytid(Integer tid);
	
	
	
	/**
	 * 添加部门信息
	 * @param departmentName
	 * @param school_id
	 * @return
	 */
	public int addDepartment(String departmentName,Integer school_id);
	
	/**
	 *通过id 删除部门信息
	 * @param departmentId
	 * @return
	 */
	public int deleteDepartment(Integer departmentId);
	
	/***
	 * 通过id修改部门信息
	 * @param departmentId
	 * @param departmentName
	 * @param school_id
	 * @return
	 */
	public int updateDepartment(Integer departmentId,String departmentName,Integer school_id );
	
	/**
	 * 查询所有部门信息
	 * @return
	 */
	public List<Department>  getAllDepartmentLIst();
	
	 /**
             * 分页查询部门信息
      * @param name
      * @param pageable
      * @return
      */
	public Page<Department> queryDepartmentByPage(Integer page,Integer rows,String name);

}
