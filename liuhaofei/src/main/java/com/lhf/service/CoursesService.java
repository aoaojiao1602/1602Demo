package com.lhf.service;



import java.util.List;

import org.springframework.data.domain.Page;

import com.lhf.entity.Courses;
import com.lhf.entity.CoursesSearch;
import com.lhf.entity.Hours;

public interface CoursesService {
	/*public Page<Courses> queryNameLikeAllPage(String nameLike,Integer page,Integer size);//带条件的分页
*/	//添加课程
	public int putCourses(Courses c);
    //删除课程
	public int deleteCoursesById(Integer courseId);
	//修改课程
	public int postCoursesById(Courses c);
	//分页查询课程
	public Page<Courses> queryByDynamicSQLPage(CoursesSearch CSearch,Integer page,Integer size);
    //根据ID查老师课程
	public List<Courses> getCoursesById(Integer courseCreator);
	//根据老师Id、课程Id查询章节
	public List<Hours> getHoursBycourseCreatorAndcourseId(Integer courseId);
}
