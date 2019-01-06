package com.gzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gzz.entity.ProjectReply;
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
		System.out.println(replyUid+">>>>>>>>>>>");
		System.out.println(projectId+">>>>>>>>>>>");
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
	/**
	 * http://localhost:8021/reply/getReplyPage?projectId=1&page=1&rows=3
	 * 查询对某一个主题的回复
	 * @param projectId主题的id
	 * @param page页数
	 * @param rows一页显示多少条
	 * @return
	 */
	@RequestMapping("/getReplyPage")
	public Object getReplyPage(Integer projectId, Integer page,Integer rows) {
		System.out.println("projectId====>" + projectId);
		System.out.println("page====>" + page);
		System.out.println("rows====>" + rows);
		Page<ProjectReply> page2 = null;
		page2 = servive.getReplyPage(projectId, page-1, rows);
		System.out.println("qqqqqqqqqqq");
		Long total = page2.getTotalElements();
		List<ProjectReply> rows2 = page2.getContent();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows2);
		System.out.println(rows2);
		return map;
	}

}
