package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.ysd.boot.entity.Discusscourse;

public interface DiscusscourseService {

	/***
	 * 添加精彩讨论推荐
	 * @param course
	 * @return
	 */
	public int addDiscusscourse(Integer kechId,Integer teacherId);
	
	/**
	 * 通过id进行删除精彩讨论推荐
	 * @param courseId
	 * @return
	 */
	public int deleteDiscusscourse(Integer discusscourseId);
	
	/**
	 * 通过id进行修改精彩讨论推荐
	 * @param course
	 * @return
	 */
 
	public int updateDiscusscourse(Discusscourse discusscourse);
	
	/***
	  * 通过位置id进行分页查询
	 * @param position
	 * @param pageable
	 * @return
	 */    
	public Page<Discusscourse> queryDiscusscourseByPage(Integer page,Integer rows,Integer id);
	
	
	/**
	 * 通过位置id得到精彩讨论推荐
	 * @param positionId
	 * @return
	 */
	public List<Discusscourse> getDiscusscourseByPositionId(Integer positionId);
	
	
	/****
	 * 得到全部精彩讨论推荐
	 * @return
	 */
	public List<Discusscourse> getAllDiscusscourseList();
}
