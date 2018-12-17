package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.TestInfoRepository;
import com.lwj.springcloud.entity.TestInfo;
import com.lwj.springcloud.service.TestInfoService;
@Service
public class TestInfoServiceImpl implements TestInfoService {
	@Autowired
	private TestInfoRepository tRepository;

	@Override
	@Transactional
	public TestInfo insertTestInfo(TestInfo t) {
		// TODO Auto-generated method stub
		return tRepository.save(t);
	}

	@Override
	@Transactional
	public int updateTestInfo(TestInfo t) {
		// TODO Auto-generated method stub
		return tRepository.updateTestInfo(t);
	}

	/*@Override
	@Transactional
	public int deleteTestInfo(Integer testId) {
		// TODO Auto-generated method stub
		return tRepository.deleteTestInfo(testId);
	}*/
}
