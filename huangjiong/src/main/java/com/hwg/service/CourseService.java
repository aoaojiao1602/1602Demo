package com.hwg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping("courses/findByCourseCategory")
	public Object getCourseByCategoryId(@RequestParam("courseCategory")Integer cId);
	
	/**
	 * 根据课程id查询课程 信息
	 * @param id
	 * @param access_token
	 * @return
	 */
	@RequestMapping("courses/findByCourseId")
	public Object getCourseById(@RequestParam("courseId")Integer courseId);
	
	/**
	 * 	查询出所有章节（根据课程id）
	 * @return
	 */
	@RequestMapping("courses/queryhours")
	public Object getZhangjie(@RequestParam("courseId")String cid);
	
	/**
	 * 查询指定章节下课时
	 * @return
	 */
	@RequestMapping("hours/queryHoursByhourParentId")
	public Object getKeshi(@RequestParam("hourParentId")String zj);
}
