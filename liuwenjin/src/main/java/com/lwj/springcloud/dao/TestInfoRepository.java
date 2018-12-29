package com.lwj.springcloud.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.entity.TestInfo;

public interface TestInfoRepository extends JpaRepository<TestInfo, Integer>, JpaSpecificationExecutor<TestInfo> {
	// 带分页模糊查询
	Page<TestInfo> findByTestNameLike(String testName, Pageable pageable);

	// 修改测试表信息
	@Query("update TestInfo set spareTime=:#{#t.spareTime},testName=:#{#t.testName},testNum=:#{#t.testNum},optionNum=:#{#t.optionNum},testScore=:#{#t.testScore} where testId=:#{#t.testId}")
	@Modifying
	int updateTestInfo(@Param("t") TestInfo t);

	// 删除测试表信息
	@Query("delete from TestInfo t where t.testId=?1")
	@Modifying
	int deleteTestInfo(Integer testId);
	
	@Query("select q.qId from Question q,Options o where q.options=o.question AND q.sectionId=?1")
	List<Integer> queryOptions(int sectionId);
	
	
	@Query(" from Question q where q.qId=?1 ")
	Question queryQuestion(Integer integer);
//	@Query(value="INSERT INTO student_exam_questiontb(student_id,exam_id,questiontb_id) VALUES (?1,?2,?3)",nativeQuery=true)
//	@Modifying
//	int inserStudentQuerExamQuestiontb(int stuid, int examid, int integer);
}
