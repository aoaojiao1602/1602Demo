package com.xiaozuanfeng.springcloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("gezhenzhen")
public interface CommentServices {
	@RequestMapping("/postbar/getPostbarAndReplyAndCommentCountByuId")
	public int getPostbarAndReplyAndCommentCountByuId(@RequestParam("uId")Integer uId);

	@RequestMapping("/postbar/getPostbarAndReplyAndCommentGoodCountByuId")
	public int getPostbarAndReplyAndCommentGoodCountByuId(@RequestParam("uId")Integer uId);
}
