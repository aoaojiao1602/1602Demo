package com.ysd.boot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Department;

public interface DepartmentMapper extends JpaRepository<Department, Integer>,JpaSpecificationExecutor<Department>{

	/**
	 * 通过学校id查部门信息
	 * @param schoolid
	 * @return
	 */
	@Query(value = "SELECT * FROM departmenttb WHERE school_id=?1", nativeQuery = true)
	public List<Department> getDepartmentListBYschoolid(Integer schoolid);
	
	/***
	 * 通过老师id得到DepartmentId
	 * @param tid
	 * @return
	 */
	@Query(value = "SELECT department_users_id FROM users_department WHERE users_department_id=?1", nativeQuery = true)
	public int getDidBytid(Integer tid);
	
	
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
	
	/***
	 * 分页查询部门
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<Department> findByDepartmentNameContaining(String name,Pageable pageable);
	
	
	/***
	 *  通过学校id得到部门信息
	 * @param id
	 * @return
	 */
	//public List<Department> getDepartmentListById(@Param("schoolId")Integer schoolId);
}
