package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.TestInfo;

public interface TestInfoRepository extends JpaRepository<TestInfo, Integer>,JpaSpecificationExecutor<TestInfo> {
	//修改测试表信息
	@Query("update TestInfo set spareTime=:#{#t.spareTime},testName=:#{#t.testName},testNum=:#{#t.testNum},optionNum=:#{#t.optionNum},testScore=:#{#t.testScore} where testId=:#{#t.testId}")
	@Modifying
	int updateTestInfo(@Param("t")TestInfo t);
	//删除测试表信息
	/*@Query("")
	@Modifying
	int deleteTestInfo(Integer testId);*/
}
