package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.DiscusscourseMapper;
import com.ysd.boot.entity.Discusscourse;
import com.ysd.boot.service.DiscusscourseService;

@Service
public class DiscusscourseServiceImpl implements DiscusscourseService{

	@Autowired
	private DiscusscourseMapper discusscourseMapper;
	
	/***
	 * 添加精彩讨论推荐
	 * @param course
	 * @return
	 */
	@Transactional
	public int addDiscusscourse(Integer kechId,Integer teacherId) {
		
		return discusscourseMapper.addDiscusscourse(kechId, teacherId);
	}
	
	/**
	 * 通过id进行删除精彩讨论推荐
	 * @param courseId
	 * @return
	 */
	@Transactional
	public int deleteDiscusscourse(Integer discusscourseId) {
		
		return discusscourseMapper.deleteDiscusscourse(discusscourseId);
	}
	
	/**
	 * 通过id进行修改精彩讨论推荐
	 * @param course
	 * @return
	 */
	@Transactional
	public int updateDiscusscourse(Discusscourse discusscourse) {
		
		return discusscourseMapper.updateDiscusscourse(discusscourse);
	}
	
	/***
	  * 通过位置id进行分页查询
	 * @param position
	 * @param pageable
	 * @return
	 */    
	public Page<Discusscourse> queryDiscusscourseByPage(Integer page, Integer rows, Integer id) {
		Pageable pageable = new PageRequest(page-1, rows);
		 
		 return discusscourseMapper.findByPositionsId(id, pageable);
	}
	
	
	/**
	 * 通过位置id得到精彩讨论推荐
	 * @param positionId
	 * @return
	 */
	@Transactional
	public List<Discusscourse> getDiscusscourseByPositionId(Integer positionId){
		
		return discusscourseMapper.getDiscusscourseByPositionId(positionId);
	}
	
	
	/****
	 * 得到全部精彩讨论推荐
	 * @return
	 */
	
	public List<Discusscourse> getAllDiscusscourseList(){
		
		return discusscourseMapper.findAll();
	}


	
}
