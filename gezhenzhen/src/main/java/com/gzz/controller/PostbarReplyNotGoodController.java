package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarReplyNotGood;
import com.gzz.service.PostbarReplyNotGoodService;

@RestController
@RequestMapping("/postbarReplyNotGood")
public class PostbarReplyNotGoodController {
	
	@Autowired
	private PostbarReplyNotGoodService postbarReplyNotGoodService;
	
	/*
	 * 踩帖
	 * http://localhost:8021/postbarReplyNotGood/postNotGoodPostbarReply?postbarReplyNotGoodPostbarReplyId=1&uId=1
	 */
	@RequestMapping("/postNotGoodPostbarReply")
	public Object postNotGoodPostbarReply(Integer postbarReplyNotGoodPostbarReplyId, Integer uId) {
		PostbarReplyNotGood a = postbarReplyNotGoodService.getPostbarReplyNotGood(postbarReplyNotGoodPostbarReplyId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a!=null) {
			int b = postbarReplyNotGoodService.deletePostbarReplyNotGood(postbarReplyNotGoodPostbarReplyId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","取消踩帖成功");
			}else {
				map.put("success",false);
				map.put("message","取消踩帖失败");
			}
		}else {
			int b = postbarReplyNotGoodService.putPostbarReplyNotGood(postbarReplyNotGoodPostbarReplyId, uId);
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
	
	/*
	 * 查询踩帖数
	 * http://localhost:8021/postbarReplyNotGood/getPostbarReplyNotGoodCount?postbarReplyNotGoodPostbarReplyId=1
	 */
	@RequestMapping("/getPostbarReplyNotGoodCount")
	public int getPostbarReplyNotGoodCount(Integer postbarReplyNotGoodPostbarReplyId) {
		return postbarReplyNotGoodService.getPostbarReplyNotGoodCount(postbarReplyNotGoodPostbarReplyId);
	}
}
