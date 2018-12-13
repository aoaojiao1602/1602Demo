package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwj.springcloud.dao.StudentTestInfoRepository;
import com.lwj.springcloud.service.StudentTestInfoService;
@Service
public class StudentTestInfoServiceImpl implements StudentTestInfoService {
	@Autowired
	private StudentTestInfoRepository sTestInfoRepository;
}
