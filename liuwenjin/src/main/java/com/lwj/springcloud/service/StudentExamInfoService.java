package com.lwj.springcloud.service;

import java.util.List;
import java.util.Map;

import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.entity.StudentExamInfo;

public interface StudentExamInfoService {
	//添加学生考试信息
	public StudentExamInfo insertStudentExamInfo(StudentExamInfo stu);
	//修改学生信息
	public int updateStudentExamInfo(StudentExamInfo stu);
	//删除学生信息
	public int deleteStudentExamInfo(Integer id);
	
	  /** 
	 * http://localhost:8080/indexStudentExamInfo
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月22日 下午5:21:39  
	  * 版本: V1.0   
	 */
	
	public Map<String, Object>  indexStudentExamInfo(int stuid, int examid);
	
	  /** 
	 * http://localhost:8080/updateStudentExamInfoQuestion
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月23日 下午5:05:46  
	  * 版本: V1.0   
	 */
	
	public int updateStudentExamInfoQuestion(String daan,int examid,int qid,int stuid);
	
	  /** 
	 * http://localhost:8080/updateStudentExamInfoTime
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月23日 下午7:01:56  
	  * 版本: V1.0   
	 */
	
	public int updateStudentExamInfoTime(int stuid,int examid);
	
	  /** 
	 * http://localhost:8080/queryStudentExamInfoTime
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月23日 下午7:48:51  
	  * 版本: V1.0   
	 */
	
	public StudentExamInfo queryStudentExamInfoTime(int stuid, int examid);
	  /** 
	 * http://localhost:8080/checkDaan
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月24日 上午1:08:35  
	  * 版本: V1.0   
	 */
	
	public int checkDaan(int[] qids, String[] daans);
	
	  /** 
	 * http://localhost:8080/updateStudentExamInfoScore
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月24日 下午2:15:39  
	  * 版本: V1.0   
	 */
	
	public int updateStudentExamInfoScore(int stuid, int examid, int score);
}
