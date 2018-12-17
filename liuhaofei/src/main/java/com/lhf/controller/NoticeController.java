package com.lhf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Notice;
import com.lhf.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService nService;
	//添加
	//http://localhost:8050/notice/addnotice?noticeCourse=计算机&&noticeName=计算机基础&&noticeContent=九点开课
	@RequestMapping("/addnotice")
	public Object addNotice(Notice n){
		int N=nService.addNotice(n);
		Map<String, Object> map = new HashMap<>();
		if(N>0) {
			map.put("success",true);
			map.put("message","添加成功");
		}else {
			map.put("success",false);
			map.put("message","添加失败");
		}
		return N;
		
	}
	//删除公告
	@RequestMapping("/deletenotice")
	public Object deleteCoursesById(Integer noticeId) {
		int N=nService.deleteNoticeByid(noticeId);
		Map<String, Object> map = new HashMap<>();
		if(N>0) {
			map.put("success",true);
			map.put("message","添加成功");
		}else {
			map.put("success",false);
			map.put("message","添加失败");
		}
		return N;
		
	}
}