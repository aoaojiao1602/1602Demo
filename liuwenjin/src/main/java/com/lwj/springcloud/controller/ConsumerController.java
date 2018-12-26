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
	@RequestMapping(value="queryCourses",method=RequestMethod.GET)
	public Object queryCourses(int tid) {
		return consumerService.queryCourses(tid);
	}
}
