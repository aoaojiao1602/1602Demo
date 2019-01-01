package com.hwg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwg.entity.Coursecomment;

/**
 * @Description 课程评论 Dao层
 * @author HJiong
 * @time 2018年12月14日 下午1:52:27
 */
public interface CourseCommentDao extends JpaRepository<Coursecomment, Integer>{
	
	/**
	 *根据条件查询课程评论
	 */
	public List<Coursecomment> findByCommentTimeBetween(String ksTime,String jsTime);

}
