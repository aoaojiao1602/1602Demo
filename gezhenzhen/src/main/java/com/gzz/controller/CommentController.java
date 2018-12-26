package com.gzz.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {
	@Autowired
	private CommentService service;
	/**
	 * http://localhost:8021/comment/putComment?replyId=1&commentUid=1&commentContent=222
	 * 
	 * 对评论进行回复
	 * @param replyId回复的id
	 * @param commentUid用户的id
	 * @param commentContent评论的内容
	 * @return
	 */
	@RequestMapping("/putComment")
	public Object putComment(Integer replyId,Integer commentUid,String commentContent) {
		Map<String, Object> map=new HashMap<String, Object>();
		int n=service.putComment(replyId, commentUid, commentContent);
		if (n>0) {
			map.put("success", true);
			map.put("msg", "评论成功");
		} else {
			map.put("success", false);
			map.put("msg", "评论失败");
		}
		return map;
	}
	/**
	 * http://localhost:8021/comment/deleteComment?commentId=8
	 * 删除评论
	 * @param commentId评论的id
	 * @return
	 */
	@RequestMapping("/deleteComment")
	public Object deleteComment(Integer commentId) {
		Map<String, Object> map=new HashMap<String, Object>();
		int n=service.deleyeComment(commentId);
		if (n>0) {
			map.put("success", true);
			map.put("msg", "删除成功");
		} else {
			map.put("success", false);
			map.put("msg", "删除失败");
		}
		return map;
	}

}
