package com.hwg.service;

import java.util.List;
import java.util.Map;

import com.hwg.entity.Learnrecord;

/**
 * @Description 学习记录实体
 * @author gz
 * 
 */
public interface LearnrecordService {
	
	/**
	 * 	 查询出学习记录 根据学生id and 课程编号及章节
	 * @return
	 */
	public Object querylearnrecord(String kcId,String xsId);
	
	/**
	 * 根据学生id 及课程id、课程章节 查询出学习记录
	 * @return
	 */
	public Learnrecord getOneLearnrecord(String kcId,String xsId,String zj);
	
	/**
	   *   查询指定时间段的课程学习记录 
	 * @return
	 */
	public List<Map<String, Object>> getLearnrecordByUpdateTime();
	
	
	/**
	 * 查询出当前学生报名课程
	 * @return
	 */
	public List<Learnrecord> getLearnrecordByStuId(String stuId);
}
