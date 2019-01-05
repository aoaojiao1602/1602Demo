package com.ysd.boot.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="huangjiong")
public interface HJCourseService {

	
	/**
	   *   查询指定时间段的课程学习记录 
	   *   最近七天
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/learnrecord/byTime")
	public List<Map<String, Object>> getLearnrecordByUpdateTime();
		
}
