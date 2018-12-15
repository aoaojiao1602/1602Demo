package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>,JpaSpecificationExecutor<Question> {
	//删除题库
	@Query("delete from Question q where q.qId=?1")
	@Modifying
	int deleteQuestion(Integer qId);
	//修改题库
	@Query("update Question set optionId=:#{#q.optionId},judgeId=:#{#q.judgeId},fillblankId=:#{#q.fillblankId} where qId=:#{#q.qId}")
	@Modifying
	int updateQuestion(@Param("q")Question question);
}
