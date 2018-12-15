package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.ReplyGoodServive;

@RestController
@RequestMapping("/replyGood")
@CrossOrigin
public class ReplyGoodController {
	@Autowired 
	private ReplyGoodServive servive;
	/**
	 * http://localhost:8021/replyGood/putReplyGood?replyGoodUid=1&replyId=1
	 * @param replyGoodUid用户的id
	 * @param replyId回复的id
	 * @return
	 */
	@RequestMapping("/putReplyGood")
	public Object putReplyGood(Integer replyGoodUid, Integer replyId) {
		Map<String, Object> map=new HashMap<String, Object>();
		//查询当前用户有没有对该回复进行点赞
		int n=servive.getReplyByUid(replyGoodUid, replyId);
		if (n>0) {
			//如果点过赞则再次操作时取消点赞
			servive.deleteReplyByUid(replyGoodUid, replyId);
			map.put("success", false);
			map.put("msg", "该用户已点过赞,再次点击是取消点赞");
		}else {
			//如果没有点赞则进行点赞
			servive.putReplyGood(replyGoodUid, replyId);
			map.put("success", true);
			map.put("msg", "点赞成功");
		}
		return map;
	}

}
