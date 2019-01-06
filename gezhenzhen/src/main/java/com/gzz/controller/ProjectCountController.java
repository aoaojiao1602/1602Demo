package com.gzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.Project;
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
		//查询当前用户有没有进行点踩
		int n=service.getUidCount(projectId, projectCountUids);
		if (n>0) {
			map.put("success", false);
			map.put("msg", "该用户对主题进行过点踩则不能进行点赞了");
		} else {
			//查询当前用户有没有对该主题进行点赞
			System.out.println("!!!!!!");
			int count=service.getUid(projectId, projectCountUids);
			System.out.println("nnnnn===>"+count);
			if (count>0) {
				System.out.println("project>>>>>"+projectId);
				System.out.println("projectCountUids>>>>>"+projectCountUids);
				//如果当前用户已经对该主题进行了点赞则进行取消点赞
				int s=service.deleteProjectCount(projectId, projectCountUids);
				
				System.out.println("sss>"+s);
				map.put("success", false);
				map.put("msg", "该用户已点过赞,再次点击是取消点赞");
			}else {
				//对主题进行点赞
				service.putProjectCount(projectId, projectCountUids);
				map.put("success", true);
				map.put("msg", "点赞成功");
			}

		}
		
		return map;
	}
	
	
	/**
	 * 按照投票数进行查询
	 * http://localhost:8021/projectCount/getProjectCount
	 * @param page页数
	 * @param rows一页显示多少条
	 * @return
	 */
	/*@RequestMapping("/getProjectCount")
	public Object getProjectCount(Integer page,Integer rows) {
		System.out.println("page====>" + page);
		System.out.println("rows====>" + rows);
		Page<Project> page2 = null;
		page2 = service.getProjectCount(page-1, rows);
		System.out.println(page2+">>>>>>>>>>>>");
		Long total = page2.getTotalElements();
		List<Project> rows2 = page2.getContent();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows2);
		System.out.println(rows2);
		return map;
	}*/

}
