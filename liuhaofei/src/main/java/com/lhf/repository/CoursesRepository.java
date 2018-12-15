package com.lhf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lhf.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer>,JpaSpecificationExecutor<Courses> {
	public Page<Courses> findByCourseNameLike(String name,Pageable pageable);
	// 添加课程
	@Query(value = "insert into courses(course_category,course_create_time,course_creator,course_editor_time,course_name,course_remark,course_state)values"
			+ "(:#{#c.CourseCategory},now(),:#{#c.CourseCreator},:#{#c.CourseEditorTime},:#{#c.CourseName},:#{#c.CourseRemark},:#{#c.CourseState})", nativeQuery = true)
	@Modifying
	@Transactional
	public int putCourses(@Param("c") Courses c);

	// 删除课程
	@Query(value = "DELETE FROM courses WHERE course_id =?1", nativeQuery = true)
	@Modifying
	@Transactional
	public int deleteCoursesById(Integer CourseId);
	//修改课程
	@Query(value="UPDATE courses SET course_category = #{#c.CourseCategory},course_editor_time =now() , course_name = #{#c.CourseName} , course_remark =#{#c.CourseRemark} WHERE course_id = #{#c.courseId}", nativeQuery = true)
	@Modifying
	@Transactional
	public int postCoursesById(@Param("c") Courses c);
}
