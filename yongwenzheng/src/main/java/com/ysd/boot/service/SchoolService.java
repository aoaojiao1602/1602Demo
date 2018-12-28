package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ysd.boot.entity.Clazz;
import com.ysd.boot.entity.School;

public interface SchoolService {
	
	/**
	 * 通过id得到院校信息
	 * @param id
	 * @return
	 */
	public School getAllById(Integer id);
	
	/**
	 * 查询全部的学校
	 * @return
	 */
	public List<School> getAllSchoolList();
	
	/***
	 * 添加学校
	 * @param school
	 * @return
	 */
	 public int addSchool(String schoolName);
	
	/**
	 * 删除学校
	 * @param id
	 * @return
	 */
	public int deleteSchool(Integer id);
	
	/***
	 *修改学校
	 * @param school
	 * @return
	 */
	public int updateSchool(String schoolName,Integer schoolId);
	
	  /** 
	  	* 分页查询学校
	  	* @param name
	  	* @param pageable
	  	* @return
	  	*/
    public Page<School> querySchoolByPage(Integer page,Integer rows,String name);

}
