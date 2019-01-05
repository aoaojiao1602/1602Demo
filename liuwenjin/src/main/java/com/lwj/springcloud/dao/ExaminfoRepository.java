package com.lwj.springcloud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.entity.Options;
import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.entity.StudentExamQuestion;

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
	
	  /** 
	 * http://localhost:8080/queryQuestion
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月22日 下午7:15:23  
	  * 版本: V1.0   
	 */
	//q.qId,q.options.topic,q.options.optionA,q.options.optionB,q.options.optionC,q.options.optionD,q.options.score,q.Judges.topic,q.Judges.score,q.Fillblanks.topic,q.Fillblanks.score,q.daan 
	@Query(" from Question q where qId=?1 ")
	Question queryQuestion(Integer integer);
	
	  /** 
	 * http://localhost:8080/queryExamQuestion
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月22日 下午7:33:04  
	  * 版本: V1.0   
	 */
	@Query(value=" SELECT se.examquestiontb_question_id FROM  exam_questiontb se WHERE  se.examquestiontb_examinfo_id=?1",nativeQuery=true)
	List<Integer> queryExamQuestion(Integer exId);
	
	  /** 
	 * http://localhost:8080/inserStudentQuerExamQuestiontb
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月22日 下午7:50:47  
	  * 版本: V1.0   
	 */
	@Query(value="INSERT INTO student_exam_questiontb(student_id,exam_id,questiontb_id) VALUES (?1,?2,?3)",nativeQuery=true)
	@Modifying
	int inserStudentQuerExamQuestiontb(int stuid, int examid, int integer);
	
	  /** 
	 * http://localhost:8080/queryStudentQuerExamQuestiontb
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月22日 下午9:10:00  
	  * 版本: V1.0   
	 */
	@Query("FROM  StudentExamQuestion  seq WHERE  seq.studentId=?1 AND seq.examId=?2")
	List<StudentExamQuestion> queryStudentQuerExamQuestiontb(int stuid, int examid);
	
	  /** 
	 * http://localhost:8080/queryQuestionDaan
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月24日 下午3:14:54  
	  * 版本: V1.0   
	 */
	@Query("from Question q where qId=?1 ")
	Question queryQuestionDaan(int i);
	
	  /** 
	 * http://localhost:8080/queryQuestionAll
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2019年1月4日 下午7:40:49  
	  * 版本: V1.0   
	 */
	@Query(" from Question ")
	List<Question> queryQuestionAll();
	
	  /** 
	 * http://localhost:8080/queryCoursesByid
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2019年1月4日 下午8:11:50  
	  * 版本: V1.0   
	 */
	@Query(value=" SELECT * FROM examinfotb WHERE k_id=?1 AND YEAR(end_time)!=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))",nativeQuery=true)
	List<Examinfo> queryCoursesByid(int cid);
	
	
	
	
}
