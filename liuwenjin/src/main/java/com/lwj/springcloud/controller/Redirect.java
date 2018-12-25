/**
 * 
 */ 
package com.lwj.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
public class Redirect {
	@RequestMapping(value = "/a") 
	public String getxxxList(){
		return "index.html"; 
	}
	
}
