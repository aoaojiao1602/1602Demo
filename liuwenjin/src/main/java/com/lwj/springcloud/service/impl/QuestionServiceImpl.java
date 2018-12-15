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
		Sort sort = new Sort(Sort.Direction.ASC,"qId");
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
				 
				 if( entitysearch.getName() != null && !"".equals(entitysearch.getName()) ){
					 exList.add(cb.like(root.get("optionId").get("topic").as(String.class), "%"+entitysearch.getName()+"%"));
				 }
				 if( entitysearch.getSex() != null && !"".equals(entitysearch.getSex()) ){
					 exList.add(cb.equal(root.get("sex").as(String.class), entitysearch.getSex()));
				 }               
				 if( entitysearch.getMinAge() != null ){
					 exList.add(cb.greaterThanOrEqualTo(root.<Integer>get("age"), entitysearch.getMinAge()));
				 }               
				 if( entitysearch.getMaxAge() != null ){
					 exList.add(cb.lessThanOrEqualTo(root.get("age").as(Integer.class), entitysearch.getMaxAge()));
				 }               
				 if( entitysearch.getStartTime() != null ){
					 exList.add(cb.greaterThanOrEqualTo(root.<Date>get("userCreateTime"), entitysearch.getStartTime()));//大于等于起始日期
				 }
				 if( entitysearch.getEndTime() != null ){ 
					 exList.add(cb.lessThanOrEqualTo(root.<Date>get("userCreateTime"), entitysearch.getEndTime()));//小于等于截止日期
				 }
				 if( entitysearch.getIsLockout() != null ){ 
					 exList.add(cb.equal(root.<Integer>get("userIsLockout"), entitysearch.getIsLockout()));//小于等于截止日期
				 }
				 return predicate;
				 }
			 };
		 }
}
