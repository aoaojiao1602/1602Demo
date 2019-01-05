package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.ReplyServive;

@RestController
@RequestMapping("/reply")
@CrossOrigin
public class ReplyController {
	@Autowired
	private ReplyServive servive;

	/**
	 * http://localhost:8021/reply/putReply?replyContent=222&replyUid=2&projectId=1
	 * 
	 * @param replyContent回复的内容
	 * @param replyUid用户的id
	 * @param projectId主贴的id
	 * @return
	 */
	@RequestMapping("/putReply")
	public Object putReply(String replyContent, Integer replyUid, Integer projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n = servive.putReply(replyContent, replyUid, projectId);
		if (n > 0) {
			map.put("success", true);
			map.put("msg", "回复成功");
		} else {
			map.put("success", false);
			map.put("msg", "回复失败");
		}
		return map;
	}

	/**
	 * http://localhost:8021/reply/deleteReply?replyId=10
	 * 
	 * @param replyId回复的id
	 * @return
	 */
	@RequestMapping("/deleteReply")
	public Object deleteReply(Integer replyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int m = servive.deleteComment(replyId);
		if (m > 0) {
			int n = servive.deleteReply(replyId);
			if (n > 0) {
				map.put("success", true);
				map.put("msg", "删除成功");
			} else {
				map.put("success", false);
				map.put("msg", "删除失败");
			}
		} else {
			map.put("success", false);
			map.put("msg", "删除失败");
		}
		return map;
	}

}
