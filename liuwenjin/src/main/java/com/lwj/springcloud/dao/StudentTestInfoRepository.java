package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.StudentTestInfo;
import com.lwj.springcloud.entity.TestInfo;

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
	
	@Query(value="SELECT * FROM student_testinfotb WHERE student_id =?1 AND testinfo_id=?2",nativeQuery=true)
	StudentTestInfo indexStudentTestInfo(int stuid, int testid);
	
	@Query("SELECT t FROM TestInfo t WHERE t.testId=?1")
	TestInfo queryTestInfo(int testId);
	
	@Query(value="UPDATE student_testinfotb SET test_score=?3,test_num=?4 WHERE student_id =?1 AND testinfo_id=?2",nativeQuery=true)
	@Modifying
	int updateStudentTestInfoScore(int stuid, int testid, int score,int num);
	
	@Query(value="SELECT * FROM student_testinfotb WHERE testinfo_id = ?1",nativeQuery=true)
	StudentTestInfo queryStudentTestInfo(int testId);
}
