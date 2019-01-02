package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.ysd.boot.entity.Course;


public interface CourseService {

	/***
	 * 添加课程推荐
	 * @param course
	 * @return
	 */
	public int addCourse(Integer kechId,Integer navigationId,String courseRemark);
	
	/**
	 * 通过id进行删除课程推荐
	 * @param courseId
	 * @return
	 */
	public int deleteCourse(Integer courseId);
	
	/**
	 * 通过id进行修改课程推荐
	 * @param course
	 * @return
	 */
	public int updateCourse(Course course);
	/**
	 	* 分页查询课程推荐
	 	* @param name
	 	* @param pageable
	 	* @return
	 	*/
	public Page<Course> queryCourseByPage(Integer page,Integer rows,Integer id);
	
	/***
	 * 得到全部的课程推荐
	 * @return
	 */
	public List<Course> getAllCourseList();
	
	/**
	 * 通过位置id得到课程推荐
	 * @param positionId
	 * @return
	 */
	public List<Course> getCourseByPositionId(Integer positionId);
	
	
	
	}
