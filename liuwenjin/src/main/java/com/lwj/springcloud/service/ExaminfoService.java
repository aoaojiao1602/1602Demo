package com.lwj.springcloud.service;

import com.lwj.springcloud.entity.Examinfo;

public interface ExaminfoService {
	//添加考试
	public Examinfo insertExaminfo(Examinfo examinfo);
	//修改考试
	public int updateExaminfo(Examinfo examinfo);
	//删除考试
	public int deleteExaminfo(Integer exId);
}
