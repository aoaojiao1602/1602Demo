package com.gzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.Postbar;
import com.gzz.entity.PostbarReply;
import com.gzz.service.PostbarCommentGoodService;
import com.gzz.service.PostbarCommentService;
import com.gzz.service.PostbarGoodService;
import com.gzz.service.PostbarReplyGoodService;
import com.gzz.service.PostbarReplyService;
import com.gzz.service.PostbarService;

@RestController
@RequestMapping("/postbar")
public class PostbarController {
	
	@Autowired
	private PostbarService postbarService;
	
	@Autowired
	private PostbarReplyService postbarReplyService;
	
	@Autowired
	private PostbarCommentService postbarCommentService;
	
	@Autowired
	private PostbarGoodService postbarGoodService;
	
	@Autowired
	private PostbarReplyGoodService postbarReplyGoodService;
	
	@Autowired
	private PostbarCommentGoodService postbarCommentGoodService;
	
	/*
	 * 发布帖子
	 * http://localhost:8021/postbar/putPostbar?uId=1&postbarTitle=1123&postbarContent=21131515
	 */
	@RequestMapping("/putPostbar")
	public Object putPostbar(Integer uId, String postbarTitle,String postbarContent) {
		int a = postbarService.putPostbar(1, postbarTitle, postbarContent);
		Map<String, Object> map = new HashMap<>();
		if(a>0) {
			map.put("success",true);
			map.put("message","发布成功");
		}else {
			map.put("success",false);
			map.put("message","发布失败");
		}
		return map;
	}
	
	/*
	 * 修改本人发布的帖子
	 * http://localhost:8021/postbar/postPostbar?postbarTitle=sdadas&postbarContent=gdnjgksd&postbarId=1&uId=1
	 */
	@RequestMapping("/postPostbar")
	public Object postPostbar (String postbarTitle,String postbarContent, Integer postbarId, Integer uId) {
		int a = postbarService.postPostbar(postbarTitle, postbarContent, postbarId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a>0) {
			map.put("success",true);
			map.put("message","修改成功");
		}else {
			map.put("success",false);
			map.put("message","修改失败");
		}
		return map;
	}
	
	/*
	 * 查询主题数
	 * http://localhost:8021/postbar/getPostbarTitleCount?uId=1
	 */
	@RequestMapping("/getPostbarTitleCount")
	public int getPostbarTitleCount(Integer uId) {
		return postbarService.getPostbarTitleCount(uId);
	}
	
	/*
	 * 查询帖子主题
	 * http://localhost:8021/postbar/getPostbarTitle?uId=1
	 */
	@RequestMapping("/getPostbarTitle")
	public List<Postbar> getPostbarTitle(Integer uId) {
		return postbarService.getPostbarTitle(uId);
	}
	
	/*
	 * http://localhost:8021/postbar/getPostbar??page=1&rows=10
	 */
	/*@RequestMapping("/getPostbar")
	public Object getPostbar(Integer page,Integer rows) {
		if(page==0) {
			page=1;
		}
		Page<Postbar> pages = postbarService.getPostbar(page-1, rows);
		Long total = pages.getTotalElements();
    	List<Postbar> list = pages.getContent();
    	Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}*/
	
	/*
	 * 查询自己发表的主题、回复和评论数
	 * by uId
	 * http://localhost:8021/postbar/getPostbarAndReplyAndCommentCountByuId?uId=1
	 */
	@RequestMapping("/getPostbarAndReplyAndCommentCountByuId")
	private int getPostbarAndReplyAndCommentCountByuId(Integer uId) {
		int a = postbarService.getPostbarTitleCount(uId);
		int b = postbarReplyService.getPostbarReplyCountByuId(uId);
		int c = postbarCommentService.getPostbarCommentCountByuId(uId);
		return a+b+c;
	}

	/*
	 * 查询获赞数
	 * by uId
	 * http://localhost:8021/postbar/getPostbarAndReplyAndCommentGoodCountByuId?uId=1
	 */
	@RequestMapping("/getPostbarAndReplyAndCommentGoodCountByuId")
	public int getPostbarAndReplyAndCommentGoodCountByuId(Integer uId) {
		int a = postbarGoodService.getPostbarGoodCountByuId(uId);
		int b = postbarReplyGoodService.getPostbarReplyGoodCountByuId(uId);
		int c = postbarCommentGoodService.getPostbarCommentGoodCountByuId(uId);
		return a+b+c;
	}
	
	/*
	 * 查询主贴内容
	 * http://localhost:8021/postbar/getPostbar?postbarId=1
	 */
	@RequestMapping(value="/getPostbar")
	public Object getPostbar(Integer postbarId) {
		Postbar postbar = postbarService.getPostbar(postbarId);
		return postbar;
	}
	
	/*
	 * 首页精彩讨论
	 * http://localhost:8021/postbar/getHotPostbar
	 */
	@RequestMapping("/getHotPostbar")
	public Postbar getHotPostbar() {
		return postbarService.getHotPostbar();
	}
	
	/**
	 * 个人中心主贴分页
	 * http://localhost:8021/postbar/getPostbarPageByuId?uId=1&page=1&rows=1
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@RequestMapping("/getPostbarPageByuId")
	public Object getPostbarPageByuId(Integer uId,Integer page,Integer rows){
		if(page==0) {
			page=1;
		}
		Page<Postbar> pages = postbarService.getPostbarPageByuId(uId,page-1,rows);
		Long total = pages.getTotalElements();
		List<Postbar> list = pages.getContent();
		Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}
	
	/**
	 * http://localhost:8021/postbar/getPostbarPage?page=1&rows=5
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getPostbarPage")
	public Object getPostbarPage(String postbarCreateTime,Integer page,Integer rows){
		if(page==0) {
			page=1;
		}
		
		Page<Postbar> pages = postbarService.findAll(postbarCreateTime,page-1,rows);
		Long total = pages.getTotalElements();
		List<Postbar> list = pages.getContent();
		Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	System.out.println(total+"aaaa"+list);
    	return map;
	}
}
