package com.lwj.springcloud.service;

import com.lwj.springcloud.entity.StudentExamInfo;

public interface StudentExamInfoService {
	//添加学生考试信息
	public StudentExamInfo insertStudentExamInfo(StudentExamInfo stu);
	//修改学生信息
	public int updateStudentExamInfo(StudentExamInfo stu);
	//删除学生信息
	public int deleteStudentExamInfo(Integer id);
}
