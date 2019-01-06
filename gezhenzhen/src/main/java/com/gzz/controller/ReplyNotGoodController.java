package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.ReplyNotGoodServive;

@RestController
@RequestMapping("/replyNotGood")
@CrossOrigin
public class ReplyNotGoodController {
	@Autowired
	private ReplyNotGoodServive service;
	/**
	 * http://localhost:8021/replyNotGood/putReplyNotGoo?replyNotGoodReplyId=4&replyNotGoodUid=1
	 * @param replyNotGoodReplyId回复表的id
	 * @param replyNotGoodUid用户的id
	 * @return
	 */
	@RequestMapping("/putReplyNotGoo")
	public Object putReplyNotGoo(Integer replyGoodUid,Integer replyId,Integer replyNotGoodReplyId, Integer replyNotGoodUid) {
		Map<String, Object> map=new HashMap<String, Object>();
		//查询当前用户有没有对该回复进行点赞
		int k=service.getReplyUid(replyGoodUid, replyId);
		System.out.println("k>>>>>>"+k);
		System.out.println(replyNotGoodReplyId);
		if (k>0) {
			map.put("success", false);
			map.put("msg", "该用户对该回复进行过点赞则不能进行点踩了");
		} else {
			//对回复进行点踩，查询当前用户是否对该回复进行了点踩
			int n=service.getReplyNotGood(replyNotGoodReplyId, replyNotGoodUid);
			if (n>0) {
				//如果该用户对该回复进行了点踩则再次操作是取消点踩
				service.deleteReplyNotGood(replyNotGoodReplyId, replyNotGoodUid);
				map.put("success", false);
				map.put("msg", "该用户已点过踩,再次点击是取消点踩");
			} else {
				//查询当前用户有没有对该回复进行点赞
				service.putReplyNotGood(replyNotGoodReplyId, replyNotGoodUid);
				map.put("success", true);
				map.put("msg", "点踩成功");
			}

		}
		
		return map;
	}

}
