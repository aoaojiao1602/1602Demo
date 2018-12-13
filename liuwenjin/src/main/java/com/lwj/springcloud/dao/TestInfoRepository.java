package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lwj.springcloud.entity.TestInfo;

public interface TestInfoRepository extends JpaRepository<TestInfo, Integer>,JpaSpecificationExecutor<TestInfo> {

}
