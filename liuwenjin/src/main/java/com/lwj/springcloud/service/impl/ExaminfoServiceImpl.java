package com.lwj.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.lwj.springcloud.tools.Random;

import ch.qos.logback.classic.layout.TTLLLayout;

@Service
public class ExaminfoServiceImpl implements ExaminfoService {
	@Autowired
	private ExaminfoRepository eRepository;

	@Override
	@Transactional
	public Examinfo insertExaminfo(Examinfo examinfo) {
		// TODO Auto-generated method stub
		Examinfo exa = eRepository.save(examinfo);
		if (examinfo.getExamType().equals("统一")) {
			if (examinfo.getOptionNum()>0) {
				List<Integer> qpList=eRepository.queryOptions();
				System.err.println(qpList);
				List<Integer> oidlist= Random.GetRandomIsRepeat(examinfo.getOptionNum(), qpList);
				for (int i = 0; i < oidlist.size(); i++) {
					eRepository.insetExamQuestiontb(oidlist.get(i),exa.getExId());
				}
				
			}
			/*if (examinfo.getJudgeNum()>0) {
				List<Integer> qpList=eRepository.queryJudges();
				System.err.println(qpList);
				List<Integer> oidlist= Random.GetRandomIsRepeat(examinfo.getJudgeNum(), qpList);
				for (int i = 0; i < oidlist.size(); i++) {
					eRepository.insetExamQuestiontb(oidlist.get(i),exa.getExId());
				}
				
			}
			if (examinfo.getFillblankNum()>0) {
				List<Integer> qpList=eRepository.queryFillblankNums();
				System.err.println(qpList);
				List<Integer> oidlist= Random.GetRandomIsRepeat(examinfo.getFillblankNum(), qpList);
				for (int i = 0; i < oidlist.size(); i++) {
					eRepository.insetExamQuestiontb(oidlist.get(i),exa.getExId());
				}
				
			}*/
		}
		return exa;
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
		Pageable pageable = new PageRequest(search.getPage() - 1, search.getRows());
		return eRepository.findAll(pageable);
	}

}
