package com.lhf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lhf.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
	// 添加课程
	@Query(value = "insert into courses(course_category,course_create_time,course_creator,course_editor_time,course_name,course_remark,course_state)values"
			+ "(:#{#c.Course_category},now(),:#{#c.Course_creator},:#{#c.Course_editor_time},:#{#c.Course_name},:#{#c.Course_remark},:#{#c.Course_state})", nativeQuery = true)
	@Modifying
	@Transactional
	public int putCourses(@Param("c") Courses c);

	// 删除课程
	@Query(value = "DELETE FROM courses WHERE course_id =?1", nativeQuery = true)
	@Modifying
	@Transactional
	public int deleteCoursesById(Integer Course_id);
	//修改课程
	@Query(value="UPDATE courses SET course_category = #{#c.Course_category},course_editor_time =now() , course_name = #{#c.Course_name} , course_remark =#{#c.Course_remark} WHERE course_id = #{#c.Course_id}", nativeQuery = true)
	@Modifying
	@Transactional
	public int postCoursesById(@Param("c") Courses c);
}
