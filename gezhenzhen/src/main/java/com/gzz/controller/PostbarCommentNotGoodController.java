package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarCommentNotGood;
import com.gzz.service.PostbarCommentNotGoodService;

@RequestMapping("/postbarCommentNotGood")
@RestController
public class PostbarCommentNotGoodController {
	
	@Autowired
	private PostbarCommentNotGoodService postbarCommentNotGoodService;
	
	/*
	 * 踩帖
	 * http://localhost:8021/postbarCommentNotGood/postNotGoodPostbarComment?postbarCommentNotGoodPostbarCommentId=2&uId=1
	 */
	@RequestMapping("/postNotGoodPostbarComment")
	public Object postNotGoodPostbarComment(Integer postbarCommentNotGoodPostbarCommentId, Integer uId) {
		PostbarCommentNotGood a = postbarCommentNotGoodService.getPostbarCommentNotGood(postbarCommentNotGoodPostbarCommentId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a!=null) {
			int b = postbarCommentNotGoodService.deletePostbarCommentNotGood(postbarCommentNotGoodPostbarCommentId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","取消踩帖成功");
			}else {
				map.put("success",false);
				map.put("message","取消踩帖失败");
			}
		}else {
			int b = postbarCommentNotGoodService.putPostbarCommentNotGood(postbarCommentNotGoodPostbarCommentId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","踩帖成功");
			}else {
				map.put("success",false);
				map.put("message","踩帖失败");
			}
		}
		return map;
	}
}
