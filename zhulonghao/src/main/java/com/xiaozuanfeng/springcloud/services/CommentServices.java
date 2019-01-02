package com.xiaozuanfeng.springcloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaozuanfeng.springcloud.services.servicesImpl.CommentServicesImpl;

@FeignClient(value="gezhenzhen",fallback=CommentServicesImpl.class)
public interface CommentServices {
	@RequestMapping("/postbar/getPostbarAndReplyAndCommentCountByuId")
	public int getPostbarAndReplyAndCommentCountByuId(Integer uId);
	@RequestMapping("/postbar/getPostbarAndReplyAndCommentGoodCountByuId")
	public int getPostbarAndReplyAndCommentGoodCountByuId(Integer uId);
}
