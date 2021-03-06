package com.lhf.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lhf.entity.Courses;
import com.lhf.entity.CoursesSearch;
import com.lhf.entity.Hours;
import com.lhf.repository.CoursesRepository;
import com.lhf.repository.HoursRepository;
import com.lhf.service.CoursesService;
@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	private CoursesRepository cRepository;
	@Autowired
	private HoursRepository hRepository;
	@Override
	public int putCourses(Courses c) {
		return cRepository.putCourses(c);
	}

	@Override
	public int deleteCoursesById(Integer courseId) {
		return cRepository.deleteCoursesById(courseId);
	}

	@Override
	public int postCoursesById(Courses c) {
		return cRepository.postCoursesById(c);
	}

	/*@Override
	public Page<Courses> queryNameLikeAllPage(String nameLike, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "CourseId"); 
	    Pageable pageable = new PageRequest(page, size, sort);
		return cRepository.findByCourseNameLike("%"+nameLike+"%", pageable);
	}*/

	@Override
	public Page<Courses> queryByDynamicSQLPage(CoursesSearch c, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.DESC, "courseCreateTime");
		Pageable pageable = new PageRequest(page, size, sort);
		return cRepository.findAll(this.getWhereClause(c), pageable);
	}
	private Specification<Courses> getWhereClause(final CoursesSearch c) {
		return new Specification<Courses>() {
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public Predicate toPredicate(Root<Courses> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (c.getCourseName() != null && !"".equals(c.getCourseName())) {
					exList.add(cb.like(root.<String>get("courseName"), "%" + c.getCourseName() + "%"));
				}
				if (c.getCourseRemark() != null && !"".equals(c.getCourseRemark())) {
					exList.add(cb.equal(root.get("courseRemark").as(String.class), c.getCourseRemark()));
				}
				if (c.getCourseCategory() != null) {
					exList.add(cb.equal(root.get("courseCategory").as(Integer.class), c.getCourseCategory()));
				}
				if (c.getCourseCreator()!= null) {
					exList.add(cb.equal(root.get("courseCreator").as(Integer.class), c.getCourseCreator()));
				}
				if (c.getCourseState() != null && !"".equals(c.getCourseState())) {
					exList.add(cb.equal(root.get("courseState").as(String.class), c.getCourseState()));
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date parse1 = null,parse2=null;
				if (c.getStartCreateTime() != null&& !"".equals(c.getStartCreateTime())) {
					try {
						parse1 = dateFormat.parse(c.getStartCreateTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					exList.add(cb.greaterThanOrEqualTo(root.<Date>get("courseCreateTime"), parse1));// 大于等于起始日期
				}
				if (c.getEndCreateTime() != null&& !"".equals(c.getEndCreateTime())) {
					try {
						parse2 = dateFormat.parse(c.getEndCreateTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					exList.add(cb.lessThanOrEqualTo(root.get("courseCreateTime").as(Date.class), parse2));// 小于等于截止日期
				}
				return predicate;
			}

		};
	}

	@Override
	public List<Courses> getCoursesById(Integer courseCreator) {
		return cRepository.getCoursesById(courseCreator);
	}

	@Override
	public List<Hours> getHoursBycourseCreatorAndcourseId(Integer courseId) {
		return hRepository.getHoursBycourseCreatorAndcourseId(courseId);
	}

	
	/* (non-Javadoc)
	 * @see com.lhf.service.CoursesService#faBuCourse(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int faBuCourse(String courseState, Integer courseId) {
		return cRepository.faBuCourse(courseState, courseId);
	}
	
	/**
	 * 根据课程ID查询课程
	 * @param courseId
	 * @return
	 */
	public Courses findByCourseId(int courseId) {
		return cRepository.findByCourseId(courseId);
	}
	
	/**
	 * 根据课程类别查询课程
	 * @param courseCategory
	 * @return
	 */
	public List<Courses> findByCourseCategory(Integer courseCategory){
		return cRepository.findByCourseCategory(courseCategory);
	}

	@Override
	public List<Courses> queryByCourseId(List<Integer> courseId) {
		return cRepository.queryByCourseId(courseId);
	}

	
}
