package com.lwj.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.service.ExaminfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class ExaminfoController {
	@Autowired
	private ExaminfoService eService;
	
	
	@ApiOperation(value="获取考试表", notes="分页获取考试表集合")
	@ApiImplicitParam(name = "search", value = "搜索实体类", required = true,paramType="Entitysearch")
	@RequestMapping(value="/examinfo", method = RequestMethod.GET)
	public Object indexExaminfoPage(Entitysearch search) {
		Page<Examinfo> list=eService.indexExaminfoPage(search);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total",list.getTotalElements());
		map.put("rows",list.getContent());
		return map;
	}
	/**
	 * 添加考试
	 * @param examinfo
	 * @return
	 */
	@ApiOperation(value="添加考试表", notes="添加考试")
	@ApiImplicitParam(name = "examinfo", value = "考试实体类", required = true, dataType = "Examinfo")
	@RequestMapping(value="/examinfo", method = RequestMethod.POST)
	public Object insertExaminfo(@RequestBody Examinfo examinfo) {
		return eService.insertExaminfo(examinfo);
	}
	/**
	 * 删除考试
	 * @param exId
	 * @return
	 */
	@ApiOperation(value="删除考试表", notes="删除考试")
	@ApiImplicitParam(name = "exId", value = "考试id", required = true,paramType="Intger")
	@RequestMapping(value="/examinfo", method = RequestMethod.DELETE)
	public int deleteExaminfo(int exId) {		
		return eService.deleteExaminfo(exId);
	}
	@ApiOperation(value="添加考试表", notes="添加考试")
	@ApiImplicitParam(name = "examinfo", value = "考试实体类", required = true, dataType = "Examinfo")
	@RequestMapping(value="/examinfo", method = RequestMethod.PUT)
	public Object updateExaminfo(@RequestBody Examinfo examinfo) {
		return eService.updateExaminfo(examinfo);
	}
	@ApiOperation(value="查询题型数量", notes="查询题型数量")
	@RequestMapping(value="/queryQuestionTypeCount", method = RequestMethod.GET)
	public Object queryQuestionTypeCount() {
		return eService.queryQuestionTypeCount();
	}
	@ApiOperation(value="查询该课程有没有考试", notes="查询考试")
	@ApiImplicitParam(name = "cid", value = "考试id", required = true,paramType="Intger")
	@RequestMapping(value="/queryCoursesByid", method = RequestMethod.GET)
	public Object queryCoursesByid(int cid) {
		List<Examinfo> examinfos=eService.queryCoursesByid(cid);
		System.err.println(examinfos);
		return examinfos.size();
	}
}
