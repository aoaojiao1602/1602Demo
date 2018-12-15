package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.StudentTestInfo;

public interface StudentTestInfoRepository
		extends JpaRepository<StudentTestInfo, Integer>, JpaSpecificationExecutor<StudentTestInfo> {

	// 修改学生测试信息
	@Query("update StudentTestInfo set testInfo=:#{#s.testInfo},testNum=:#{#s.testNum},spareTime=:#{#s.spareTime} where id=:#{#s.id}")
	@Modifying
	public int updateStudentTestInfo(@Param("s")StudentTestInfo stu);

	// 删除学生测试信息
	@Query("delete from StudentTestInfo s where s.id=?1")
	@Modifying
	public int deleteStudentTestInfo(Integer id);
}
