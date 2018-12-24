package com.lwj.springcloud.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.dao.QuestionRepository;
import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository qRepository;

	
	/* (非 Javadoc) 
	 * <p>Title: indexQuestionPage</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.lwj.springcloud.service.QuestionService#indexQuestionPage() 
	*/
	
	@Override
	public Page<Question> indexQuestionPage(Entitysearch search) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.DESC,"qId");
		Pageable pageable = new PageRequest(search.getPage()-1,search.getRows(), sort);
		return qRepository.findAll(this.getWhereClause(search),pageable);
		/**
		 * indexQuestionPage(这里用一句话描述这个方法的作用)
		*/
		
	}
	private Specification<Question> getWhereClause(final Entitysearch entitysearch) {
		// TODO Auto-generated method stub
		 return new Specification<Question>() {
			 @Override
			 public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				 Predicate predicate = cb.conjunction();//动态SQL表达式
				 List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
				 /*if(entitysearch.getName()!=null&&entitysearch.getTx().equals("")) {
					 exList.add(cb.like(root.get("optionId").get("topic").as(String.class), "%"+entitysearch.getName()+"%"));
					 exList.add(cb.like(root.get("judgeId").get("topic").as(String.class), "%"+entitysearch.getName()+"%"));
					 exList.add(cb.like(root.get("fillblankId").get("topic").as(String.class), "%"+entitysearch.getName()+"%"));
				 }*/
				 String topic="";
				 if (entitysearch.getTx()!= null&&entitysearch.getTx().equals("选择题")) {
					 if (entitysearch.getName() != null) {
						 topic=entitysearch.getName();
					}
					 exList.add(cb.like(root.get("options").get("topic").as(String.class), "%"+topic+"%"));
				}
				 if (entitysearch.getTx()!= null&&entitysearch.getTx().equals("判断题")) {
					 if (entitysearch.getName() != null) {
						 topic=entitysearch.getName();
					}
					 exList.add(cb.like(root.get("judges").get("topic").as(String.class), "%"+topic+"%"));
				}
				 if (entitysearch.getTx()!= null&&entitysearch.getTx().equals("填空题")) {
					 if( entitysearch.getName() != null && !"".equals(entitysearch.getName()) ){
						 exList.add(cb.like(root.get("fillblanks").get("topic").as(String.class), "%"+topic+"%"));
					 }
				}
				 if( entitysearch.getStartTime() != null ){
					 exList.add(cb.greaterThanOrEqualTo(root.<Date>get("createTime"), entitysearch.getStartTime()));//大于等于起始日期
				 }
				 if( entitysearch.getEndTime() != null ){ 
					 exList.add(cb.lessThanOrEqualTo(root.<Date>get("createTime"), entitysearch.getEndTime()));//小于等于截止日期
				 }
				 if( entitysearch.getIsLockout() != null ){ 
					 exList.add(cb.equal(root.<Integer>get("userIsLockout"), entitysearch.getIsLockout()));//小于等于截止日期
				 }
				 return predicate;
				 }
			 };
		 }
	
	/* (非 Javadoc) 
	 * <p>Title: deleteQuestion</p> 
	 * <p>Description: </p> 
	 * @param qid 
	 * @see com.lwj.springcloud.service.QuestionService#deleteQuestion(int) 
	*/
	
	@Override
	public void deleteQuestion(int qid) {
		// TODO Auto-generated method stub
		/**
		 * deleteQuestion(这里用一句话描述这个方法的作用)
		*/
		qRepository.deleteById(qid);
	}
	
	/* (非 Javadoc) 
	 * <p>Title: inserQuestion</p> 
	 * <p>Description: </p> 
	 * @param question
	 * @return 
	 * @see com.lwj.springcloud.service.QuestionService#inserQuestion(com.lwj.springcloud.entity.Question) 
	*/
	
	@Override
	public Question inserQuestion(Question question) {
		if (question.getTx().equals("选择题")) {
			question.setJudges(null);
			question.setFillblanks(null);
		}
		if (question.getTx().equals("判断题")) {
			question.setOptions(null);
			question.setFillblanks(null);
		}
		if (question.getTx().equals("填空题")) {
			question.setJudges(null);
			question.setOptions(null);
		}
		// TODO Auto-generated method stub
		return qRepository.save(question);
		/**
		 * inserQuestion(这里用一句话描述这个方法的作用)
		*/
		
	}
	
	/* (非 Javadoc) 
	 * <p>Title: updateQuestion</p> 
	 * <p>Description: </p> 
	 * @param question
	 * @return 
	 * @see com.lwj.springcloud.service.QuestionService#updateQuestion(com.lwj.springcloud.entity.Question) 
	*/
	
	@Override
	@Transactional
	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		if (question.getTx().equals("选择题")) {
			qRepository.updateOptions(question.getOptions().getOptionId(),question.getOptions().getAnswer(),question.getOptions().getOptionA(),question.getOptions().getOptionB(),question.getOptions().getOptionC(),question.getOptions().getOptionD(),question.getOptions().getScore(),question.getOptions().getTopic());
		}
		if (question.getTx().equals("判断题")) {
			qRepository.updateJudges(question.getJudges().getJudgeId(),question.getJudges().getAnswer(),question.getJudges().getScore(),question.getJudges().getTopic());
		}
		if (question.getTx().equals("填空题")) {
			qRepository.updateFillblanks(question.getFillblanks().getFillblankId(),question.getFillblanks().getAnswer(),question.getFillblanks().getScore(),question.getFillblanks().getTopic());
		}
		return qRepository.updateQuestion(question.getQId(),question.getSectionId());/*///qRepository.updateQuestion(question);
*/		/**
		 * updateQuestion(这里用一句话描述这个方法的作用)
		*/
		
	}
}
