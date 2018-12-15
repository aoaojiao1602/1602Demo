package com.lwj.springcloud.service;

import com.lwj.springcloud.entity.TestInfo;

public interface TestInfoService {
	//添加测试表信息
	public TestInfo insertTestInfo(TestInfo t);
	//修改测试表信息
	public int updateTestInfo(TestInfo t);
	//删除测试表信息
	public int deleteTestInfo(Integer testId);
}
