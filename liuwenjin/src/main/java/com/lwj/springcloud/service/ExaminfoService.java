package com.lwj.springcloud.service;

import org.springframework.data.domain.Page;

import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Examinfo;

public interface ExaminfoService {
	//查询考试信息
	Page<Examinfo> indexExaminfoPage(Entitysearch search);
	//添加考试
	public Examinfo insertExaminfo(Examinfo examinfo);
	//修改考试
	public int updateExaminfo(Examinfo examinfo);
	//删除考试
	public int deleteExaminfo(Integer exId);
	
}
