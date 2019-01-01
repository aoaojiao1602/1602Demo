package com.hwg.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description 课程接口(通过fegin调用课程管理项目接口)
 * @author gz
 */
@FeignClient("liuhaofei")
public interface CourseService {
	/**
	 * 根据类别id查询课程
	 * @return
	 */
	public Object getCourseByCategoryId(Integer cId,String access_token);

}
