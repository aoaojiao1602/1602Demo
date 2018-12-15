package com.lwj.springcloud.service;

import com.lwj.springcloud.entity.StudentTestInfo;

public interface StudentTestInfoService {
	//添加学生测试信息
	public StudentTestInfo insertStudentTestInfo(StudentTestInfo stu);
	//修改学生测试信息
	public int updateStudentTestInfo(StudentTestInfo stu);
	//删除学生测试信息
	public int deleteStudentTestInfo(Integer id);
}
