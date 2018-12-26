package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.ReplyReportServive;

@RestController
@RequestMapping("/replyReport")
@CrossOrigin
public class ReplyReportController {
	@Autowired
	private ReplyReportServive service;
	/**
	 * http://localhost:8021/replyReport/putReport?reportUid=1&replyId=1&reportContent=哇哇哇哇
	 * @param reportUid用户的id
	 * @param replyId回复的id
	 * @param reportContent举报的问题
	 * @return
	 */
	@RequestMapping("/putReport")
	public Object putReport(Integer reportUid,Integer replyId,String reportContent) {
		Map<String, Object> map=new HashMap<String, Object>();
		int n=service.putReplyRepotr(reportUid, replyId, reportContent);
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
