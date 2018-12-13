package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwj.springcloud.dao.StudentExamInfoRepository;
import com.lwj.springcloud.service.StudentExamInfoService;
@Service
public class StudentExamInfoServiceImpl implements StudentExamInfoService {
	@Autowired
	private StudentExamInfoRepository sExamInfoRepository;
}
