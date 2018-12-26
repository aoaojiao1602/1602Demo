/**
 * 
 */ 
package com.lwj.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lwj.springcloud.service.ConsumerService;


/**
 * 项目名称：liuwenjin
 * 类名称：redirect
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年12月19日 下午4:05:24
 * 修改人：rain
 * 修改时间：2018年12月19日 下午4:05:24
 * 修改备注：
 * @version
 *
*/
@RestController
public class Redirect {
	@Autowired
	private ConsumerService consumerService;
	@RequestMapping(value = "/a") 
	public Object getxxxList(){
		return consumerService.getProviderFuture();
	}
	
}
