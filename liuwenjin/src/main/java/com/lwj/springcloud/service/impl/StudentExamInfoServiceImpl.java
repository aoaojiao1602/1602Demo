package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.StudentExamInfoRepository;
import com.lwj.springcloud.entity.StudentExamInfo;
import com.lwj.springcloud.service.StudentExamInfoService;
@Service
public class StudentExamInfoServiceImpl implements StudentExamInfoService {
	@Autowired
	private StudentExamInfoRepository sExamInfoRepository;

	@Override
	@Transactional
	public StudentExamInfo insertStudentExamInfo(StudentExamInfo stu) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.save(stu);
	}

	@Override
	@Transactional
	public int updateStudentExamInfo(StudentExamInfo stu) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.updateStudentExamInfo(stu);
	}

	@Override
	@Transactional
	public int deleteStudentExamInfo(Integer id) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.deleteStudentExamInfo(id);
	}
}
