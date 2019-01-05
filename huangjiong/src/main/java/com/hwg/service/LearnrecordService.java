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
	   *   查询指定时间段的课程学习记录 
	 * @return
	 */
	public List<Map<String, Object>> getLearnrecordByUpdateTime();
	
	
	/**
	 * 查询出当前学生报名课程
	 * @return
	 */
	public List<Learnrecord> getLearnrecordByStuId(String stuId);
	
	/**
	 * 查询指定课程的学习记录
	 * @param cid
	 * @return
	 */
	public Map<String, Object> getLearnrecordByCourseId(String cid);
	
}
