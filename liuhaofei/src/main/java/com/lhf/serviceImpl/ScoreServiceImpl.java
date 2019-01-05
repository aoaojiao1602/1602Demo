package com.lhf.serviceImpl;




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


import com.lhf.entity.Score;
import com.lhf.entity.ScoreSearch;
import com.lhf.repository.ScoreRepository;
import com.lhf.service.ScoreService;
@Service
public class ScoreServiceImpl implements ScoreService {
@Autowired
private ScoreRepository sRepository;
	@Override
	public int putCourses(Score s) {
		return sRepository.putScore(s);
	}
	@Override
	public int deleteScoreById(Integer scoreId) {
		return sRepository.deleteScoreById(scoreId);
	}
	@Override
	public int postScoreById(Score s) {
		return sRepository.postScoreById(s);
	}
	@Override
	public Page<Score> queryByDynamicSQLPage(ScoreSearch s, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "scoreId");
		Pageable pageable = new PageRequest(page, size, sort);
		return sRepository.findAll(this.getWhereClause(s), pageable);
	}
	private Specification<Score> getWhereClause(final ScoreSearch s) {
		return new Specification<Score>() {
			@Override
			public Predicate toPredicate(Root<Score> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
			if (s.getCourseName() != null && !"".equals(s.getCourseName())) {
					exList.add(cb.like(root.<String>get("courseName"), "%" + s.getCourseName() + "%"));
				}
				return predicate;
			}
		};
	}
	@Override
	public List<Score> getScoreBycourseId(Integer courseId) {
		return sRepository.getScoreBycourseId(courseId);
	}
}
