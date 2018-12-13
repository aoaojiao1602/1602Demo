package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwj.springcloud.dao.QuestionRepository;
import com.lwj.springcloud.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository qRepository;
}
