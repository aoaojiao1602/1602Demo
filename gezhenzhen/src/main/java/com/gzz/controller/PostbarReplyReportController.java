package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.PostbarReplyReportService;

@RestController
@RequestMapping("/postbarReplyReport")
public class PostbarReplyReportController {
	
	@Autowired
	private PostbarReplyReportService postbarReplyReportService;
	
	/*
	 * 对回复举报
	 * http://localhost:8021/postbarReplyReport/putPostbarReplyReport?uId=1&postbarReplyReportPostbarReplyId=1&postbarReplyReportContent=你好
	 */
	@RequestMapping("/putPostbarReplyReport")
	public Object putPostbarReplyReport(Integer uId, Integer postbarReplyReportPostbarReplyId, String postbarReplyReportContent) {
		int a = postbarReplyReportService.putPostbarReplyReport(uId, postbarReplyReportPostbarReplyId, postbarReplyReportContent);
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
