package com.xiaozuanfeng.springcloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("gezhenzhen")
public interface CommentServices {
	@RequestMapping("/postbar/getPostbarAndReplyAndCommentCountByuId")
	public int getPostbarAndReplyAndCommentCountByuId(@RequestParam("uId") Integer uId);

	@RequestMapping("/postbar/getPostbarAndReplyAndCommentGoodCountByuId")
	public int getPostbarAndReplyAndCommentGoodCountByuId(@RequestParam("uId") Integer uId);

	@RequestMapping("/postbarReply/getPostbarReplyPageByuId")
	public Object getPostbarReplyPageByuId(@RequestParam("uId") Integer uId, @RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows);

	@RequestMapping("/postbar/getPostbarPageByuId")
	public Object getPostbarPageByuId(@RequestParam("uId") Integer uId, @RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows);

	@RequestMapping("/postbarComment/getPostbarCommentPageByuId")
	public Object getPostbarCommentPageByuId(@RequestParam("uId") Integer uId, @RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows);
}
