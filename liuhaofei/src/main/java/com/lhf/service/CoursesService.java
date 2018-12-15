package com.lhf.service;



import org.springframework.data.domain.Page;

import com.lhf.entity.Courses;

public interface CoursesService {
	public Page<Courses> queryNameLikeAllPage(String nameLike,Integer page,Integer size);//带条件的分页
	//添加课程
	public int putCourses(Courses c);
    //删除课程
	public int deleteCoursesById(Integer CourseId);
	//修改课程
	public int postCoursesById(Courses c);
}
