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

import com.lhf.entity.Courseware;
import com.lhf.entity.CoursewareSearch;
import com.lhf.repository.CoursewareRepository;
import com.lhf.service.CoursewareService;
@Service
public class CoursewareServiceImpl implements CoursewareService {

	@Autowired
	private CoursewareRepository cwRepository;
	
	
	//给章节添加课时
	@Override
	public int putCourseware(Courseware cw) {
		// TODO Auto-generated method stub
		return cwRepository.putCourseware(cw);
	}

	//给章节删除课时
	@Override
	public int deleteCoursewareById(Integer cwId) {
		// TODO Auto-generated method stub
		return cwRepository.deleteCoursewareById(cwId);
	}

	//给章节修改课时
	@Override
	public int postCoursewareById(Courseware cw){
		return cwRepository.postCoursewareById(cw);
	}

	

	//章节查询
	@Override
	public Page<Courseware> queryByDynamicwSQLPage(CoursewareSearch CwSearch, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "cwId");
		Pageable pageable = new PageRequest(page, size, sort);
		return cwRepository.findAll(this.getWhereClause(CwSearch), pageable);
	}
	
	
	
	private Specification<Courseware> getWhereClause(final CoursewareSearch cwSearch) {
		return new Specification<Courseware>() {
			@Override
			public Predicate toPredicate(Root<Courseware> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (cwSearch.getCwHour() != null && !"".equals(cwSearch.getCwHour())) {
					exList.add(cb.like(root.<String>get("cwHour").as(String.class), cwSearch.getCwHour()));
				}
				if (cwSearch.getCwCategory() != null && !"".equals(cwSearch.getCwCategory())) {
					exList.add(cb.equal(root.get("cwCategory").as(String.class), cwSearch.getCwCategory()));
				}
				if (cwSearch.getCwName() != null && !"".equals(cwSearch.getCwName())) {
					exList.add(cb.equal(root.get("cwName"), "%" + cwSearch.getCwName() + "%"));
				}
				if (cwSearch.getCwUrl() != null && !"".equals(cwSearch.getCwUrl())) {
					exList.add(cb.equal(root.get("cwUrl").as(String.class), cwSearch.getCwUrl()));
				}
				return predicate;
			}

		};
	}

	
}
