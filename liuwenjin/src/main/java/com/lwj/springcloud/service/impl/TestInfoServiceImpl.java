package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwj.springcloud.dao.TestInfoRepository;
import com.lwj.springcloud.service.TestInfoService;
@Service
public class TestInfoServiceImpl implements TestInfoService {
	@Autowired
	private TestInfoRepository tRepository;
}
