package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lwj.springcloud.entity.StudentTestInfo;

public interface StudentTestInfoRepository extends JpaRepository<StudentTestInfo, Integer>,JpaSpecificationExecutor<StudentTestInfo> {

}
