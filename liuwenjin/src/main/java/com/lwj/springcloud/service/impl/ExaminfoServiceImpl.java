package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.ExaminfoRepository;
import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.service.ExaminfoService;

@Service
public class ExaminfoServiceImpl implements ExaminfoService {
	@Autowired
	private ExaminfoRepository eRepository;

	@Override
	public Examinfo insertExaminfo(Examinfo examinfo) {
		// TODO Auto-generated method stub
		return eRepository.save(examinfo);
	}

	@Override
	public int updateExaminfo(Examinfo examinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int deleteExaminfo(Integer exId) {
		// TODO Auto-generated method stub
		return eRepository.deleteExaminfo(exId);
	}
}
