package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.StudentExamInfo;

public interface StudentExamInfoRepository extends JpaRepository<StudentExamInfo, Integer>,JpaSpecificationExecutor<StudentExamInfo> {
	//修改学生考试信息
	@Query("update StudentExamInfo set examinfo=:#{#s.examinfo},examScore=:#{#s.examScore},time=:#{#s.time} where id=:#{#s.id}")
	@Modifying
	int updateStudentExamInfo(@Param("s")StudentExamInfo stu);
	//删除学生考试信息
	@Query("delete from StudentExamInfo s where s.id=?1")
	public int deleteStudentExamInfo(Integer id);
	
}
