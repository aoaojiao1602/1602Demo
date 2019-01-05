package com.lwj.springcloud.service;

import java.util.List;
import java.util.Map;

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
	
	  /** 
	 * http://localhost:8080/queryQuestionTypeCount
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2019年1月4日 下午7:38:47  
	  * 版本: V1.0   
	 */
	
	Map<String, Object> queryQuestionTypeCount();
	
	  /** 
	 * http://localhost:8080/queryCoursesByid
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2019年1月4日 下午8:10:41  
	  * 版本: V1.0   
	 */
	
	List<Examinfo> queryCoursesByid(int cid);
	
}
