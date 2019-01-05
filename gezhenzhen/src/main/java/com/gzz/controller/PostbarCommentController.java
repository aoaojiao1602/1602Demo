package com.gzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarComment;
import com.gzz.service.PostbarCommentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/postbarComment")
public class PostbarCommentController {
	
	@Autowired
	private PostbarCommentService postbarCommentService;
	
	/*
	 * 评论回复
	 * http://localhost:8021/postbarComment/putPostbarComment?uId=1&postbarCommentPostbarReplyId=1&postbarCommentContent=你好
	 */
	@RequestMapping("/putPostbarComment")
	public Object putPostbarComment(Integer uId, Integer postbarCommentPostbarReplyId,String postbarCommentContent) {
		int a = postbarCommentService.putPostbarComment(uId, postbarCommentPostbarReplyId, postbarCommentContent);
		Map<String, Object> map = new HashMap<>();
		if(a>0) {
			map.put("success",true);
			map.put("message","评论成功");
		}else {
			map.put("success",false);
			map.put("message","评论失败");
		}
		return map;
	}
	
	/*
	 * 查询评论数
	 * By PostbarReplyId
	 * http://localhost:8021/postbarComment/getPostbarCommentCountByPostbarReplyId?postbarCommentPostbarReplyId=1
	 */
	@RequestMapping("/getPostbarCommentCountByPostbarReplyId")
	public int getPostbarCommentCountByPostbarReplyId(Integer postbarCommentPostbarReplyId) {
		return postbarCommentService.getPostbarCommentCountByPostbarReplyId(postbarCommentPostbarReplyId);
	}
	
	/*
	 * 查询评论数
	 * By uId
	 * http://localhost:8021/postbarComment/getPostbarCommentCountByuId?uId=1
	 */
	@RequestMapping("/getPostbarCommentCountByuId")
	public int getPostbarCommentCountByuId(Integer uId) {
		return postbarCommentService.getPostbarCommentCountByuId(uId);
	}
	
	/*
	 * 删除自己发表的评论
	 * http://localhost:8021/postbarComment/deletePostbarComment?postbarCommentId=1&uId=1
	 */
	@RequestMapping("/deletePostbarComment")
	public Object deletePostbarComment(Integer postbarCommentId,Integer uId) {
		int a = postbarCommentService.deletePostbarComment(postbarCommentId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a>0) {
			map.put("success",true);
			map.put("message","删除成功");
		}else {
			map.put("success",false);
			map.put("message","删除失败");
		}
		return map;
	}
	
	/**
	 * 个人中心评论分页
	 * http://localhost:8021/postbarComment/getPostbarCommentPageByuId?uId=1&page=1&rows=2
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@RequestMapping("/getPostbarCommentPageByuId")
	public Object getPostbarCommentPageByuId(Integer uId,Integer page,Integer rows){
		if(page==0) {
			page=1;
		}
		Page<PostbarComment> pages = postbarCommentService.getPostbarCommentPageByuId(uId,page-1, rows);
		Long total = pages.getTotalElements();
		List<PostbarComment> list = pages.getContent();
		Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}
	
	/**
	 * 评论分页
	 * http://localhost:8021/postbarComment/getPostbarCommentPageByPostbarCommentPostbarReplyId?postbarCommentPostbarReplyId=1&page=1&rows=2
	 * @param postbarCommentPostbarReplyId
	 * @param pageable
	 * @return
	 */
	@RequestMapping("/getPostbarCommentPageByPostbarCommentPostbarReplyId")
	public Object getPostbarCommentPageByPostbarCommentPostbarReplyId(Integer postbarCommentPostbarReplyId,Integer page,Integer rows){
		if(page==0) {
			page=1;
		}
		Page<PostbarComment> pages = postbarCommentService.getPostbarCommentPageByPostbarCommentPostbarReplyId(postbarCommentPostbarReplyId,page-1, rows);
		Long total = pages.getTotalElements();
		List<PostbarComment> list = pages.getContent();
		Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}
}
