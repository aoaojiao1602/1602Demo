package com.lwj.springcloud.service;

import com.lwj.springcloud.entity.Question;

public interface QuestionService {
	//添加题库
	public Question insertQuestion(Question q);
	//删除题库
	public int deleteQuestion(Integer qId);
	//修改题库
	public int updateQuestion(Question q);
}
