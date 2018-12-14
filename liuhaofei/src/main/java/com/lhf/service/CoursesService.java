package com.lhf.service;

import com.lhf.entity.Courses;

public interface CoursesService {
	//添加课程
	public int putCourses(Courses c);
    //删除课程
	public int deleteCoursesById(Integer Course_id);
	//修改课程
	public int postCoursesById(Courses c);
}
