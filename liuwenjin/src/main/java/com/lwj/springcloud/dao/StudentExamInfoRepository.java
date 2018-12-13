package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lwj.springcloud.entity.StudentExamInfo;

public interface StudentExamInfoRepository extends JpaRepository<StudentExamInfo, Integer>,JpaSpecificationExecutor<StudentExamInfo> {

}
