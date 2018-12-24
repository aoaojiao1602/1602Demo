package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.SchoolMapper;
import com.ysd.boot.entity.School;
import com.ysd.boot.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolMapper schoolMapper;
	
	/**
	 * 通过id得到院校信息
	 * @param id
	 * @return
	 */
	@Override
	public School getAllById(Integer id) {
		// TODO Auto-generated method stub
		return schoolMapper.getOne(id);
	}

	
	/**
	 * 查询全部的学校
	 * @return
	 */
	public List<School> getAllSchoolList(){
		
		return schoolMapper.findAll();
	}
	
	/***
	 * 添加学校
	 * @param school
	 * @return
	 */
	@Transactional
	 public int addSchool(String schoolName) {
		
		return schoolMapper.addSchool(schoolName);
	}
	
	/**
	 * 删除学校
	 * @param id
	 * @return
	 */
	@Transactional
	public int deleteSchool(Integer id) {
		
		return schoolMapper.deleteSchool(id);
		
	}
	
	/***
	 *修改学校
	 * @param school
	 * @return
	 */
	@Transactional
	public int updateSchool(String schoolName,Integer schoolId){
		
		return schoolMapper.updateSchool(schoolName, schoolId);
	}
}
