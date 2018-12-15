/**
 * 
 */ 
package com.lwj.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.service.ExaminfoService;
import com.lwj.springcloud.service.QuestionService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 项目名称：liuwenjin
 * 类名称：QuestionController
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年12月14日 下午11:37:46
 * 修改人：rain
 * 修改时间：2018年12月14日 下午11:37:46
 * 修改备注：
 * @version
 *
*/
@RestController
public class QuestionController {
	@Autowired
	private QuestionService qService;
	@ApiOperation(value="获取题库表", notes="模糊分页获取题库表集合")
	@ApiImplicitParam(name = "search", value = "搜索实体类", required = true, dataType = "Entitysearch")
	@RequestMapping(value="/question", method = RequestMethod.GET)
	public Object indexQuestionPage(Entitysearch search) {
		Page<Question> list=qService.indexQuestionPage(search);
		return list;
	}
}
