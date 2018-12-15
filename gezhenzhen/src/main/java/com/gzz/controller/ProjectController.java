package com.gzz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.Project;
import com.gzz.service.ProjectService;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
	@Autowired
	private ProjectService service;
	
	/**
	 * 查询所有的主题
	 * http://localhost:8021/project/getProjectPage?page=1&rows=2&projectCreatetime=2017-10-11
	 * @param page页数
	 * @param rows一页显示多少条
	 * @return
	 */
	@RequestMapping("/getProjectPage")
	public Object getProjectPage(String projectCreatetime,Integer page,Integer rows) {
		System.out.println("page====>" + page);
		System.out.println("rows====>" + rows);
		Page<Project> page2 = null;
		page2 = service.findAll (projectCreatetime,(page - 1), rows);
		Long total = page2.getTotalElements();
		List<Project> rows2 = page2.getContent();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows2);
		return map;
	}
	/**
	 * 修改主题
	 * http://localhost:8020/project/postProject?projectTitle=学习&projectContent=如何的学习&projectId=1
	 * @param projectTitle  帖子的标题
	 * @param projectContent  帖子的内容
	 * @param projectId  帖子的id
	 * @return
	 */
	@RequestMapping("/postProject")
	public Object postProject(String projectTitle,String projectContent,Integer projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n=service.postProject(projectTitle, projectContent, projectId);
		if (n>0) {
			map.put("success", true);
			map.put("msg", "修改成功");
		}else {
			map.put("success", false);
			map.put("msg", "修改失败");
		}
		return map;
	}
	/**
	 * 发表主题
	 * http://localhost:8021/project/putProjectss?clazzId=2&projectContent=上课的好好的听讲，课下多多练习&projectCreatetime=2016-01-12&String projectTitle=如何学习2222&projectUid=2&moduleId=1
	 * http://localhost:8021/project/putProjectss?projectContent=222&projectCreatetime=2016-07-12&projectTitle=5555&projectUid=3&moduleId=2
	 * @param clazzId课件的id
	 * @param projectContent主题的内容
	 * @param projectCreatetime发表的时间
	 * @param projectTitle主题的标题
	 * @param projectUid用户的id
	 * @param moduleId所属模块的id
	 * @return
	 */
	@RequestMapping("/putProjectss")
	public Object putProjects(Integer clazzId,String projectContent,String projectCreatetime,String projectTitle,Integer projectUid,Integer moduleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (moduleId==1) {
			int n=service.putProject(clazzId, projectContent, projectCreatetime, projectTitle, projectUid, moduleId);
			if (n>0) {
				map.put("success", true);
				map.put("msg", "发表成功");
			} else {
				map.put("success", false);
				map.put("msg", "发表失败");
			}	
		}else {
			int m=service.putProjects(projectContent, projectCreatetime, projectTitle, projectUid, moduleId);
			if (m>0) {
				map.put("success", true);
				map.put("msg", "发表成功");
			} else {
				map.put("success", false);
				map.put("msg", "发表失败");
			}
		}
		return map;
	}

	/**
	 * http://localhost:8021/project/getProjectStatePage?projectState=0&uId=3
	 * @param projectState是否关注
	 * @param uId用户的id
	 * @return
	 */
	@RequestMapping("/getProjectStatePage")
	public Object getProjectStatePage(Integer projectState,Integer uId) {
		List<Project> list=new ArrayList<>();
		list=service.getProjectByProjectState(projectState, uId);	
		return list;
	}
}
