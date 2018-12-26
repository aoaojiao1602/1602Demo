package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.CommentGrateService;

@RestController
@RequestMapping("/commentGrate")
@CrossOrigin
public class CommentGrateController {
	@Autowired
	private CommentGrateService service;

	/**
	 * http://localhost:8021/commentGrate/putCommentGrate?commentId=1&commentUid=2
	 * 对评论进行点赞
	 * @param commentId评论的id
	 * @param commentUid当前用户的id
	 * @return
	 */
	@RequestMapping("/putCommentGrate")
	public Object putCommentGrate(Integer commentId, Integer commentUid) {
		Map<String, Object> map = new HashMap<String, Object>();
		//查询当前用户有没有对该评论进行点踩
		int k = service.getNotComment(commentId, commentUid);
		if (k > 0) {
			map.put("success", false);
			map.put("msg", "该用户对该评论进行过点踩则不能进行点赞了");
		} else {
			//查询当前用户有没有对该评论进行点赞
			int n = service.getCommentByUid(commentId, commentUid);
			if (n > 0) {
				//如果该用户对评论进行过点赞则再次操作是取消点赞
				service.deleteComment(commentId, commentUid);
				map.put("success", false);
				map.put("msg", "该用户已点过赞,再次点击是取消点赞");
			} else {
				//对该评论进行点赞
				service.putComments(commentId, commentUid);
				map.put("success", true);
				map.put("msg", "点赞成功");
			}

		}
		return map;
	}

}
