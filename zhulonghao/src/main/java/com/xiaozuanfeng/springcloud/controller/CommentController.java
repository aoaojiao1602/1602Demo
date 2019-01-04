package com.xiaozuanfeng.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaozuanfeng.springcloud.services.CommentServices;

@CrossOrigin
@RestController
@RequestMapping("/postbar")
public class CommentController {
	@Autowired
	private CommentServices css;
/**
 * http://localhost:8030/postbar/getPostbarAndReplyAndCommentCountByuId?uId=1
 * @param uId
 * @return
 */
	@RequestMapping(value = "/getPostbarAndReplyAndCommentCountByuId", method = RequestMethod.GET)
	public int getPostbarAndReplyAndCommentCountByuId(Integer uid) {
		return css.getPostbarAndReplyAndCommentCountByuId(uid);
	}
	@RequestMapping(value = "/getPostbarAndReplyAndCommentGoodCountByuId", method = RequestMethod.GET)
	public int getPostbarAndReplyAndCommentGoodCountByuId(Integer uid) {
		return css.getPostbarAndReplyAndCommentGoodCountByuId(uid);
	}
}
