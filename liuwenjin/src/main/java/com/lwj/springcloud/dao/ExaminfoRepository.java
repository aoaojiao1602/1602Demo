package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lwj.springcloud.entity.Examinfo;

public interface ExaminfoRepository extends JpaRepository<Examinfo, Integer>,JpaSpecificationExecutor<Examinfo> {
	//修改考试
	
	
	//删除考试
	@Query("delete from Examinfo e where e.exId=?1")
	@Modifying
	int deleteExaminfo(Integer exId);
}
