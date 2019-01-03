package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarReplyGood;
import com.gzz.service.PostbarReplyGoodService;

@RestController
@RequestMapping("/postbarReplyGood")
public class PostbarReplyGoodController {
	
	@Autowired
	private PostbarReplyGoodService postbarReplyGoodService;
	
	/*
	 * 对回复点赞
	 * http://localhost:8021/postbarReplyGood/putGoodPostbarReply?postbarReplyGoodPostbarReplyId=1&uId=1
	 */
	@RequestMapping("/putGoodPostbarReply")
	public Object putGoodPostbarReply(Integer postbarReplyGoodPostbarReplyId, Integer uId) {
		PostbarReplyGood a = postbarReplyGoodService.getPostbarReplyGood(postbarReplyGoodPostbarReplyId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a!=null) {
			int b = postbarReplyGoodService.deletePostbarReplyGood(postbarReplyGoodPostbarReplyId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","取消点赞成功");
			}else {
				map.put("success",false);
				map.put("message","取消点赞失败");
			}
		}else {
			int b = postbarReplyGoodService.putPostbarReplyGood(postbarReplyGoodPostbarReplyId, uId);
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
	 * by PostbarReplyId
	 * http://localhost:8021/postbarReplyGood/getPostbarReplyGoodCountByPostbarReplyId?postbarReplyGoodPostbarReplyId=1
	 */
	@RequestMapping("/getPostbarReplyGoodCountByPostbarReplyId")
	public int getPostbarReplyGoodCountByPostbarReplyId(Integer postbarReplyGoodPostbarReplyId) {
		return postbarReplyGoodService.getPostbarReplyGoodCountByPostbarReplyId(postbarReplyGoodPostbarReplyId);
	}
	
	/*
	 * 查询点赞数
	 * by uId
	 * http://localhost:8021/postbarReplyGood/getPostbarReplyGoodCountByuId?uId=1
	 */
	@RequestMapping("/getPostbarReplyGoodCountByuId")
	public int getPostbarReplyGoodCountByuId(Integer uId) {
		return postbarReplyGoodService.getPostbarReplyGoodCountByuId(uId);
	}
}
