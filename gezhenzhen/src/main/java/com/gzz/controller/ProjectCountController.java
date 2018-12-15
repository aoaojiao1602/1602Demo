package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.ProjectCount;
import com.gzz.service.ProjectCountService;

@RestController
@RequestMapping("/projectCount")
@CrossOrigin
public class ProjectCountController {
	@Autowired 
	private ProjectCountService service;
	/**
	 * http://localhost:8021/projectCount/putProjectCount?projectId=1&projectCountUids=2
	 * @param projectId主题的id
	 * @param projectCountUid用户的id
	 * @return
	 */
	@RequestMapping("/putProjectCount")
	public Object putProjectCount(Integer projectId, Integer projectCountUids) {
		Map<String, Object> map = new HashMap<String, Object>();
		//查询当前用户有没有对该主题进行点赞
		System.out.println("!!!!!!");
		int count=service.getUid(projectId, projectCountUids);
		System.out.println("nnnnn===>"+count);
		if (count>0) {
			//如果当前用户已经对该主题进行了点赞则进行取消点赞
			service.deleteProjectCount(projectId, projectCountUids);
			map.put("success", false);
			map.put("msg", "该用户已点过赞,再次点击是取消点赞");
		}else {
			//对主题进行点赞
			service.putProjectCount(projectId, projectCountUids);
			map.put("success", true);
			map.put("msg", "点赞成功");
		}
		return map;
	}

}
