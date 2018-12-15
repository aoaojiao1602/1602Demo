package com.lwj.springcloud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Question;

public interface QuestionService {

	
	  /** 
	 * http://localhost:8080/indexQuestionPage
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月14日 下午11:49:03  
	  * 版本: V1.0   
	 */
	
	Page<Question> indexQuestionPage(Entitysearch search);

}
