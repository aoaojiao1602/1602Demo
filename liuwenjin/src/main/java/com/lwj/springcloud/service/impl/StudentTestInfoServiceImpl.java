package com.lwj.springcloud.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.StudentTestInfoRepository;
import com.lwj.springcloud.dao.TestInfoRepository;
import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.entity.StudentTestInfo;
import com.lwj.springcloud.entity.TestInfo;
import com.lwj.springcloud.service.StudentTestInfoService;
import com.lwj.springcloud.tools.Random;

@Service
public class StudentTestInfoServiceImpl implements StudentTestInfoService {
	@Autowired
	private StudentTestInfoRepository sTestInfoRepository;

	@Override
	@Transactional
	public StudentTestInfo insertStudentTestInfo(StudentTestInfo stu) {
		// TODO Auto-generated method stub
		return sTestInfoRepository.save(stu);
	}

	@Override
	@Transactional
	public int updateStudentTestInfo(StudentTestInfo stu) {
		// TODO Auto-generated method stub
		return sTestInfoRepository.updateStudentTestInfo(stu);
	}

	@Override
	@Transactional
	public int deleteStudentTestInfo(Integer id) {
		// TODO Auto-generated method stub
		return sTestInfoRepository.deleteStudentTestInfo(id);
	}

	@Autowired
	private TestInfoRepository tRepository;

	@Override
	@Transactional
	public Map<String, Object> indexStudentTestInfo(int stuid, int testId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		StudentTestInfo sTestInfo = sTestInfoRepository.indexStudentTestInfo(stuid, testId);
		TestInfo testInfo = sTestInfoRepository.queryTestInfo(testId);
		map.put("testInfo", testInfo);
		List<Question> questionsList = new ArrayList<Question>();
		StudentTestInfo sInfo = new StudentTestInfo();
		if (sTestInfo == null) {
			sInfo.setStudentId(stuid);
			sInfo.setTestInfo(testInfo);
			sInfo.setTestNum(testInfo.getTestNum());
			sInfo.setSpareTime(testInfo.getSpareTime());
			sInfo.setTestScore(0);
			// 添加学生信息
			StudentTestInfo studentTestInfo = insertStudentTestInfo(sInfo);
			map.put("studentTestInfo", studentTestInfo);
			if (testInfo.getOptionNum() > 0) {
				List<Integer> qpList = tRepository.queryOptions(testInfo.getSectionId());
				List<Integer> oidlist = Random.GetRandomIsRepeat(testInfo.getOptionNum(), qpList);
				for (Integer integer : oidlist) {
					// tRepository.inserStudentQuerExamQuestiontb(stuid,testId,integer);
					questionsList.add(tRepository.queryQuestion(integer));
				}
			}
		} else {
			map.put("studentTestInfo", sTestInfoRepository.indexStudentTestInfo(stuid, testId));
			if (testInfo.getOptionNum() > 0) {
				List<Integer> qpList = tRepository.queryOptions(testInfo.getSectionId());
				List<Integer> oidlist = Random.GetRandomIsRepeat(testInfo.getOptionNum(), qpList);
				for (Integer integer : oidlist) {
					// tRepository.inserStudentQuerExamQuestiontb(stuid,testId,integer);
					questionsList.add(tRepository.queryQuestion(integer));
				}
			}
		}

		map.put("question", questionsList);
		return map;
	}

	@Override
	public int checkDaan(int[] qids, String[] daans) {
		// TODO Auto-generated method stub
		int n = 0;
		for (int i = 0; i < qids.length; i++) {
			Question question = tRepository.queryQuestion(qids[i]);
			if (question.getOptions() != null && question.getOptions().getAnswer().equals(daans[i])) {
				n += question.getOptions().getScore();
			}
		}
		return n;
	}

	@Override
	@Transactional
	public int updateStudentTestInfoScore(int stuid, int testid, int score) {
		// TODO Auto-generated method stub
		StudentTestInfo sInfo = sTestInfoRepository.queryStudentTestInfo(testid);

		System.out.println("1111111111111111>=" + sInfo.getTestScore());

		if (score > sInfo.getTestScore()) {
			return sTestInfoRepository.updateStudentTestInfoScore(stuid, testid, score, sInfo.getTestNum() - 1);
		} else {
			return sTestInfoRepository.updateStudentTestInfoScore(stuid, testid, sInfo.getTestScore(),sInfo.getTestNum() - 1);
		}
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: stuCheckTest</p> 
	 * <p>Description: </p> 
	 * @param sectionid
	 * @param stuid
	 * @return 
	 * @see com.lwj.springcloud.service.StudentTestInfoService#stuCheckTest(int, int) 
	*/
	
	@Override
	public Map<String, Object> stuCheckTest(int sectionid, int stuid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TestInfo testInfo=sTestInfoRepository.queryTestInfobysection_id(sectionid);
		map.put("testInfo",testInfo);
		if (testInfo!=null) {
			map.put("studentTestInfo",sTestInfoRepository.queryStudentTestInfoBySectionidByStuid(testInfo.getTestId(),stuid));
		}else {
			map.put("studentTestInfo",new StudentTestInfo());
		}
		return map;
		/**
		 * stuCheckTest(这里用一句话描述这个方法的作用)
		*/
		
	}
}
