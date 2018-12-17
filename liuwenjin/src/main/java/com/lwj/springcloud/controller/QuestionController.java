/**
 * 
 */ 
package com.lwj.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total",list.getTotalElements());
		map.put("rows",list.getContent());
		return map;
	}
	@ApiOperation(value="添加题库表", notes="添加题库")
	@ApiImplicitParam(name = "question", value = "题库实体类", required = true, dataType = "Question")
	@RequestMapping(value="/question", method = RequestMethod.POST)
	public Object inserQuestion(Question question) {
		System.out.println(question);
		return 0;
	}
	@ApiOperation(value="删除题库表", notes="删除题库")
	@ApiImplicitParam(name = "qid", value = "题库id", required = true, dataType = "Intger")
	@RequestMapping(value="/question", method = RequestMethod.DELETE)
	public Object deleteQuestion(int qid) {
		System.out.println(qid);
		try {
			qService.deleteQuestion(qid);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
