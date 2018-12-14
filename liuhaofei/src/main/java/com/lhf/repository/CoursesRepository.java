package com.lhf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lhf.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer>{
	@Query(value="insert into courses(course_category,course_name,course_creator,course_remark)values(?1,?2,?3,?4)",nativeQuery = true)
	 @Modifying
     @Transactional
	public int putCourses(String Course_category,String course_name,String course_creator,String course_remark);

}
