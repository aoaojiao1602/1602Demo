package com.ysd.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Department;

public interface DepartmentMapper extends JpaRepository<Department, Integer>,JpaSpecificationExecutor<Department>{

	/**
	 * 添加部门信息
	 * @param departmentName
	 * @param school_id
	 * @return
	 */
	@Modifying
	@Query(value = "INSERT INTO departmenttb (department_name,school_id) VALUES(?1,?2)", nativeQuery = true)
	public int addDepartment(@Param("departmentName")String departmentName,@Param("school_id")Integer school_id);
	
	/**
	 *通过id 删除部门信息
	 * @param departmentId
	 * @return
	 */
	@Modifying
	@Query(value = "DELETE FROM departmenttb WHERE department_id = ?1 " , nativeQuery = true)
	public int deleteDepartment(@Param("departmentId")Integer departmentId);
	
	
	/***
	 * 通过id修改部门信息
	 * @param departmentId
	 * @param departmentName
	 * @param school_id
	 * @return
	 */
	@Modifying
	@Query(value = "UPDATE departmenttb SET department_name = ?2,school_id = ?3 WHERE department_id = ?1", nativeQuery = true)
	public int updateDepartment(@Param("departmentId")Integer departmentId,@Param("departmentName")String departmentName,@Param("school_id")Integer school_id );
	
}
