package com.lwj.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.TestInfoRepository;
import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.TestInfo;
import com.lwj.springcloud.service.TestInfoService;
import com.lwj.springcloud.tools.Random;
@Service
public class TestInfoServiceImpl implements TestInfoService {
	@Autowired
	private TestInfoRepository tRepository;

	@Override
	@Transactional
	public TestInfo insertTestInfo(TestInfo t) {
		// TODO Auto-generated method stub
		TestInfo tInfo=tRepository.save(t);
		/*if (t.getOptionNum()>0) {
			List<Integer> qpList=tRepository.queryOptions(t.getSectionId());
			System.err.println(qpList);
			Random.GetRandomIsRepeat(t.getOptionNum(), qpList);
//			for (int i = 0; i < oidlist.size(); i++) {
//				tRepository.insetTestQuestiontb(oidlist.get(i),tInfo.getTestId());
//			}
			
		}*/
		return tInfo;
	}

	@Override
	@Transactional
	public int updateTestInfo(TestInfo t) {
		// TODO Auto-generated method stub
		return tRepository.updateTestInfo(t);
	}

	@Override
	@Transactional
	public int deleteTestInfo(Integer testId) {
		// TODO Auto-generated method stub
		return tRepository.deleteTestInfo(testId);
	}

	@Override
	public Page<TestInfo> indexTestInfoPage(Entitysearch search) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.DESC, "testId");
		Pageable pageable = new PageRequest(search.getPage() - 1, search.getRows(), sort);
		return tRepository.findByTestNameLike("%"+search.getName()+"%", pageable);
	}
}
