package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.PostbarCommentReportService;

@RequestMapping("/postbarCommentReport")
@RestController
public class PostbarCommentReportController {
	
	@Autowired
	private PostbarCommentReportService postbarCommentReportService;
	
	/*
	 * 对评论举报
	 * http://localhost:8021/postbarCommentReport/putPostbarCommentReport?uId=1&postbarCommentReportPostbarCommentId=2&postbarCommentReportContent=你好
	 */
	@RequestMapping("/putPostbarCommentReport")
	public Object putPostbarCommentReport(Integer uId, Integer postbarCommentReportPostbarCommentId, String postbarCommentReportContent) {
		int a = postbarCommentReportService.putPostbarCommentReport(uId, postbarCommentReportPostbarCommentId, postbarCommentReportContent);
		Map<String, Object> map = new HashMap<>();
		if(a>0) {
			map.put("success",true);
			map.put("message","举报成功");
		}else {
			map.put("success",false);
			map.put("message","举报失败");
		}
		return map;
	}
}
