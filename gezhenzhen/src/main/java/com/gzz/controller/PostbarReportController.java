package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.PostbarReportService;

@RestController
@RequestMapping("/postbarReport")
public class PostbarReportController {
	
	@Autowired
	private PostbarReportService postbarReportService;
	
	/*
	 * 对主贴举报
	 * http://localhost:8021/postbarReport/putPostbarReport?uId=1&postbarReportPostbarId=1&postbarReportContent=你好
	 */
	@RequestMapping("/putPostbarReport")
	public Object putPostbarReport(Integer uId, Integer postbarReportPostbarId, String postbarReportContent) {
		int a = postbarReportService.putPostbarReport(uId, postbarReportPostbarId, postbarReportContent);
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
