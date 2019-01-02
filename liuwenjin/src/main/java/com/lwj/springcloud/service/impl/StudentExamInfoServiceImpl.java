package com.lwj.springcloud.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.ExaminfoRepository;
import com.lwj.springcloud.dao.StudentExamInfoRepository;
import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.entity.StudentExamInfo;
import com.lwj.springcloud.entity.StudentExamQuestion;
import com.lwj.springcloud.service.ExaminfoService;
import com.lwj.springcloud.service.StudentExamInfoService;
import com.lwj.springcloud.tools.Random;
@Service
public class StudentExamInfoServiceImpl implements StudentExamInfoService {
	@Autowired
	private StudentExamInfoRepository sExamInfoRepository;

	@Override
	@Transactional
	public StudentExamInfo insertStudentExamInfo(StudentExamInfo stu) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.save(stu);
	}

	@Override
	@Transactional
	public int updateStudentExamInfo(StudentExamInfo stu) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.updateStudentExamInfo(stu);
	}

	@Override
	@Transactional
	public int deleteStudentExamInfo(Integer id) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.deleteStudentExamInfo(id);
	}

	
	/* (非 Javadoc) 
	 * <p>Title: indexStudentExamInfo</p> 
	 * <p>Description: </p> 
	 * @param stuid
	 * @param examid
	 * @return 
	 * @see com.lwj.springcloud.service.StudentExamInfoService#indexStudentExamInfo(int, int) 
	*/
	@Autowired
	private ExaminfoRepository eRepository;
	@Override
	@Transactional
	public Map<String, Object> indexStudentExamInfo(int stuid, int examid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		StudentExamInfo stuExamInfo=sExamInfoRepository.indexStudentExamInfo(stuid,examid);
		//获取考试信息
		Examinfo examinfo=sExamInfoRepository.queryExaminfo(examid);
		map.put("examinfo", examinfo);
		//第一下进入考试
		List<Question> questionsList =new ArrayList<Question>();
		if (stuExamInfo==null) {
			StudentExamInfo stu=new StudentExamInfo();
			stu.setStudentId(stuid);
			stu.setExaminfo(examinfo);
			stu.setTime(examinfo.getCxTime()*60*60);
			//添加学生信息
			StudentExamInfo studentExamInfo=insertStudentExamInfo(stu);
			map.put("studentExamInfo", studentExamInfo);
			if(examinfo.getExamType().equals("自主")) {
				if (examinfo.getOptionNum()>0) {
					List<Integer> qpList=eRepository.queryOptions();
					List<Integer> oidlist= Random.GetRandomIsRepeat(examinfo.getOptionNum(), qpList);
					for (Integer integer : oidlist) {
						eRepository.inserStudentQuerExamQuestiontb(stuid,examid,integer);
						questionsList.add(eRepository.queryQuestion(integer));
					}
				}
				if (examinfo.getJudgeNum()>0) {
					List<Integer> qpList=eRepository.queryJudges();
					List<Integer> oidlist= Random.GetRandomIsRepeat(examinfo.getJudgeNum(), qpList);
					for (Integer integer : oidlist) {
						eRepository.inserStudentQuerExamQuestiontb(stuid,examid,integer);
						questionsList.add(eRepository.queryQuestion(integer));
					}
				}
				/*
				if (examinfo.getFillblankNum()>0) {
					List<Integer> qpList=eRepository.queryFillblankNums();
					System.err.println(qpList);
					List<Integer> oidlist= Random.GetRandomIsRepeat(examinfo.getFillblankNum(), qpList);
					for (int i = 0; i < oidlist.size(); i++) {
						eRepository.insetExamQuestiontb(oidlist.get(i),exa.getExId());
					}
					
				}*/
			}else {
				List<Integer> qidlist= eRepository.queryExamQuestion(examinfo.getExId());
				for (Integer integer : qidlist) {
					eRepository.inserStudentQuerExamQuestiontb(stuid,examid,integer);
					questionsList.add(eRepository.queryQuestion(integer));
				}
			}
			//第二次进
		}else {
			map.put("studentExamInfo",sExamInfoRepository.indexStudentExamInfo(stuid,examid));
			List<StudentExamQuestion> qidlist=eRepository.queryStudentQuerExamQuestiontb(stuid, examid);
			for (StudentExamQuestion integer : qidlist) {
				Question question=eRepository.queryQuestion(integer.getQuestiontbId());
				question.setDaan(integer.getAnswer());
				questionsList.add(question);
			}
		}
		/*for (Question question : questionsList) {
			if (question.getOptions()!=null) {
				question.getOptions().setAnswer(null);
			}
			if (question.getJudges()!=null) {
				question.getJudges().setAnswer(null);
			}
			if (question.getFillblanks()!=null) {
				question.getFillblanks().setAnswer(null);
			}
		}*/
		map.put("question", questionsList);
		return map;
		/**
		 * indexStudentExamInfo(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: updateStudentExamInfoQuestion</p> 
	 * <p>Description: </p> 
	 * @param stuid
	 * @param examid
	 * @param daan
	 * @return 
	 * @see com.lwj.springcloud.service.StudentExamInfoService#updateStudentExamInfoQuestion(int, int, java.lang.String) 
	*/
	
	@Override
	@Transactional
	public int updateStudentExamInfoQuestion(String daan,int examid,int qid,int stuid,int time) {
		// TODO Auto-generated method stub
		sExamInfoRepository.updateStudentExamInfoTime(stuid,examid,time);
		return sExamInfoRepository.updateStudentExamInfoQuestion(daan,examid,qid,stuid);
		/**
		 * updateStudentExamInfoQuestion(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: updateStudentExamInfoTime</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.lwj.springcloud.service.StudentExamInfoService#updateStudentExamInfoTime() 
	*/
	
	@Override
	@Transactional
	public int updateStudentExamInfoTime(int stuid,int examid,int time) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.updateStudentExamInfoTime(stuid,examid,time);
		/**
		 * updateStudentExamInfoTime(这里用一句话描述这个方法的作用)
		*/
		
	}
	@Override
	public StudentExamInfo queryStudentExamInfoTime(int stuid, int examid) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.indexStudentExamInfo(stuid,examid);
		/**
		 * queryStudentExamInfoTime(这里用一句话描述这个方法的作用)
		*/
		
	}
	
	@Override
	public int checkDaan(int[] qids, String[] daans) {
		// TODO Auto-generated method stub
		int n=0;
		for (int i = 0; i < qids.length; i++) {
			Question question=eRepository.queryQuestion(qids[i]);
			if (question.getOptions()!=null&&question.getOptions().getAnswer().equals(daans[i])) {
				n+=question.getOptions().getScore();
			}
			if (question.getJudges()!=null&&question.getJudges().getAnswer().equals(daans[i])) {
				n+=question.getJudges().getScore();
			}
			if (question.getFillblanks()!=null&&question.getFillblanks().getAnswer().equals(daans[i])) {
				n+=question.getFillblanks().getScore();
			}
		}
		return n;
		/**
		 * checkDaan(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: updateStudentExamInfoScore</p> 
	 * <p>Description: </p> 
	 * @param stuid
	 * @param examid
	 * @param score
	 * @return 
	 * @see com.lwj.springcloud.service.StudentExamInfoService#updateStudentExamInfoScore(int, int, int) 
	*/
	
	@Override
	@Transactional
	public int updateStudentExamInfoScore(int stuid, int examid, int score) {
		// TODO Auto-generated method stub
		return sExamInfoRepository.updateStudentExamInfoScore(stuid,examid,score);
		/**
		 * updateStudentExamInfoScore(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: checkExamInfo</p> 
	 * <p>Description: </p> 
	 * @param stuid
	 * @param examid
	 * @return 
	 * @see com.lwj.springcloud.service.StudentExamInfoService#checkExamInfo(int, int) 
	*/
	
	@Override
	public Map<String, Object> checkExamInfo(int stuid, int examid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		//查询该考试的信息
		map.put("studentExamInfo",sExamInfoRepository.indexStudentExamInfo(stuid,examid));
		map.put("examInfo",sExamInfoRepository.queryExaminfo(examid));
		return map;
		/**
		 * checkExamInfo(这里用一句话描述这个方法的作用)
		*/
		
	}


}
