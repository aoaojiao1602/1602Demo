package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwj.springcloud.dao.ExaminfoRepository;
import com.lwj.springcloud.service.ExaminfoService;

@Service
public class ExaminfoServiceImpl implements ExaminfoService {
	@Autowired
	private ExaminfoRepository eRepository;
}
