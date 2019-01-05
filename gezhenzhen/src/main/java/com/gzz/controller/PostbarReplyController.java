package com.gzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarReply;
import com.gzz.service.PostbarCommentService;
import com.gzz.service.PostbarReplyService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/postbarReply")
public class PostbarReplyController {
	
	@Autowired
	private PostbarReplyService postbarReplyService;
	
	@Autowired
	private PostbarCommentService postbarCommentService;
	
	/*
	 * 回复主贴
	 * http://localhost:8021/postbarReply/putPostbarReply?uId=1&postbarReplyPostbarId=1&postbarReplyContent=你好
	 */
	@RequestMapping("/putPostbarReply")
	public Object putPostbarReply(Integer uId, Integer postbarReplyPostbarId, String postbarReplyContent) {
		int a = postbarReplyService.putPostbarReply(uId, postbarReplyPostbarId, postbarReplyContent);
		Map<String, Object> map = new HashMap<>();
		if(a>0) {
			map.put("success",true);
			map.put("message","回复成功");
		}else {
			map.put("success",false);
			map.put("message","回复失败");
		}
		return map;
	}
	
	/*
	 * 查询回复数
	 * By PostbarId
	 * http://localhost:8021/postbarReply/getPostbarReplyCountByPostbarId?postbarReplyPostbarId=1
	 */
	@RequestMapping("/getPostbarReplyCountByPostbarId")
	public int getPostbarReplyCountByPostbarId(Integer postbarReplyPostbarId) {
		return postbarReplyService.getPostbarReplyCountByPostbarId(postbarReplyPostbarId);
	}
	
	/*
	 * 查询回复数
	 * By uId
	 * http://localhost:8021/postbarReply/getPostbarReplyCountByuId?uId=1
	 */
	@RequestMapping("/getPostbarReplyCountByuId")
	public int getPostbarReplyCountByuId(Integer uId) {
		return postbarReplyService.getPostbarReplyCountByuId(uId);
	}
	
	/*
	 * 查询最后回复的uId和时间
	 * http://localhost:8021/postbarReply/getLastPostbarReply?PostbarReplyPostbarId=1
	 */
	@RequestMapping("/getLastPostbarReply")
	public PostbarReply getLastPostbarReply(Integer postbarReplyPostbarId) {
		return postbarReplyService.getLastPostbarReply(postbarReplyPostbarId);
	}
	
	/*
	 * 删除自己发表的回复
	 * 并且删除回复的评论
	 * http://localhost:8021/postbarReply/deletePostbarReply?uId=1&PostbarReplyId=1
	 * 
	 */
	@RequestMapping("/deletePostbarReply")
	public Object deletePostbarReply(Integer uId,Integer postbarReplyId) {
		System.out.println(uId+"uiuiuiuiuuiu"+postbarReplyId);
		int a = postbarCommentService.deletePostbarCommentByPostbarCommentPostbarReplyId(postbarReplyId);
		System.out.println(a);
		Map<String, Object> map = new HashMap<>();
		if(a>=0) {
			System.out.println("aaa");
			int b = postbarReplyService.deletePostbarReply(uId, postbarReplyId);
			System.out.println(b);
			if(b>0) {
				map.put("success",true);
				map.put("message","删除成功");
			}else {
				map.put("success",false);
				map.put("message","删除失败");
			}
		}else {
			map.put("success",false);
			map.put("message","删除失败");
		}
		return map;
	}
	
	/*
	 * 查询被回复和评论数
	 * http://localhost:8021/postbarReply/getReplyedAndCommentedCountByuId?uId=1
	 */
	@RequestMapping("/getReplyedAndCommentedCountByuId")
	public int getReplyedAndCommentedCountByuId(Integer uId) {
		int a = postbarReplyService.getPostbarReplyedCountByuId(uId);
		int b = postbarCommentService.getPostbarCommentedCountByuId(uId);
		return a+b;
	}
	
	/*
	 * http://localhost:8021/postbarReply/getPostbarReplyPage?page=1&rows=10
	 */
	@RequestMapping("/getPostbarReplyPage")
	public Object getPostbarReplyPage(Integer page,Integer rows) {
		if(page==0) {
			page=1;
		}
		Page<PostbarReply> pages = postbarReplyService.getPostbarReplyPage(page-1, rows);
		Long total = pages.getTotalElements();
		List<PostbarReply> list = pages.getContent();
		Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}
	/*
	 * 回复分页
	 * http://localhost:8021/postbarReply/getPostbarReplyPageByPostbarReplyPostbarId?postbarReplyPostbarId=2&page=1&rows=2
	 */
	@RequestMapping("/getPostbarReplyPageByPostbarReplyPostbarId")
	public Object getPostbarReplyPageByPostbarReplyPostbarId(Integer postbarReplyPostbarId,Integer page,Integer rows) {
		if(page==0) {
			page=1;
		}
		Page<PostbarReply> pages = postbarReplyService.getPostbarReplyPageByPostbarReplyPostbarId(postbarReplyPostbarId,page-1, rows);
		Long total = pages.getTotalElements();
		List<PostbarReply> list = pages.getContent();
		Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}
	
	/**
	 * 个人中心回复分页
	 * http://localhost:8021/postbarReply/getPostbarReplyPageByuId?uId=1&page=1&rows=2
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@RequestMapping("/getPostbarReplyPageByuId")
	public Object getPostbarReplyPageByuId(Integer uId,Integer page,Integer rows){
		if(page==0) {
			page=1;
		}
		Page<PostbarReply> pages = postbarReplyService.getPostbarReplyPageByuId(uId,page-1, rows);
		Long total = pages.getTotalElements();
		List<PostbarReply> list = pages.getContent();
		Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}
}
