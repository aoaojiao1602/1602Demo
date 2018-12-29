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
}
