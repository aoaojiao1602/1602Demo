package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarGood;
import com.gzz.service.PostbarGoodService;

@RestController
@RequestMapping("/postbarGood")
public class PostbarGoodController {
	
	@Autowired
	private PostbarGoodService postbarGoodService;
	/*
	 * 顶贴
	 * http://localhost:8021/postbarGood/postGoodPostbar?postbarGoodPostbarId=1&uId=1
	 */
	@RequestMapping("/postGoodPostbar")
	public Object postGoodPostbar(Integer postbarGoodPostbarId, Integer uId) {
		PostbarGood a = postbarGoodService.getPostbarGood(postbarGoodPostbarId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a!=null) {
			int b = postbarGoodService.deletePostbarGood(postbarGoodPostbarId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","取消点赞成功");
			}else {
				map.put("success",false);
				map.put("message","取消点赞失败");
			}
		}else {
			int b = postbarGoodService.putPostbarGood(postbarGoodPostbarId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","点赞成功");
			}else {
				map.put("success",false);
				map.put("message","点赞失败");
			}
		}
		return map;
	}
	
	/*
	 * 查询点赞数
	 * http://localhost:8021/postbarGood/getPostbarGoodCountByPostbarId?postbarGoodPostbarId=1
	 */
	@RequestMapping("/getPostbarGoodCountByPostbarId")
	public int getPostbarGoodCountByPostbarId(Integer postbarGoodPostbarId) {
		return postbarGoodService.getPostbarGoodCountByPostbarId(postbarGoodPostbarId);
	}
	
	/*
	 * 查询点赞数
	 * http://localhost:8021/postbarGood/getPostbarGoodCountByuId?uId=1
	 */
	@RequestMapping("/getPostbarGoodCountByuId")
	public int getPostbarGoodCountByuId(Integer uId) {
		return postbarGoodService.getPostbarGoodCountByuId(uId);
	}
}
