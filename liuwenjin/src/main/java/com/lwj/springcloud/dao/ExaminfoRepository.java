package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.Examinfo;

public interface ExaminfoRepository extends JpaRepository<Examinfo, Integer>,JpaSpecificationExecutor<Examinfo> {
	//修改考试
	@Query("update Examinfo set startTime=:#{#e.startTime},endTime=:#{#e.endTime},paperName=:#{#e.paperName},cxTime=:#{#e.cxTime},optionNum=:#{#e.optionNum},judgeNum=:#{#e.judgeNum},fillblankNum=:#{#e.fillblankNum},examScore=:#{#e.examScore} where exId=:#{#e.exId}")
	@Modifying
	int updateQuestion(@Param("e")Examinfo examinfo);
	//删除考试
	@Query("delete from Examinfo e where e.exId=?1")
	@Modifying
	int deleteExaminfo(Integer exId);
}
