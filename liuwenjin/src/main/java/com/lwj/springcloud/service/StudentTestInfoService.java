package com.lwj.springcloud.service;

import java.util.Map;

import com.lwj.springcloud.entity.StudentTestInfo;

public interface StudentTestInfoService {
	public Map<String, Object>  indexStudentTestInfo(int stuid, int testId);
	//添加学生测试信息
	public StudentTestInfo insertStudentTestInfo(StudentTestInfo stu);
	//修改学生测试信息
	public int updateStudentTestInfo(StudentTestInfo stu);
	//删除学生测试信息
	public int deleteStudentTestInfo(Integer id);
	public int checkDaan(int[] qids, String[] daans);
	public int updateStudentTestInfoScore(int stuid, int testid, int score);
	
	  /** 
	 * http://localhost:8080/stuCheckTest
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2019年1月3日 下午12:07:44  
	  * 版本: V1.0   
	 */
	
	public Map<String, Object> stuCheckTest(int sectionid, int stuid);
}
