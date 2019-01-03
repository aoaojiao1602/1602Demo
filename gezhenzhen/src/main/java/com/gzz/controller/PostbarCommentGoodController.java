package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarCommentGood;
import com.gzz.service.PostbarCommentGoodService;

@RestController
@RequestMapping("/postbarCommentGood")
public class PostbarCommentGoodController {
	
	@Autowired
	private PostbarCommentGoodService postbarCommentGoodService;
	
	/*
	 * 对评论点赞
	 * http://localhost:8021/postbarCommentGood/putGoodPostbarComment?postbarCommentGoodPostbarCommentId=2&uId=1
	 */
	@RequestMapping("/putGoodPostbarComment")
	public Object putGoodPostbarComment(Integer postbarCommentGoodPostbarCommentId, Integer uId) {
		PostbarCommentGood a = postbarCommentGoodService.getPostbarCommentGood(postbarCommentGoodPostbarCommentId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a!=null) {
			int b = postbarCommentGoodService.deletePostbarCommentGood(postbarCommentGoodPostbarCommentId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","取消点赞成功");
			}else {
				map.put("success",false);
				map.put("message","取消点赞失败");
			}
		}else {
			int b = postbarCommentGoodService.putPostbarCommentGood(postbarCommentGoodPostbarCommentId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","点赞成功");
			}else {
				map.put("success",false);
				map.put("message","点赞失败");
			}
		}
		return map;
	}
	
	/*
	 * 查询点赞数
	 * by PostbarCommentId
	 * http://localhost:8021/postbarCommentGood/getPostbarCommentGoodCountByPostbarComentId?postbarCommentGoodPostbarCommentId=2
	 */
	@RequestMapping("/getPostbarCommentGoodCountByPostbarComentId")
	public int getPostbarCommentGoodCountByPostbarComentId(Integer postbarCommentGoodPostbarCommentId) {
		return postbarCommentGoodService.getPostbarCommentGoodCountByPostbarComentId(postbarCommentGoodPostbarCommentId);
	}
	
	/*
	 * 查询点赞数
	 * by uId
	 * http://localhost:8021/postbarCommentGood/getPostbarCommentGoodCountByuId?uId=1
	 */
	@RequestMapping("/getPostbarCommentGoodCountByuId")
	public int getPostbarCommentGoodCountByuId(Integer uId) {
		return postbarCommentGoodService.getPostbarCommentGoodCountByuId(uId);
	}
}
