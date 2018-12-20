package com.lwj.springcloud.dao;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lwj.springcloud.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>,JpaSpecificationExecutor<Question> {
	//修改选择题
	@Query("update Options set answer=:answer,topic=:topic,optionA=:optionA,optionB=:optionB,optionC=:optionC,optionD=:optionD,score=:score  where optionId=:oid")
	@Modifying
	int updateOptions(@Param("oid")int oid,@Param("answer")String answer,@Param("optionA")String optionA,@Param("optionB")String optionB,@Param("optionC")String optionC,@Param("optionD")String optionD,@Param("score")int score,@Param("topic")String topic );
	//修改题库
	@Query("update Question set sectionId=:seid where qId=:qid")
	@Modifying
	int updateQuestion(@Param("qid")int qid,@Param("seid")int sectionId);
	
	  /** 
	 * http://localhost:8080/updateJudges
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月20日 下午10:32:55  
	  * 版本: V1.0   
	 */
	@Query("update Judges set answer=:answer,topic=:topic,score=:score where judgeId=:judgeId")
	@Modifying
	int updateJudges(@Param("judgeId")Integer judgeId, @Param("answer")String answer, @Param("score")Integer score, @Param("topic")String topic);
	
	  /** 
	 * http://localhost:8080/updateFillblanks
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月20日 下午11:42:10  
	  * 版本: V1.0   
	 */
	@Query("update Fillblanks set answer=:answer,topic=:topic,score=:score where fillblankId=:fillblankId")
	@Modifying
	int updateFillblanks(@Param("fillblankId")Integer fillblankId, @Param("answer")String answer, @Param("score")Integer score, @Param("topic")String topic);
}
