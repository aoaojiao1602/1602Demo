package com.lhf.service;




import org.springframework.data.domain.Page;


import com.lhf.entity.Courseware;
import com.lhf.entity.CoursewareSearch;

public interface CoursewareService {

	//给章节添加课时
	public int putCourseware(Courseware cw);
	
	//删除章节
	public int deleteCoursewareById(Integer cwId);
	
	//修改章节
	public int postCoursewareById(Courseware cw);
	
	//章节查询带条件的分页
	public Page<Courseware> queryByDynamicwSQLPage(CoursewareSearch CwSearch,Integer page,Integer size);


	

}
