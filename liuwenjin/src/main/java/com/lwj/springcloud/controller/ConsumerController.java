/**
 * 
 */ 
package com.lwj.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.springcloud.service.ConsumerService;

/**
 * 项目名称：liuwenjin
 * 类名称：ConsumerController
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年12月26日 下午9:55:34
 * 修改人：rain
 * 修改时间：2018年12月26日 下午9:55:34
 * 修改备注：
 * @version
 *
*/
@RestController
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;
	/**
	 *  当前老师的所有课程
	 * http://localhost:8080/queryCourses
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月27日 下午5:54:37  
	  * 版本: V1.0
	 */
	@RequestMapping(value="queryCourses",method=RequestMethod.GET)
	public Object queryCourses(int tid) {
		return consumerService.queryCourses(tid);
	}
	/**
	 * 当前老师的课程的所有
	 * http://localhost:8080/queryCourses
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月27日 下午5:55:01  
	  * 版本: V1.0
	 */
	@RequestMapping(value="querySection",method=RequestMethod.GET)
	public Object querySection(int courseId) {
		return consumerService.querySection(courseId);
	}
}
