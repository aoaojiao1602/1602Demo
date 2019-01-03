package com.lhf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Courses;
import com.lhf.entity.CoursesSearch;
import com.lhf.entity.Notice;
import com.lhf.entity.NoticeSearch;
import com.lhf.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService nService;

	// 查询方法
	// http://http://localhost:8050/notice/query?page=1&&limit=2
	@RequestMapping("/query")
	public Object queryByDynamicSQLPage(NoticeSearch n, int page, int limit) {
		Page<Notice> sqlPage = nService.queryByDynamicSQLPage(n, page - 1, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", sqlPage.getTotalElements());
		map.put("data", sqlPage.getContent());
		return map;
	}

	// 根据课程Id查询公告
	@RequestMapping("/getNoticeBycourseId")
	public Object getNoticeBycourseId(Integer courseId) {
		List<Notice> list = nService.getNoticeBycourseId(courseId);
		return list;
	}

	// 添加
	// http://localhost:8050/notice/putNotice?noticeCourse=计算机&&noticeName=计算机基础&&noticeContent=九点开课
	@RequestMapping("/putNotice")
	public Object putNotice(Notice n) {
		int N = nService.putNotice(n);
		Map<String, Object> map = new HashMap<>();
		if (N > 0) {
			map.put("success", true);
			map.put("message", "添加成功");
		} else {
			map.put("success", false);
			map.put("message", "添加失败");
		}
		return N;

	}

	// 删除公告
	@RequestMapping("/deleteNotice")
	public Object deleteNoticeByid(Integer noticeId) {
		int N = nService.deleteNoticeByid(noticeId);
		Map<String, Object> map = new HashMap<>();
		if (N > 0) {
			map.put("success", true);
			map.put("message", "删除成功");
		} else {
			map.put("success", false);
			map.put("message", "删除失败");
		}
		return N;

	}

	// 修改
	// http://localhost:8050/notice/postNotice?noticeCourse=计算机&&noticeName=学习计算机&&noticeContent=九点开课了&&noticeId=6
	@RequestMapping("/postNotice")
	public Object postNotice(Notice n) {
		int N = nService.putNotice(n);
		Map<String, Object> map = new HashMap<>();
		if (N > 0) {
			map.put("success", true);
			map.put("message", "修改成功");
		} else {
			map.put("success", false);
			map.put("message", "修改失败");
		}
		return N;
	}
}