package com.gzz.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.CommentNotGrateService;

@RestController
@RequestMapping("/commentNotGrate")
@CrossOrigin
public class CommentNotGrateController {
	@Autowired
	private CommentNotGrateService service;
	/**
	 * 对评论进行点踩
	 * http://localhost:8021/commentNotGrate/putCommentGrate?commentId=1&commentUid=1
	 * @param commentId评论表的id
	 * @param commentUid用户的id
	 * @return
	 */
	@RequestMapping("/putCommentGrate")
	public Object putCommentGrate(Integer commentId,Integer commentUid) {
		Map<String, Object> map=new HashMap<String, Object>();
		//查询当前用户有没有对该评论进行点赞
		int k=service.getComment(commentId, commentUid);
		if (k>0) {
			map.put("success", false);
			map.put("msg", "该用户对该评论进行过点赞则不能进行点踩了");
		} else {
			//查询当前用户有没有对该评论进行点踩
			int n=service.getCommentByUid(commentId, commentUid);
			if (n>0) {
				service.deleteCommentGrate(commentId, commentUid);
				map.put("success", false);
				map.put("msg", "该用户已点过踩,再次点击是取消点踩");
			} else {
				service.putCommentGrate(commentId, commentUid);
				map.put("success", true);
				map.put("msg", "点踩成功");
			}

		}
		return map;
		
	}
	
	
	
	//对该评论进行点踩
	//如果该用户对评论进行过点赞则再次操作是取消点踩

}
