package com.lhf.serviceImpl;

import java.util.List;

import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lhf.entity.Courses;
import com.lhf.repository.CoursesRepository;
import com.lhf.service.CoursesService;
@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	private CoursesRepository cRepository;

	@Override
	public int putCourses(Courses c) {
		return cRepository.putCourses(c);
	}

	@Override
	public int deleteCoursesById(Integer Course_id) {
		return cRepository.deleteCoursesById(Course_id);
	}

	@Override
	public int postCoursesById(Courses c) {
		return cRepository.postCoursesById(c);
	}

	@Override
	public Page<Courses> queryByDynamicSQLPage(Courses courses, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "Course_id");
		Pageable pageable = new PageRequest(page, size, sort);
		return cRepository.findAll(this.getWhereClause(courses), pageable);
	}

	private Specification<Courses> getWhereClause(final Courses courses) {
		return new Specification<Courses>() {
			@Override
			public Predicate toPredicate(Root<Courses> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合

				if (courses.getCourse_name() != null && !"".equals(courses.getCourse_name())) {
					exList.add(cb.like(root.<String>get("Course_name"), "%" + courses.getCourse_name() + "%"));
				}

				return predicate;
			}

		};
	}

	/*@Override*/
	/*public Page<Courses> queryNameLikeAllPage(String nameLike, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "Course_id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
		return cRepository.findByCourse_NameLike("%"+nameLike+"%", pageable);
	}*/

}
