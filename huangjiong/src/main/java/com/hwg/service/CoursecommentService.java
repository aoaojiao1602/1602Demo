package com.hwg.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

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
	
	/**
	 * 多条件分页查询
	 * 
	 * @param comment
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Map<String, Object>> getCourseComment(Integer cid);

	/**
	 * 根据课程编号查询课程评论的总条数
	 * 
	 * @param comment
	 * @return
	 */
	public int countCourseComment(Coursecomment comment);

	/**
	 * 根据课程编号查询课程评价的平均星级
	 * 
	 * @param comment
	 * @return
	 */
	public double getCommentStar(Coursecomment comment);

	/**
	 * 添加课程评论
	 * 
	 * @param comment
	 * @return
	 */
	public Coursecomment createComment(Coursecomment comment);

	/**
	 * 给评论点赞
	 * @param comment
	 * @return
	 */
	public int updateCommentliked(Coursecomment comment);
	
}
