package com.hwg.service;

import java.util.List;

import com.hwg.entity.Coursecomment;

/**
 * @Description 课程评论接口
 * @author HJiong
 * @time 2018年12月31日 下午12:21:30
 */
public interface CoursecommentService {
	
	/**
	 *根据条件查询课程评论
	 */
	public List<Coursecomment> getCommentByWhere(String ksTime,String jsTime);
	
}
