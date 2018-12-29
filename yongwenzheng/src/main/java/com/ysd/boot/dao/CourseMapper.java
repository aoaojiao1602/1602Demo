package com.ysd.boot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Course;


public interface CourseMapper extends JpaRepository<Course, Integer>,JpaSpecificationExecutor<Course>{
	
	
	/***
	 * 添加课程推荐
	 * @param course
	 * @return
	 */
	@Modifying
	@Query(value = "INSERT  coursetb(kech_id,navigation_id) VALUES(?1,?2)", nativeQuery = true)
	public int addCourse(@Param("kechId")Integer kechId,@Param("navigationId")Integer navigationId);
	
	/**
	 * 通过id进行删除课程推荐
	 * @param courseId
	 * @return
	 */
	@Modifying
	@Query(value = "DELETE FROM coursetb WHERE course_id = ?1 " , nativeQuery = true)
	public int deleteCourse(@Param("courseId")Integer courseId);
	
	/**
	 * 通过id进行修改课程推荐
	 * @param course
	 * @return
	 */
    @Modifying
	@Query(value = "UPDATE coursetb SET course_status = :#{#course.courseStatus}, course_weigh = :#{#course.courseWeigh}, positions_id = :#{#course.positionsId} WHERE course_id = :#{#course.courseId}", nativeQuery = true)
	public int updateCourse(@Param("course")Course course);
	
	/***
	  * 通过位置id进行分页查询
	 * @param position
	 * @param pageable
	 * @return
	 */    
	public Page<Course> findByPositionsId(Integer positionId,Pageable pageable);
	
	
	/**
	 * 通过位置id得到课程推荐
	 * @param positionId
	 * @return
	 */
	@Query(value = "SELECT * FROM coursetb WHERE positions_id = ?1 " , nativeQuery = true)
	public List<Course> getCourseByPositionId(@Param("positionId")Integer positionId);
	
}
