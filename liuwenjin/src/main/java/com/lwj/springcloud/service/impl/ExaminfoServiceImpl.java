package com.lwj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.ExaminfoRepository;
import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.service.ExaminfoService;

@Service
public class ExaminfoServiceImpl implements ExaminfoService {
	@Autowired
	private ExaminfoRepository eRepository;

	@Override
	@Transactional
	public Examinfo insertExaminfo(Examinfo examinfo) {
		// TODO Auto-generated method stub
		return eRepository.save(examinfo);
	}

	@Override
	@Transactional
	public int updateExaminfo(Examinfo examinfo) {
		// TODO Auto-generated method stub
		return eRepository.updateQuestion(examinfo);
	}

	@Override
	@Transactional
	public int deleteExaminfo(Integer exId) {
		// TODO Auto-generated method stub
		return eRepository.deleteExaminfo(exId);
	}

	@Override
	public Page<Examinfo> indexExaminfoPage(Entitysearch search) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(search.getPage()-1, search.getRows());
		return eRepository.findAll(pageable);
	}

}
