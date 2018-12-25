package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.CommentReportService;

@RestController
@RequestMapping("/commentReport")
@CrossOrigin
public class CommentReoprtController {
	@Autowired
	private CommentReportService service;
	/**
	 * http://localhost:8021/commentReport/putCommentReport?commentId=1&commentUid=1&reportContent=2222
	 * @param commentId
	 * @param commentUid
	 * @param reportContent
	 * @return
	 */
	@RequestMapping("/putCommentReport")
	public Object putCommentReport(Integer commentId,Integer commentUid,String reportContent) {
		Map<String, Object> map=new HashMap<String, Object>();
		int n=service.putCommentReport(commentId, commentUid, reportContent);
		if (n>0) {
			map.put("success", true);
			map.put("msg", "举报成功");
		} else {
			map.put("success", false);
			map.put("msg", "举报失败");
		}
		return map;
	}

}
