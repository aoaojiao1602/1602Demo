package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarNotGood;
import com.gzz.service.PostbarNotGoodService;

@RestController
@RequestMapping("/postbarNotGood")
public class PostbarNotGoodController {
	
	@Autowired
	private PostbarNotGoodService postbarNotGoodService;
	
	/*
	 * 踩帖
	 * http://localhost:8021/postbarNotGood/postNotGoodPostbar?postbarNotGoodPostbarId=1&uId=1
	 */
	@RequestMapping("/postNotGoodPostbar")
	public Object postNotGoodPostbar(Integer postbarNotGoodPostbarId,Integer uId) {
		PostbarNotGood a = postbarNotGoodService.getPostbarNotGood(postbarNotGoodPostbarId, uId);
		Map<String, Object> map = new HashMap<>();
		if(a!=null) {
			int b = postbarNotGoodService.deletePostbarNotGood(postbarNotGoodPostbarId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","取消踩帖成功");
			}else {
				map.put("success",false);
				map.put("message","取消踩帖失败");
			}
		}else {
			int b = postbarNotGoodService.putPostbarNotGood(postbarNotGoodPostbarId, uId);
			if(b>0) {
				map.put("success",true);
				map.put("message","踩帖成功");
			}else {
				map.put("success",false);
				map.put("message","踩帖失败");
			}
		}
		return map;
	}
	
	/*
	 * 查询踩帖数
	 * http://localhost:8021/postbarNotGood/getPostbarNotGoodCount?postbarNotGoodPostbarId=1
	 */
	@RequestMapping("/getPostbarNotGoodCount")
	public int getPostbarNotGoodCount(Integer postbarNotGoodPostbarId) {
		return postbarNotGoodService.getPostbarNotGoodCount(postbarNotGoodPostbarId);
	}
}
