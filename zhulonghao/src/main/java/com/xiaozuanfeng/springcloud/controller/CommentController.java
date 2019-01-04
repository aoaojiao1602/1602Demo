package com.xiaozuanfeng.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * 
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

	/**
	 * http://localhost:8030/postbar/getPostbarReplyPageByuId?uId=1&page=1&rows=2
	 * 
	 * @param uId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getPostbarReplyPageByuId")
	public Object getPostbarReplyPageByuId(Integer uId, Integer page, Integer rows) {
		return css.getPostbarPageByuId(uId, page, rows);
	}

	/**
	 * http://localhost:8030/postbar/getPostbarPageByuId?uId=1&page=1&rows=1
	 * 
	 * @param uId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getPostbarPageByuId")
	public Object getPostbarPageByuId(Integer uId, Integer page, Integer rows) {
		return css.getPostbarReplyPageByuId(uId, page, rows);
	}

	/**
	 * http://localhost:8030/postbar/getPostbarCommentPageByuId?uId=1&page=1&rows=2
	 * 
	 * @param uId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getPostbarCommentPageByuId")
	public Object getPostbarCommentPageByuId(@RequestParam("uId") Integer uId, @RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows) {
		return css.getPostbarCommentPageByuId(uId, page, rows);
	}
}
