package com.lwj.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.TestInfo;
import com.lwj.springcloud.service.TestInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class TestInfoController {
	@Autowired
	private TestInfoService tService;
	
	/**
	 * 查询测试表信息
	 * @param search
	 * @return
	 */
	@ApiOperation(value="获取测试表", notes="分页获取测试表集合")
	@ApiImplicitParam(name = "search", value = "搜索实体类", required = true,paramType="Entitysearch")
	@RequestMapping(value="/testInfo", method = RequestMethod.GET)
	public Object indexTestInfoPage(Entitysearch search) {
		Page<TestInfo> list=tService.indexTestInfoPage(search);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total",list.getTotalElements());
		map.put("rows",list.getContent());
		return map;
	}
	/**
	 * 添加测试
	 * @param testInfo
	 * @return
	 */
	@ApiOperation(value="添加测试表", notes="添加测试")
	@ApiImplicitParam(name = "testInfo", value = "测试实体类", required = true, dataType = "TestInfo")
	@RequestMapping(value="/testInfo", method = RequestMethod.POST)
	public Object insertTestInfo(@RequestBody TestInfo testInfo) {
		return tService.insertTestInfo(testInfo);
	}
	/**
	 * 修改测试表
	 * @param testInfo
	 * @return
	 */
	@ApiOperation(value="修改测试表", notes="修改测试")
	@ApiImplicitParam(name = "testInfo", value = "测试实体类", required = true, dataType = "TestInfo")
	@RequestMapping(value="/testInfo", method = RequestMethod.PUT)
	public Object updateTestInfo(@RequestBody TestInfo testInfo) {
		return tService.updateTestInfo(testInfo);
	}
	/**
	 * 删除测试表
	 * @param testId
	 * @return
	 * 
	 */
	@ApiOperation(value="删除测试表", notes="删除测试")
	@ApiImplicitParam(name = "testId", value = "测试id", required = true,paramType="Intger")
	@RequestMapping(value="/testInfo", method = RequestMethod.DELETE)
	public Object deleteTestInfo(int testId) {
		return tService.deleteTestInfo(testId);		
	}
}
