package com.lhf.service;

import org.springframework.data.domain.Page;

import com.lhf.entity.Courses;

public interface CoursesService {
	/*public Page<Courses> queryNameLikeAllPage(String nameLike,Integer page,Integer size);*/
	//添加课程
	public int putCourses(Courses c);
    //删除课程
	public int deleteCoursesById(Integer Course_id);
	//修改课程
	public int postCoursesById(Courses c);
	
	public Page<Courses> queryByDynamicSQLPage(Courses courses,Integer page,Integer size);
}
