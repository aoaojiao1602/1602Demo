package com.lwj.springcloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.ExaminfoRepository;
import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.entity.Question;
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
			if (examinfo.getJudgeNum()>0) {
				List<Integer> qpList=eRepository.queryJudges();
				System.err.println(qpList);
				List<Integer> oidlist= Random.GetRandomIsRepeat(examinfo.getJudgeNum(), qpList);
				for (int i = 0; i < oidlist.size(); i++) {
					eRepository.insetExamQuestiontb(oidlist.get(i),exa.getExId());
				}
				
			}/*
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
		return eRepository.findAll(this.getWhereClause(search),pageable);
	}
	private Specification<Examinfo> getWhereClause(final Entitysearch entitysearch) {
		// TODO Auto-generated method stub
		 return new Specification<Examinfo>() {
			 @Override
			 public Predicate toPredicate(Root<Examinfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				 Predicate predicate = cb.conjunction();//动态SQL表达式
				 List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
				 if (entitysearch.getName()!= null&&!entitysearch.getName().equals("")) {
					 if( entitysearch.getName() != null && !"".equals(entitysearch.getName()) ){
						 exList.add(cb.like(root.get("paperName").as(String.class), "%"+entitysearch.getName()+"%"));
					 }
				}
				 if( entitysearch.getStartTime() != null ){
					 exList.add(cb.greaterThanOrEqualTo(root.<Date>get("createTime"), entitysearch.getStartTime()));//大于等于起始日期
				 }
				 if( entitysearch.getEndTime() != null ){ 
					 exList.add(cb.lessThanOrEqualTo(root.<Date>get("createTime"), entitysearch.getEndTime()));//小于等于截止日期
				 }
				 if( entitysearch.getIsLockout() != null ){ 
					 exList.add(cb.equal(root.<Integer>get("kId"), entitysearch.getIsLockout()));//小于等于截止日期
				 }
				 return predicate;
				 }
			 };
		 }
	
	/* (非 Javadoc) 
	 * <p>Title: queryQuestionTypeCount</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.lwj.springcloud.service.ExaminfoService#queryQuestionTypeCount() 
	*/
	
	@Override
	public Map<String, Object> queryQuestionTypeCount() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<Question> qList=eRepository.queryQuestionAll();
		int optionNum=0;
		int judgeNum=0;
		int fillblanks=0;
		for (Question question : qList) {
			if (question.getOptions()!=null) {
				optionNum++;
			}
			if (question.getJudges()!=null) {
				judgeNum++;
			}
			if (question.getFillblanks()!=null) {
				fillblanks++;
			}
		}
		map.put("optionNum", optionNum);
		map.put("judgeNum", judgeNum);
		map.put("fillblanks", fillblanks);
		return map;
		/**
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: queryCoursesByid</p> 
	 * <p>Description: </p> 
	 * @param cid
	 * @return 
	 * @see com.lwj.springcloud.service.ExaminfoService#queryCoursesByid(int) 
	*/
	
	@Override
	public List<Examinfo> queryCoursesByid(int cid) {
		// TODO Auto-generated method stub
		return eRepository.queryCoursesByid(cid);
		/**
		 * queryCoursesByid(这里用一句话描述这个方法的作用)
		*/
		
	}

}
