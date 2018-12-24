package com.lwj.springcloud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.entity.StudentExamInfo;

public interface StudentExamInfoRepository extends JpaRepository<StudentExamInfo, Integer>,JpaSpecificationExecutor<StudentExamInfo> {
	//修改学生考试信息
	@Query("update StudentExamInfo set examinfo=:#{#s.examinfo},examScore=:#{#s.examScore},time=:#{#s.time} where id=:#{#s.id}")
	@Modifying
	int updateStudentExamInfo(@Param("s")StudentExamInfo stu);
	//删除学生考试信息
	@Query("delete from StudentExamInfo s where s.id=?1")
	public int deleteStudentExamInfo(Integer id);
	
	  /** 
	 * http://localhost:8080/indexStudentExamInfo
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月22日 下午5:22:50  
	  * 版本: V1.0   
	 */
	@Query(value="SELECT * FROM examinfotb e,student_examinfotb se WHERE e.ex_id=se.examinfo_id AND student_id =?1 AND examinfo_id=?2",nativeQuery=true)
	StudentExamInfo indexStudentExamInfo(int stuid, int examid);
	
	  /** 
	 * http://localhost:8080/queryExaminfo
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月22日 下午6:04:59  
	  * 版本: V1.0   
	 */
	@Query("SELECT e FROM Examinfo e WHERE e.exId=?1")
	Examinfo queryExaminfo(int examid);
	
	  /** 
	 * http://localhost:8080/updateStudentExamInfoQuestion
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月23日 下午5:06:47  
	  * 版本: V1.0   
	 */
	@Query(value="UPDATE student_exam_questiontb  SET answer=?1 WHERE exam_id =?2 AND questiontb_id=?3 AND student_id=?4 ",nativeQuery=true)
	@Modifying
	int updateStudentExamInfoQuestion(String daan,int examid,int qid,int stuid);
	
	  /** 
	 * http://localhost:8080/updateStudentExamInfoTime
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月23日 下午7:02:52  
	  * 版本: V1.0   
	 */
	@Query(value="UPDATE student_examinfotb SET TIME=TIME-1 WHERE student_id =?1 AND examinfo_id=?2",nativeQuery=true)
	@Modifying
	int updateStudentExamInfoTime(int stuid,int examid);
	
	  /** 
	 * http://localhost:8080/queryStudentExamInfoTime
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月23日 下午7:49:55  
	  * 版本: V1.0   
	 */
	@Query(value="SELECT se.time FROM student_examinfotb se WHERE  se.student_id =?1 AND se.examinfo_id=?2",nativeQuery=true)
	StudentExamInfo queryStudentExamInfoTime(int stuid, int examid);
	
	  /** 
	 * http://localhost:8080/updateStudentExamInfoScore
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月24日 下午2:17:04  
	  * 版本: V1.0   
	 */
	@Query(value="UPDATE student_examinfotb SET exam_score=?3 WHERE student_id =?1 AND examinfo_id=?2",nativeQuery=true)
	@Modifying
	int updateStudentExamInfoScore(int stuid, int examid, int score);
	
}
