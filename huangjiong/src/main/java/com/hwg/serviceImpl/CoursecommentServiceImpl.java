package com.hwg.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwg.entity.Coursecomment;
import com.hwg.repository.CourseCommentDao;
import com.hwg.service.CoursecommentService;

/**
 * @Description 课程评价接口实现类
 * @author HJiong
 * @time 2018年12月31日 下午12:25:01
 */
@Service
public class CoursecommentServiceImpl implements CoursecommentService {
	@Autowired
	private CourseCommentDao cDao;
	
	/**
	 *根据条件查询课程评论
	 */
	@Override
	public List<Coursecomment> getCommentByWhere(String ksTime,String jsTime) {
		
		return cDao.findAll();
	}
	
}
