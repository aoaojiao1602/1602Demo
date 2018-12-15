package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.StudentTestInfoRepository;
import com.lwj.springcloud.entity.StudentTestInfo;
import com.lwj.springcloud.service.StudentTestInfoService;
@Service
public class StudentTestInfoServiceImpl implements StudentTestInfoService {
	@Autowired
	private StudentTestInfoRepository sTestInfoRepository;

	@Override
	@Transactional
	public StudentTestInfo insertStudentTestInfo(StudentTestInfo stu) {
		// TODO Auto-generated method stub
		return sTestInfoRepository.save(stu);
	}

	@Override
	@Transactional
	public int updateStudentTestInfo(StudentTestInfo stu) {
		// TODO Auto-generated method stub
		return sTestInfoRepository.updateStudentTestInfo(stu);
	}

	@Override
	@Transactional
	public int deleteStudentTestInfo(Integer id) {
		// TODO Auto-generated method stub
		return sTestInfoRepository.deleteStudentTestInfo(id);
	}
}
