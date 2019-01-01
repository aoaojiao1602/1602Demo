package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.CourseMapper;
import com.ysd.boot.entity.Course;
import com.ysd.boot.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;
	
	/***
	 * 添加课程推荐
	 * @param course
	 * @return
	 */
	@Transactional
	public int addCourse(Integer kechId,Integer navigationId,String courseRemark) {
		
		return courseMapper.addCourse(kechId, navigationId,courseRemark);
		
	}
	
	/**
	 * 通过id进行删除课程推荐
	 * @param courseId
	 * @return
	 */
	@Transactional
	public int deleteCourse(Integer courseId) {
		
		return courseMapper.deleteCourse(courseId);
	}
	
	/**
	 * 通过id进行修改课程推荐
	 * @param course
	 * @return
	 */
	@Transactional
	public int updateCourse(Course course) {
		
		return courseMapper.updateCourse(course);
	}
	
	/**
 	* 分页查询班级
 	* @param name
 	* @param pageable
 	* @return
 	*/
	public Page<Course> queryCourseByPage(Integer page,Integer rows,Integer id){
		 Pageable pageable = new PageRequest(page-1, rows);
		 
		 return courseMapper.findByPositionsId(id, pageable);
	
	}
	
	/***
	 * 得到全部的课程推荐
	 * @return
	 */
	public List<Course> getAllCourseList(){
		
		return courseMapper.findAll();
		
	}
	
	/**
	 * 通过位置id得到课程推荐
	 * @param positionId
	 * @return
	 */
	@Transactional
	public List<Course> getCourseByPositionId(Integer positionId){
		
		return courseMapper.getCourseByPositionId(positionId);
	}

}
