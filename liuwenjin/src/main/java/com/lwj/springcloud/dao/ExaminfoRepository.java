package com.lwj.springcloud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.entity.Options;

public interface ExaminfoRepository extends JpaRepository<Examinfo, Integer>,JpaSpecificationExecutor<Examinfo> {
	//修改考试
	@Query("update Examinfo set startTime=:#{#e.startTime},endTime=:#{#e.endTime},paperName=:#{#e.paperName},cxTime=:#{#e.cxTime},optionNum=:#{#e.optionNum},judgeNum=:#{#e.judgeNum},fillblankNum=:#{#e.fillblankNum},examScore=:#{#e.examScore} where exId=:#{#e.exId}")
	@Modifying
	int updateQuestion(@Param("e")Examinfo examinfo);
	//删除考试
	@Query("delete from Examinfo e where e.exId=?1")
	@Modifying
	int deleteExaminfo(Integer exId);
	@Query("select q.qId from Question q,Options o where q.options=o.question")
	List<Integer> queryOptions();
	
	  /** 
	 * http://localhost:8080/insetExamQuestiontb
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月21日 下午7:48:52  
	  * 版本: V1.0   
	 */
	@Query(value="INSERT INTO exam_questiontb VALUES (:eid,:qid)",nativeQuery=true)
	@Modifying
	int insetExamQuestiontb(@Param("qid")Integer integer, @Param("eid")Integer exId);
	
	  /** 
	 * http://localhost:8080/queryJudges
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月21日 下午8:05:19  
	  * 版本: V1.0   
	 */
	@Query("select q.qId from Question q,Judges j where q.judges=j.question")
	List<Integer> queryJudges();
	
	  /** 
	 * http://localhost:8080/queryFillblankNums
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月21日 下午8:08:43  
	  * 版本: V1.0   
	 */
	@Query("select q.qId from Question q,Fillblanks f where q.fillblanks=f.question")
	List<Integer> queryFillblankNums();
}
