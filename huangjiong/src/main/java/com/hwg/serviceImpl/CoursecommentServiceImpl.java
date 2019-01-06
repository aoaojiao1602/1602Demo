package com.hwg.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwg.controller.Common;
import com.hwg.entity.Coursecomment;
import com.hwg.repository.CourseCommentDao;
import com.hwg.repository.DzrecordDao;
import com.hwg.service.CourseService;
import com.hwg.service.CoursecommentService;
/**
 * @Description 课程评价接口实现类
 * @author HJiong
 * @time 2018年12月31日 下午12:25:01
 */
@Service
public class CoursecommentServiceImpl implements CoursecommentService  {
	@Autowired
	private CourseCommentDao cDao;
	
	@Autowired
	private DzrecordDao dDao;
	
	@Autowired
	private Common cController;
	
	@Autowired
	private CourseService cService;
	
	/**
	 *根据条件查询课程评论
	 */
	@Override
	public List<Coursecomment> getCommentByWhere(String ksTime,String jsTime) {
		
		return cDao.findAll();
	}
	
	

	/**
	 * 多条件分页查询
	 */
	@Override
	public List<Map<String, Object>> getCourseComment(Integer cid) {
		List<Map<String, Object>> list=cDao.findByCid(cid);
		List<Map<String, Object>> restList=new ArrayList<>();
		for (Map<String, Object> cc : list) {
			Map<String, Object> map=new HashMap<>();
			Map<String, Object> user=(Map<String, Object>) cController.queryUser(Integer.parseInt(cc.get("comment_stu_id").toString()));
			if(user!=null) {
				map.put("userName", user.get("ui_truename"));
				map.put("url", user.get("ui_headportrait"));
			}
			map.putAll(cc);
			restList.add(map);
		}
		return restList;
	}

	/**
	 * 根据课程编号查询课程评论的总条数
	 */
	@Override
	public int countCourseComment(Coursecomment comment) {
		System.out.println("需要查询的课程编号是======>" + comment.getCommentCourseId());
		return cDao.countCourseComment(comment);
	}

	/**
	 * 根据课程编号查询课程评价的平均星级
	 */
	@Override
	public double getCommentStar(Coursecomment comment) {
		System.out.println("需要查询的课程编号是======>" + comment.getCommentCourseId());
		return cDao.getCommentStar(comment);
	}

	/**
	 * 添加课程评论
	 */
	@Override
	public Coursecomment createComment(Coursecomment comment) {
		Map<String, Object> map=(Map<String, Object>) cService.getCourseById(comment.getCommentCourseId());
		comment.setCommentCourseCategoryId(Integer.parseInt(map.get("courseCategory").toString()));
		System.out.println("新增的评论是======>" + comment);
		
		return cDao.save(comment);
	}

	/**
	 * 给评论点赞
	 */
	@Override
	@Transactional
	public int updateCommentliked(Coursecomment comment) {
		System.out.println("被点赞的评论编号是======>"+comment.getCommentId());
		if(dDao.findDzrecordByUserIdAndCommentId( comment.getCommentStuId(),comment.getCommentId())!=null) {
			return 0;
		}else {
			dDao.add(comment.getCommentId(), comment.getCommentStuId());
			cDao.updateCommentliked(comment);
			return 1;
		}
		
	}
	
}
